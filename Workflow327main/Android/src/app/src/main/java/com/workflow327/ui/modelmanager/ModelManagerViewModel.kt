/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.workflow327.ui.modelmanager

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workflow327.AppLifecycleProvider
import com.workflow327.data.Accelerator
import com.workflow327.data.Config
import com.workflow327.data.DataStoreRepository
import com.workflow327.data.EMPTY_MODEL
import com.workflow327.data.IMPORTS_DIR
import com.workflow327.data.Model
import com.workflow327.data.TASKS
import com.workflow327.data.TASK_LLM_ASK_AUDIO
import com.workflow327.data.TASK_LLM_ASK_IMAGE
import com.workflow327.data.TASK_LLM_CHAT
import com.workflow327.data.TASK_LLM_PROMPT_LAB
import com.workflow327.data.TASK_WORKFLOW_EXECUTOR
import com.workflow327.data.TASK_MULTIMODAL_ASSISTANT
import com.workflow327.data.Task
import com.workflow327.data.TaskType
import com.workflow327.data.createLlmChatConfigs
import com.workflow327.data.getModelByName
import com.workflow327.data.processTasks
import com.workflow327.proto.AccessTokenData
import com.workflow327.proto.ImportedModel
import com.workflow327.proto.Theme
import com.workflow327.ui.common.AuthConfig
import com.workflow327.ui.llmchat.LlmChatModelHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "AGModelManagerViewModel"
private const val TEXT_INPUT_HISTORY_MAX_SIZE = 50

data class ModelInitializationStatus(
  val status: ModelInitializationStatusType,
  var error: String = "",
)

enum class ModelInitializationStatusType {
  NOT_INITIALIZED,
  INITIALIZING,
  INITIALIZED,
  ERROR,
}

enum class TokenStatus {
  NOT_STORED,
  EXPIRED,
  NOT_EXPIRED,
}

enum class TokenRequestResultType {
  FAILED,
  SUCCEEDED,
  USER_CANCELLED,
}

data class TokenStatusAndData(val status: TokenStatus, val data: AccessTokenData?)

data class TokenRequestResult(val status: TokenRequestResultType, val errorMessage: String? = null)

data class ModelDownloadProgress(
  val isDownloading: Boolean = false,
  val currentModel: String = "",
  val progress: Float = 0f,
  val error: String = "",
  val step: String = "" // "M1" or "M2" or "Complete"
)

data class ModelManagerUiState(
  /** A list of tasks available in the application. */
  val tasks: List<Task>,

  /** A map that tracks the initialization status of each model, indexed by model name. */
  val modelInitializationStatus: Map<String, ModelInitializationStatus>,

  /** The currently selected model. */
  val selectedModel: Model = EMPTY_MODEL,

  /** The history of text inputs entered by the user. */
  val textInputHistory: List<String> = listOf(),

  /** Download progress state for background model downloads. */
  val downloadProgress: ModelDownloadProgress = ModelDownloadProgress(),
)

data class PagerScrollState(val page: Int = 0, val offset: Float = 0f)

/**
 * ViewModel responsible for managing models, their download status, and initialization.
 *
 * This ViewModel handles model-related operations such as downloading, deleting, initializing, and
 * cleaning up models. It also manages the UI state for model management, including the list of
 * tasks, models, download statuses, and initialization statuses.
 */
@HiltViewModel
open class ModelManagerViewModel
@Inject
constructor(
  private val dataStoreRepository: DataStoreRepository,
  private val lifecycleProvider: AppLifecycleProvider,
  @ApplicationContext private val context: Context,
) : ViewModel() {
  private val externalFilesDir = context.getExternalFilesDir(null)
  protected val _uiState = MutableStateFlow(createEmptyUiState())
  val uiState = _uiState.asStateFlow()

  var curAccessToken: String = ""

  var pagerScrollState: MutableStateFlow<PagerScrollState> = MutableStateFlow(PagerScrollState())

  init {
    initializeLocalModels()
  }

  override fun onCleared() {
    super.onCleared()
  }

  fun selectModel(model: Model) {
    _uiState.update { _uiState.value.copy(selectedModel = model) }
  }


  fun deleteModel(task: Task, model: Model) {
    if (model.imported) {
      deleteFileFromExternalFilesDir(model.downloadFileName)
    } else {
      deleteDirFromExternalFilesDir(model.normalizedName)
    }

    // Delete model from the list if model is imported as a local model.
    if (model.imported) {
      for (curTask in TASKS) {
        val index = curTask.models.indexOf(model)
        if (index >= 0) {
          curTask.models.removeAt(index)
        }
        curTask.updateTrigger.value = System.currentTimeMillis()
      }

      // Update data store.
      val importedModels = dataStoreRepository.readImportedModels().toMutableList()
      val importedModelIndex = importedModels.indexOfFirst { it.fileName == model.name }
      if (importedModelIndex >= 0) {
        importedModels.removeAt(importedModelIndex)
      }
      dataStoreRepository.saveImportedModels(importedModels = importedModels)
    }
    val newUiState = uiState.value.copy(tasks = uiState.value.tasks.toList())
    _uiState.update { newUiState }
  }

  fun initializeModel(context: Context, task: Task, model: Model, force: Boolean = false) {
    viewModelScope.launch(Dispatchers.Default) {
      // Skip if initialized already.
      if (
        !force &&
          uiState.value.modelInitializationStatus[model.name]?.status ==
            ModelInitializationStatusType.INITIALIZED
      ) {
        Log.d(TAG, "Model '${model.name}' has been initialized. Skipping.")
        return@launch
      }

      // Skip if initialization is in progress.
      if (model.initializing) {
        model.cleanUpAfterInit = false
        Log.d(TAG, "Model '${model.name}' is being initialized. Skipping.")
        return@launch
      }

      // Clean up.
      cleanupModel(task = task, model = model)

      // Start initialization.
      Log.d(TAG, "Initializing model '${model.name}'...")
      model.initializing = true

      // Show initializing status after a delay. When the delay expires, check if the model has
      // been initialized or not. If so, skip.
      launch {
        delay(500)
        if (model.instance == null && model.initializing) {
          updateModelInitializationStatus(
            model = model,
            status = ModelInitializationStatusType.INITIALIZING,
          )
        }
      }

      val onDone: (error: String) -> Unit = { error ->
        model.initializing = false
        if (model.instance != null) {
          Log.d(TAG, "Model '${model.name}' initialized successfully")
          updateModelInitializationStatus(
            model = model,
            status = ModelInitializationStatusType.INITIALIZED,
          )
          if (model.cleanUpAfterInit) {
            Log.d(TAG, "Model '${model.name}' needs cleaning up after init.")
            cleanupModel(task = task, model = model)
          }
        } else if (error.isNotEmpty()) {
          Log.d(TAG, "Model '${model.name}' failed to initialize")
          updateModelInitializationStatus(
            model = model,
            status = ModelInitializationStatusType.ERROR,
            error = error,
          )
        }
      }
      when (task.type) {
        TaskType.LLM_CHAT,
        TaskType.LLM_ASK_IMAGE,
        TaskType.LLM_ASK_AUDIO,
        TaskType.LLM_PROMPT_LAB,
        TaskType.WORKFLOW_EXECUTOR,
        TaskType.MULTIMODAL_ASSISTANT,
        TaskType.WORKFLOW_ASSISTANT ->
          LlmChatModelHelper.initialize(context = context, model = model, onDone = onDone)

        TaskType.TEST_TASK_1 -> {}
        TaskType.TEST_TASK_2 -> {}
        else -> {}
      }
    }
  }

  fun cleanupModel(task: Task, model: Model) {
    if (model.instance != null) {
      model.cleanUpAfterInit = false
      Log.d(TAG, "Cleaning up model '${model.name}'...")
      when (task.type) {
        TaskType.LLM_CHAT,
        TaskType.LLM_PROMPT_LAB,
        TaskType.LLM_ASK_IMAGE,
        TaskType.LLM_ASK_AUDIO,
        TaskType.WORKFLOW_EXECUTOR,
        TaskType.MULTIMODAL_ASSISTANT,
        TaskType.WORKFLOW_ASSISTANT -> LlmChatModelHelper.cleanUp(model = model)

        TaskType.TEST_TASK_1 -> {}
        TaskType.TEST_TASK_2 -> {}
        else -> {}
      }
      model.instance = null
      model.initializing = false
      updateModelInitializationStatus(
        model = model,
        status = ModelInitializationStatusType.NOT_INITIALIZED,
      )
    } else {
      // When model is being initialized and we are trying to clean it up at same time, we mark it
      // to clean up and it will be cleaned up after initialization is done.
      if (model.initializing) {
        model.cleanUpAfterInit = true
      }
    }
  }


  fun addTextInputHistory(text: String) {
    if (uiState.value.textInputHistory.indexOf(text) < 0) {
      val newHistory = uiState.value.textInputHistory.toMutableList()
      newHistory.add(0, text)
      if (newHistory.size > TEXT_INPUT_HISTORY_MAX_SIZE) {
        newHistory.removeAt(newHistory.size - 1)
      }
      _uiState.update { _uiState.value.copy(textInputHistory = newHistory) }
      dataStoreRepository.saveTextInputHistory(_uiState.value.textInputHistory)
    } else {
      promoteTextInputHistoryItem(text)
    }
  }

  fun promoteTextInputHistoryItem(text: String) {
    val index = uiState.value.textInputHistory.indexOf(text)
    if (index >= 0) {
      val newHistory = uiState.value.textInputHistory.toMutableList()
      newHistory.removeAt(index)
      newHistory.add(0, text)
      _uiState.update { _uiState.value.copy(textInputHistory = newHistory) }
      dataStoreRepository.saveTextInputHistory(_uiState.value.textInputHistory)
    }
  }

  fun deleteTextInputHistory(text: String) {
    val index = uiState.value.textInputHistory.indexOf(text)
    if (index >= 0) {
      val newHistory = uiState.value.textInputHistory.toMutableList()
      newHistory.removeAt(index)
      _uiState.update { _uiState.value.copy(textInputHistory = newHistory) }
      dataStoreRepository.saveTextInputHistory(_uiState.value.textInputHistory)
    }
  }

  fun clearTextInputHistory() {
    _uiState.update { _uiState.value.copy(textInputHistory = mutableListOf()) }
    dataStoreRepository.saveTextInputHistory(_uiState.value.textInputHistory)
  }

  fun readThemeOverride(): Theme {
    return dataStoreRepository.readTheme()
  }

  fun saveThemeOverride(theme: Theme) {
    dataStoreRepository.saveTheme(theme = theme)
  }

  fun getModelUrlResponse(model: Model, accessToken: String? = null): Int {
    try {
      val url = URL(model.url)
      val connection = url.openConnection() as HttpURLConnection
      if (accessToken != null) {
        connection.setRequestProperty("Authorization", "Bearer $accessToken")
      }
      connection.connect()

      // Report the result.
      return connection.responseCode
    } catch (e: Exception) {
      Log.e(TAG, "$e")
      return -1
    }
  }

  fun addImportedLlmModel(info: ImportedModel) {
    Log.d(TAG, "adding imported llm model: $info")

    // Create model.
    val model = createModelFromImportedModelInfo(info = info)

    for (task in
      listOf(TASK_LLM_ASK_IMAGE, TASK_LLM_ASK_AUDIO, TASK_LLM_PROMPT_LAB, TASK_LLM_CHAT, TASK_WORKFLOW_EXECUTOR, TASK_MULTIMODAL_ASSISTANT)) {
      // Remove duplicated imported model if existed.
      val modelIndex = task.models.indexOfFirst { info.fileName == it.name && it.imported }
      if (modelIndex >= 0) {
        Log.d(TAG, "duplicated imported model found in task. Removing it first")
        task.models.removeAt(modelIndex)
      }
      if (
        (task == TASK_LLM_ASK_IMAGE && model.llmSupportImage) ||
          (task == TASK_LLM_ASK_AUDIO && model.llmSupportAudio) ||
          (task == TASK_MULTIMODAL_ASSISTANT && (model.llmSupportImage || model.llmSupportAudio)) ||
          (task != TASK_LLM_ASK_IMAGE && task != TASK_LLM_ASK_AUDIO && task != TASK_MULTIMODAL_ASSISTANT)
      ) {
        task.models.add(model)
      }
      task.updateTrigger.value = System.currentTimeMillis()
    }

    // Add initial status and states.
    val modelInstances = uiState.value.modelInitializationStatus.toMutableMap()
    modelInstances[model.name] =
      ModelInitializationStatus(status = ModelInitializationStatusType.NOT_INITIALIZED)

    // Update ui state.
    _uiState.update {
      uiState.value.copy(
        tasks = uiState.value.tasks.toList(),
        modelInitializationStatus = modelInstances,
      )
    }

    // Add to data store.
    val importedModels = dataStoreRepository.readImportedModels().toMutableList()
    val importedModelIndex = importedModels.indexOfFirst { info.fileName == it.fileName }
    if (importedModelIndex >= 0) {
      Log.d(TAG, "duplicated imported model found in data store. Removing it first")
      importedModels.removeAt(importedModelIndex)
    }
    importedModels.add(info)
    dataStoreRepository.saveImportedModels(importedModels = importedModels)
  }

  fun getTokenStatusAndData(): TokenStatusAndData {
    // Try to load token data from DataStore.
    var tokenStatus = TokenStatus.NOT_STORED
    Log.d(TAG, "Reading token data from data store...")
    val tokenData = dataStoreRepository.readAccessTokenData()

    // Token exists.
    if (tokenData != null) {
      Log.d(TAG, "Token exists and loaded.")

      // Check expiration (with 5-minute buffer).
      val curTs = System.currentTimeMillis()
      val expirationTs = tokenData.expiresAtMs - 5 * 60
      Log.d(
        TAG,
        "Checking whether token has expired or not. Current ts: $curTs, expires at: $expirationTs",
      )
      if (curTs >= expirationTs) {
        Log.d(TAG, "Token expired!")
        tokenStatus = TokenStatus.EXPIRED
      } else {
        Log.d(TAG, "Token not expired.")
        tokenStatus = TokenStatus.NOT_EXPIRED
        curAccessToken = tokenData.accessToken
      }
    } else {
      Log.d(TAG, "Token doesn't exists.")
    }

    return TokenStatusAndData(status = tokenStatus, data = tokenData)
  }


  fun saveAccessToken(accessToken: String, refreshToken: String, expiresAt: Long) {
    dataStoreRepository.saveAccessTokenData(
      accessToken = accessToken,
      refreshToken = refreshToken,
      expiresAt = expiresAt,
    )
  }

  fun clearAccessToken() {
    dataStoreRepository.clearAccessTokenData()
  }


  private fun initializeLocalModels() {
    viewModelScope.launch(Dispatchers.IO) {
      try {
        Log.d(TAG, "Initializing local models...")
        
        // Clear any existing models
        TASK_LLM_CHAT.models.clear()
        TASK_LLM_PROMPT_LAB.models.clear()
        TASK_LLM_ASK_IMAGE.models.clear()
        TASK_LLM_ASK_AUDIO.models.clear()
        TASK_WORKFLOW_EXECUTOR.models.clear()
        TASK_MULTIMODAL_ASSISTANT.models.clear()

        // Pre-process all tasks (this will load imported models from storage)
        processTasks()

        // Update UI state
        _uiState.update { createUiState() }
        
        Log.d(TAG, "Local models initialized successfully")
      } catch (e: Exception) {
        Log.e(TAG, "Failed to initialize local models", e)
      }
    }
  }

  fun updateDownloadProgress(
    isDownloading: Boolean = false,
    currentModel: String = "",
    progress: Float = 0f,
    error: String = "",
    step: String = ""
  ) {
    _uiState.update {
      it.copy(
        downloadProgress = ModelDownloadProgress(
          isDownloading = isDownloading,
          currentModel = currentModel,
          progress = progress,
          error = error,
          step = step
        )
      )
    }
  }

  fun setAppInForeground(foreground: Boolean) {
    lifecycleProvider.isAppInForeground = foreground
  }



  private fun createEmptyUiState(): ModelManagerUiState {
    return ModelManagerUiState(
      tasks = listOf(),
      modelInitializationStatus = mapOf(),
    )
  }

  private fun createUiState(): ModelManagerUiState {
    val modelInstances: MutableMap<String, ModelInitializationStatus> = mutableMapOf()
    for (task in TASKS) {
      for (model in task.models) {
        modelInstances[model.name] =
          ModelInitializationStatus(status = ModelInitializationStatusType.NOT_INITIALIZED)
      }
    }

    // Load imported models.
    for (importedModel in dataStoreRepository.readImportedModels()) {
      Log.d(TAG, "stored imported model: $importedModel")

      // Create model.
      val model = createModelFromImportedModelInfo(info = importedModel)

      // Add to task.
      TASK_LLM_CHAT.models.add(model)
      TASK_LLM_PROMPT_LAB.models.add(model)
      TASK_WORKFLOW_EXECUTOR.models.add(model)
      if (model.llmSupportImage) {
        TASK_LLM_ASK_IMAGE.models.add(model)
      }
      if (model.llmSupportAudio) {
        TASK_LLM_ASK_AUDIO.models.add(model)
      }
      if (model.llmSupportImage || model.llmSupportAudio) {
        TASK_MULTIMODAL_ASSISTANT.models.add(model)
      }

    }

    val textInputHistory = dataStoreRepository.readTextInputHistory()
    Log.d(TAG, "text input history: $textInputHistory")

    return ModelManagerUiState(
      tasks = TASKS.toList(),
      modelInitializationStatus = modelInstances,
      textInputHistory = textInputHistory,
    )
  }

  private fun createModelFromImportedModelInfo(info: ImportedModel): Model {
    val accelerators: List<Accelerator> =
      info.llmConfig.compatibleAcceleratorsList.mapNotNull { acceleratorLabel ->
        when (acceleratorLabel.trim()) {
          Accelerator.GPU.label -> Accelerator.GPU
          Accelerator.CPU.label -> Accelerator.CPU
          else -> null // Ignore unknown accelerator labels
        }
      }
    val configs: List<Config> =
      createLlmChatConfigs(
        defaultMaxToken = info.llmConfig.defaultMaxTokens,
        defaultTopK = info.llmConfig.defaultTopk,
        defaultTopP = info.llmConfig.defaultTopp,
        defaultTemperature = info.llmConfig.defaultTemperature,
        accelerators = accelerators,
      )
    val llmSupportImage = info.llmConfig.supportImage
    val llmSupportAudio = info.llmConfig.supportAudio
    val model =
      Model(
        name = info.fileName,
        url = "",
        configs = configs,
        sizeInBytes = info.fileSize,
        downloadFileName = info.fileName,
        showBenchmarkButton = false,
        showRunAgainButton = false,
        imported = true,
        llmSupportImage = llmSupportImage,
        llmSupportAudio = llmSupportAudio,
      )
    model.preProcess()

    return model
  }


  private fun isFileInExternalFilesDir(fileName: String): Boolean {
    if (externalFilesDir != null) {
      val file = File(externalFilesDir, fileName)
      return file.exists()
    } else {
      return false
    }
  }

  private fun deleteFileFromExternalFilesDir(fileName: String) {
    if (isFileInExternalFilesDir(fileName)) {
      val file = File(externalFilesDir, fileName)
      file.delete()
    }
  }

  private fun deleteDirFromExternalFilesDir(dir: String) {
    if (isFileInExternalFilesDir(dir)) {
      val file = File(externalFilesDir, dir)
      file.deleteRecursively()
    }
  }

  private fun updateModelInitializationStatus(
    model: Model,
    status: ModelInitializationStatusType,
    error: String = "",
  ) {
    val curModelInstance = uiState.value.modelInitializationStatus.toMutableMap()
    curModelInstance[model.name] = ModelInitializationStatus(status = status, error = error)
    val newUiState = uiState.value.copy(modelInitializationStatus = curModelInstance)
    _uiState.update { newUiState }
  }

  private fun isModelDownloaded(model: Model): Boolean {
    val downloadedFileExists =
      model.downloadFileName.isNotEmpty() &&
        isFileInExternalFilesDir(
          listOf(model.normalizedName, model.version, model.downloadFileName)
            .joinToString(File.separator)
        )

    val unzippedDirectoryExists =
      model.isZip &&
        model.unzipDir.isNotEmpty() &&
        isFileInExternalFilesDir(
          listOf(model.normalizedName, model.version, model.unzipDir).joinToString(File.separator)
        )

    // Will also return true if model is partially downloaded.
    return downloadedFileExists || unzippedDirectoryExists
  }
}
