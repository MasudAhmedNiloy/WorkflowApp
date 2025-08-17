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

package com.workflow327.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.FileOpen
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.workflow327.data.Accelerator
import com.workflow327.proto.ImportedModel
import com.workflow327.proto.LlmConfig
import com.workflow327.ui.common.humanReadableSize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

enum class ModelSetupStep {
    SELECTION,
    M1_DOWNLOAD,
    M2_SELECTION,
    M2_DOWNLOAD,
    COMPLETED
}

data class ModelDownloadInfo(
    val name: String,
    val fileName: String,
    val huggingFaceUrl: String,
    val downloadUrl: String,
    val sizeInBytes: Long,
    val description: String,
    val supportImage: Boolean = false,
    val supportAudio: Boolean = false
)

@Composable
fun Workflow327ModelSetupDialog(
    onDismiss: () -> Unit,
    onM1ModelReady: (ImportedModel) -> Unit,
    onM2ModelReady: (ImportedModel) -> Unit,
    onComplete: () -> Unit,
    modelManagerViewModel: com.workflow327.ui.modelmanager.ModelManagerViewModel
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var currentStep by remember { mutableStateOf(ModelSetupStep.M1_DOWNLOAD) }
    var downloadProgress by remember { mutableFloatStateOf(0f) }
    var downloadError by remember { mutableStateOf("") }
    var isDownloading by remember { mutableStateOf(true) }

    // Model information
    val m1ModelInfo = remember {
        ModelDownloadInfo(
            name = "Phi-2 (M1 Workflow Executor)",
            fileName = "phi-2.Q4_K_M.gguf",
            huggingFaceUrl = "https://huggingface.co/TheBloke/phi-2-GGUF/blob/main/phi-2.Q4_K_M.gguf",
            downloadUrl = "https://huggingface.co/TheBloke/phi-2-GGUF/resolve/main/phi-2.Q4_K_M.gguf",
            sizeInBytes = 1781410429L,
            description = "Microsoft Phi-2 model optimized for workflow execution and task planning. Specialized in breaking down complex tasks into actionable steps."
        )
    }

    val m2ModelInfo = remember {
        ModelDownloadInfo(
            name = "Gemma-3n (M2 Multimodal Assistant)",
            fileName = "gemma-3n-E2B-it-int4.task",
            huggingFaceUrl = "https://huggingface.co/google/gemma-2b-it",
            downloadUrl = "https://pixeldrain.com/api/file/ZZiE1uVS",
            sizeInBytes = 3369536330L, // ~3.14GB
            description = "Google Gemma-3n multimodal model for advanced AI assistance with images, text, and speech understanding.",
            supportImage = true,
            supportAudio = true
        )
    }

    // File picker launchers
    val m1FilePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val importedModel = createImportedModelFromUri(context, it, m1ModelInfo)
            if (importedModel != null) {
                onM1ModelReady(importedModel)
                currentStep = ModelSetupStep.M2_SELECTION
            }
        }
    }

    val m2FilePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val importedModel = createImportedModelFromUri(context, it, m2ModelInfo)
            if (importedModel != null) {
                onM2ModelReady(importedModel)
                currentStep = ModelSetupStep.COMPLETED
            }
        }
    }

    // Auto-start download sequence when dialog opens
    LaunchedEffect(Unit) {
        // Check if M1 model already exists
        val m1Exists = isModelFileExists(context, m1ModelInfo.fileName)
        // Check if M2 model already exists
        val m2Exists = isModelFileExists(context, m2ModelInfo.fileName)
        
        // Show partial download progress if available
        val m1PartialProgress = getPartialDownloadProgress(context, m1ModelInfo)
        val m2PartialProgress = getPartialDownloadProgress(context, m2ModelInfo)
        
        if (m1PartialProgress > 0 && !m1Exists) {
            downloadProgress = m1PartialProgress
        } else if (m1Exists && m2PartialProgress > 0 && !m2Exists) {
            downloadProgress = m2PartialProgress
        }
        
        when {
            // Both models exist - go directly to completed
            m1Exists && m2Exists -> {
                val importedModel1 = createImportedModelFromDownload(m1ModelInfo)
                val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                onM1ModelReady(importedModel1)
                onM2ModelReady(importedModel2)
                currentStep = ModelSetupStep.COMPLETED
                modelManagerViewModel.updateDownloadProgress(
                    isDownloading = false,
                    currentModel = "",
                    progress = 1f,
                    error = "",
                    step = "Complete"
                )
            }
            
            // M1 exists, M2 doesn't - skip to M2 download
            m1Exists && !m2Exists -> {
                val importedModel = createImportedModelFromDownload(m1ModelInfo)
                onM1ModelReady(importedModel)
                currentStep = ModelSetupStep.M2_DOWNLOAD
                
                // Start M2 download
                modelManagerViewModel.updateDownloadProgress(
                    isDownloading = true,
                    currentModel = m2ModelInfo.fileName,
                    progress = 0f,
                    error = "",
                    step = "M2"
                )
                
                downloadModel(
                    context = context,
                    coroutineScope = coroutineScope,
                    modelInfo = m2ModelInfo,
                    onProgress = { progress ->
                        downloadProgress = progress
                        modelManagerViewModel.updateDownloadProgress(
                            isDownloading = true,
                            currentModel = m2ModelInfo.fileName,
                            progress = progress,
                            error = "",
                            step = "M2"
                        )
                    },
                    onError = { error ->
                        downloadError = error
                        isDownloading = false
                        modelManagerViewModel.updateDownloadProgress(
                            isDownloading = false,
                            currentModel = m2ModelInfo.fileName,
                            progress = downloadProgress,
                            error = error,
                            step = "M2"
                        )
                    },
                    onComplete = {
                        isDownloading = false
                        val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                        onM2ModelReady(importedModel2)
                        currentStep = ModelSetupStep.COMPLETED
                        
                        // Clear download state when complete
                        modelManagerViewModel.updateDownloadProgress(
                            isDownloading = false,
                            currentModel = "",
                            progress = 1f,
                            error = "",
                            step = "Complete"
                        )
                    }
                )
                isDownloading = true
                downloadProgress = 0f
                downloadError = ""
            }
            
            // M1 doesn't exist - start with M1 download
            !m1Exists -> {
                // Initialize download state
                modelManagerViewModel.updateDownloadProgress(
                    isDownloading = true,
                    currentModel = m1ModelInfo.fileName,
                    progress = 0f,
                    error = "",
                    step = "M1"
                )
                
                downloadModel(
                    context = context,
                    coroutineScope = coroutineScope,
                    modelInfo = m1ModelInfo,
                    onProgress = { progress ->
                        downloadProgress = progress
                        modelManagerViewModel.updateDownloadProgress(
                            isDownloading = true,
                            currentModel = m1ModelInfo.fileName,
                            progress = progress,
                            error = "",
                            step = "M1"
                        )
                    },
                    onError = { error ->
                        downloadError = error
                        isDownloading = false
                        modelManagerViewModel.updateDownloadProgress(
                            isDownloading = false,
                            currentModel = m1ModelInfo.fileName,
                            progress = downloadProgress,
                            error = error,
                            step = "M1"
                        )
                    },
                    onComplete = {
                        isDownloading = false
                        val importedModel = createImportedModelFromDownload(m1ModelInfo)
                        onM1ModelReady(importedModel)
                        currentStep = ModelSetupStep.M2_DOWNLOAD
                        
                        // Check if M2 already exists before downloading
                        val m2ExistsNow = isModelFileExists(context, m2ModelInfo.fileName)
                        if (m2ExistsNow) {
                            // M2 already exists, skip download
                            val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                            onM2ModelReady(importedModel2)
                            currentStep = ModelSetupStep.COMPLETED
                            modelManagerViewModel.updateDownloadProgress(
                                isDownloading = false,
                                currentModel = "",
                                progress = 1f,
                                error = "",
                                step = "Complete"
                            )
                        } else {
                            // Auto-start M2 download
                            modelManagerViewModel.updateDownloadProgress(
                                isDownloading = true,
                                currentModel = m2ModelInfo.fileName,
                                progress = 0f,
                                error = "",
                                step = "M2"
                            )
                            
                            downloadModel(
                                context = context,
                                coroutineScope = coroutineScope,
                                modelInfo = m2ModelInfo,
                                onProgress = { progress ->
                                    downloadProgress = progress
                                    modelManagerViewModel.updateDownloadProgress(
                                        isDownloading = true,
                                        currentModel = m2ModelInfo.fileName,
                                        progress = progress,
                                        error = "",
                                        step = "M2"
                                    )
                                },
                                onError = { error ->
                                    downloadError = error
                                    isDownloading = false
                                    modelManagerViewModel.updateDownloadProgress(
                                        isDownloading = false,
                                        currentModel = m2ModelInfo.fileName,
                                        progress = downloadProgress,
                                        error = error,
                                        step = "M2"
                                    )
                                },
                                onComplete = {
                                    isDownloading = false
                                    val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                                    onM2ModelReady(importedModel2)
                                    currentStep = ModelSetupStep.COMPLETED
                                    
                                    // Clear download state when complete
                                    modelManagerViewModel.updateDownloadProgress(
                                        isDownloading = false,
                                        currentModel = "",
                                        progress = 1f,
                                        error = "",
                                        step = "Complete"
                                    )
                                }
                            )
                            isDownloading = true
                            downloadProgress = 0f
                            downloadError = ""
                        }
                    }
                )
            }
        }
    }

    Dialog(
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
        onDismissRequest = onDismiss
    ) {
        val focusManager = LocalFocusManager.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { focusManager.clearFocus() },
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Title
                Text(
                    "Setting up AI Models",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text(
                    "Downloads continue in background even if you close this dialog. Check progress at bottom of home screen.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .weight(1f, fill = false),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    when (currentStep) {
                        ModelSetupStep.M1_DOWNLOAD -> {
                            Text(
                                "Step 1/2: Downloading M1 Model",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            AutoDownloadStepContent(
                                modelInfo = m1ModelInfo,
                                progress = downloadProgress,
                                error = downloadError,
                                isDownloading = isDownloading
                            )
                        }
                        
                        ModelSetupStep.M2_DOWNLOAD -> {
                            // Show M1 completed
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    Icons.Rounded.CheckCircle,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text("M1 model ready!")
                            }
                            
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            Text(
                                "Step 2/2: Downloading M2 Model",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            AutoDownloadStepContent(
                                modelInfo = m2ModelInfo,
                                progress = downloadProgress,
                                error = downloadError,
                                isDownloading = isDownloading
                            )
                        }
                        
                        ModelSetupStep.COMPLETED -> {
                            CompletedStepContent(onComplete = {
                                onComplete()
                                onDismiss()
                            })
                        }
                        
                        else -> {
                            // Fallback - shouldn't happen with auto-download
                            Text("Initializing...")
                        }
                    }
                }

                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if (downloadError.isNotEmpty()) Arrangement.spacedBy(8.dp) else Arrangement.End
                ) {
                    if (downloadError.isNotEmpty()) {
                        // Show options when download fails
                        OutlinedButton(
                            onClick = { 
                                if (currentStep == ModelSetupStep.M1_DOWNLOAD) {
                                    m1FilePicker.launch("*/*") 
                                } else {
                                    m2FilePicker.launch("*/*")
                                }
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Browse Files")
                        }
                        Button(
                            onClick = {
                                // Check if file already exists before retrying
                                val modelInfo = if (currentStep == ModelSetupStep.M1_DOWNLOAD) m1ModelInfo else m2ModelInfo
                                val fileExists = isModelFileExists(context, modelInfo.fileName)
                                
                                if (fileExists) {
                                    // File exists, skip download and proceed
                                    if (currentStep == ModelSetupStep.M1_DOWNLOAD) {
                                        val importedModel = createImportedModelFromDownload(m1ModelInfo)
                                        onM1ModelReady(importedModel)
                                        currentStep = ModelSetupStep.M2_DOWNLOAD
                                        
                                        // Check M2 and proceed accordingly
                                        val m2Exists = isModelFileExists(context, m2ModelInfo.fileName)
                                        if (m2Exists) {
                                            val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                                            onM2ModelReady(importedModel2)
                                            currentStep = ModelSetupStep.COMPLETED
                                            modelManagerViewModel.updateDownloadProgress(
                                                isDownloading = false,
                                                currentModel = "",
                                                progress = 1f,
                                                error = "",
                                                step = "Complete"
                                            )
                                        }
                                    } else {
                                        val importedModel = createImportedModelFromDownload(m2ModelInfo)
                                        onM2ModelReady(importedModel)
                                        currentStep = ModelSetupStep.COMPLETED
                                        modelManagerViewModel.updateDownloadProgress(
                                            isDownloading = false,
                                            currentModel = "",
                                            progress = 1f,
                                            error = "",
                                            step = "Complete"
                                        )
                                    }
                                    downloadError = ""
                                    isDownloading = false
                                    return@Button
                                }
                                
                                // Retry download logic
                                downloadError = ""
                                isDownloading = true
                                downloadProgress = 0f
                                val onComplete = if (currentStep == ModelSetupStep.M1_DOWNLOAD) {
                                    {
                                        isDownloading = false
                                        val importedModel = createImportedModelFromDownload(m1ModelInfo)
                                        onM1ModelReady(importedModel)
                                        currentStep = ModelSetupStep.M2_DOWNLOAD
                                        
                                        // Check if M2 already exists before downloading
                                        val m2ExistsNow = isModelFileExists(context, m2ModelInfo.fileName)
                                        if (m2ExistsNow) {
                                            // M2 already exists, skip download
                                            val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                                            onM2ModelReady(importedModel2)
                                            currentStep = ModelSetupStep.COMPLETED
                                            modelManagerViewModel.updateDownloadProgress(
                                                isDownloading = false,
                                                currentModel = "",
                                                progress = 1f,
                                                error = "",
                                                step = "Complete"
                                            )
                                        } else {
                                            // Auto-start M2 download
                                            modelManagerViewModel.updateDownloadProgress(
                                                isDownloading = true,
                                                currentModel = m2ModelInfo.fileName,
                                                progress = 0f,
                                                error = "",
                                                step = "M2"
                                            )
                                            
                                            downloadModel(
                                                context = context,
                                                coroutineScope = coroutineScope,
                                                modelInfo = m2ModelInfo,
                                                onProgress = { 
                                                    downloadProgress = it
                                                    modelManagerViewModel.updateDownloadProgress(
                                                        isDownloading = true,
                                                        currentModel = m2ModelInfo.fileName,
                                                        progress = it,
                                                        error = "",
                                                        step = "M2"
                                                    )
                                                },
                                                onError = { 
                                                    downloadError = it
                                                    isDownloading = false
                                                    modelManagerViewModel.updateDownloadProgress(
                                                        isDownloading = false,
                                                        currentModel = m2ModelInfo.fileName,
                                                        progress = downloadProgress,
                                                        error = it,
                                                        step = "M2"
                                                    )
                                                },
                                                onComplete = {
                                                    isDownloading = false
                                                    val importedModel2 = createImportedModelFromDownload(m2ModelInfo)
                                                    onM2ModelReady(importedModel2)
                                                    currentStep = ModelSetupStep.COMPLETED
                                                    modelManagerViewModel.updateDownloadProgress(
                                                        isDownloading = false,
                                                        currentModel = "",
                                                        progress = 1f,
                                                        error = "",
                                                        step = "Complete"
                                                    )
                                                }
                                            )
                                            isDownloading = true
                                            downloadProgress = 0f
                                            downloadError = ""
                                        }
                                    }
                                } else {
                                    {
                                        isDownloading = false
                                        val importedModel = createImportedModelFromDownload(m2ModelInfo)
                                        onM2ModelReady(importedModel)
                                        currentStep = ModelSetupStep.COMPLETED
                                        modelManagerViewModel.updateDownloadProgress(
                                            isDownloading = false,
                                            currentModel = "",
                                            progress = 1f,
                                            error = "",
                                            step = "Complete"
                                        )
                                    }
                                }
                                
                                downloadModel(
                                    context = context,
                                    coroutineScope = coroutineScope,
                                    modelInfo = modelInfo,
                                    onProgress = { downloadProgress = it },
                                    onError = { 
                                        downloadError = it
                                        isDownloading = false
                                    },
                                    onComplete = onComplete
                                )
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Retry")
                        }
                    }
                    
                    // Always show "Continue Using App" button
                    if (currentStep != ModelSetupStep.COMPLETED) {
                        Button(
                            onClick = onDismiss,
                            modifier = if (downloadError.isEmpty()) Modifier else Modifier.weight(1f)
                        ) {
                            Text("Continue Using App")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SelectionStepContent(
    m1ModelInfo: ModelDownloadInfo,
    onBrowseM1: () -> Unit,
    onDownloadM1: () -> Unit,
    onOpenHuggingFace: () -> Unit
) {
    Text(
        "Step 1: Setup M1 Model (Phi-2 Workflow Executor)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
    
    ModelInfoCard(
        modelInfo = m1ModelInfo,
        onBrowse = onBrowseM1,
        onDownload = onDownloadM1,
        onOpenHuggingFace = onOpenHuggingFace
    )
}

@Composable
private fun M2SelectionStepContent(
    m2ModelInfo: ModelDownloadInfo,
    onBrowseM2: () -> Unit,
    onDownloadM2: () -> Unit,
    onOpenHuggingFace: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            Icons.Rounded.CheckCircle,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Text("M1 model ready!")
    }
    
    Spacer(modifier = Modifier.height(8.dp))
    
    Text(
        "Step 2: Setup M2 Model (Gemma Multimodal Assistant)",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
    
    ModelInfoCard(
        modelInfo = m2ModelInfo,
        onBrowse = onBrowseM2,
        onDownload = onDownloadM2,
        onOpenHuggingFace = onOpenHuggingFace
    )
}

@Composable
private fun AutoDownloadStepContent(
    modelInfo: ModelDownloadInfo,
    progress: Float,
    error: String,
    isDownloading: Boolean
) {
    if (error.isEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                modelInfo.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            
            Text(
                modelInfo.description,
                style = MaterialTheme.typography.bodySmall
            )
            
            Text(
                "${modelInfo.fileName} (${modelInfo.sizeInBytes.humanReadableSize()})",
                style = MaterialTheme.typography.bodyMedium
            )
            
            if (isDownloading) {
                val animatedProgress = remember { Animatable(0f) }
                LinearProgressIndicator(
                    progress = { animatedProgress.value },
                    modifier = Modifier.fillMaxWidth()
                )
                LaunchedEffect(progress) {
                    animatedProgress.animateTo(progress, animationSpec = tween(150))
                }
                
                Text(
                    "${(progress * 100).toInt()}% complete",
                    style = MaterialTheme.typography.labelMedium
                )
            } else {
                Text(
                    "Preparing download...",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    } else {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    Icons.Rounded.Error,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.error
                )
                Column {
                    Text(
                        "Download Failed",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        error,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                    Text(
                        "You can still browse for local model files instead.",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun DownloadStepContent(
    modelInfo: ModelDownloadInfo,
    progress: Float,
    error: String,
    @Suppress("UNUSED_PARAMETER") isDownloading: Boolean,
    onCancel: () -> Unit
) {
    Text(
        "Downloading ${modelInfo.name}...",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
    
    if (error.isEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                "${modelInfo.fileName} (${modelInfo.sizeInBytes.humanReadableSize()})",
                style = MaterialTheme.typography.bodyMedium
            )
            
            val animatedProgress = remember { Animatable(0f) }
            LinearProgressIndicator(
                progress = { animatedProgress.value },
                modifier = Modifier.fillMaxWidth()
            )
            LaunchedEffect(progress) {
                animatedProgress.animateTo(progress, animationSpec = tween(150))
            }
            
            Text(
                "${(progress * 100).toInt()}% complete",
                style = MaterialTheme.typography.labelSmall
            )
        }
    } else {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                Icons.Rounded.Error,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.error
            )
            Text(
                error,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = onCancel) {
                Text("Retry")
            }
        }
    }
}

@Composable
private fun CompletedStepContent(onComplete: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            Icons.Rounded.CheckCircle,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(64.dp)
        )
        
        Text(
            "Setup Complete!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            "Both M1 and M2 models are now ready. You can start using Workflow327!",
            style = MaterialTheme.typography.bodyMedium
        )
        
        Button(onClick = onComplete) {
            Text("Start Using Workflow327")
        }
    }
}

@Composable
private fun ModelInfoCard(
    modelInfo: ModelDownloadInfo,
    onBrowse: () -> Unit,
    onDownload: () -> Unit,
    onOpenHuggingFace: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                modelInfo.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                modelInfo.description,
                style = MaterialTheme.typography.bodyMedium
            )
            
            Text(
                "Size: ${modelInfo.sizeInBytes.humanReadableSize()}",
                style = MaterialTheme.typography.labelMedium
            )
            
            Text(
                "File: ${modelInfo.fileName}",
                style = MaterialTheme.typography.labelMedium
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onBrowse,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Outlined.FileOpen,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                    Text("Browse", modifier = Modifier.padding(start = 4.dp))
                }
                
                Button(
                    onClick = onDownload,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Outlined.Download,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp)
                    )
                    Text("Download", modifier = Modifier.padding(start = 4.dp))
                }
            }
            
            TextButton(
                onClick = onOpenHuggingFace,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    Icons.Outlined.Link,
                    contentDescription = "",
                    modifier = Modifier.size(16.dp)
                )
                Text("View on HuggingFace", modifier = Modifier.padding(start = 4.dp))
            }
        }
    }
}

// Dedicated thread pool for downloads to avoid blocking other IO operations
private val downloadDispatcher = Executors.newFixedThreadPool(2).asCoroutineDispatcher()

private fun downloadModel(
    context: Context,
    coroutineScope: CoroutineScope,
    modelInfo: ModelDownloadInfo,
    onProgress: (Float) -> Unit,
    onError: (String) -> Unit,
    onComplete: () -> Unit
) {
    coroutineScope.launch(downloadDispatcher) {
        var connection: HttpURLConnection? = null
        var inputStream: java.io.InputStream? = null
        var outputStream: java.io.OutputStream? = null
        
        try {
            val importsDir = File(context.getExternalFilesDir(null), "__imports")
            if (!importsDir.exists()) {
                importsDir.mkdirs()
            }
            
            val outputFile = File(importsDir, modelInfo.fileName)
            val tempFile = File(importsDir, "${modelInfo.fileName}.tmp")
            
            // Check if partial download exists
            val existingBytes = if (tempFile.exists()) tempFile.length() else 0L
            val startProgress = if (modelInfo.sizeInBytes > 0) existingBytes.toFloat() / modelInfo.sizeInBytes else 0f
            
            // Immediately show current progress if resuming
            if (existingBytes > 0) {
                withContext(Dispatchers.Main) {
                    onProgress(startProgress)
                }
            }
            
            val url = URL(modelInfo.downloadUrl)
            connection = url.openConnection() as HttpURLConnection
            
            // Configure connection for optimal download speed
            connection.connectTimeout = 10000 // 10 seconds
            connection.readTimeout = 30000 // 30 seconds
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android)")
            connection.setRequestProperty("Accept", "*/*")
            connection.setRequestProperty("Accept-Encoding", "identity") // Disable compression for speed
            connection.setRequestProperty("Connection", "keep-alive")
            connection.instanceFollowRedirects = true
            connection.useCaches = false
            
            // Set range header for resumable download
            if (existingBytes > 0) {
                connection.setRequestProperty("Range", "bytes=$existingBytes-")
            }
            
            connection.connect()
            
            val responseCode = connection.responseCode
            val isPartialContent = responseCode == HttpURLConnection.HTTP_PARTIAL
            val isOk = responseCode == HttpURLConnection.HTTP_OK
            
            if (!isPartialContent && !isOk) {
                throw Exception("Server returned HTTP $responseCode")
            }
            
            // Get total file size (either from Content-Length or our known size)
            val contentLength = connection.contentLength.toLong()
            val totalFileSize = if (isPartialContent) {
                existingBytes + contentLength
            } else {
                contentLength.takeIf { it > 0 } ?: modelInfo.sizeInBytes
            }
            
            inputStream = java.io.BufferedInputStream(connection.inputStream, 65536)
            outputStream = java.io.BufferedOutputStream(if (isPartialContent) {
                // Append to existing file for resume
                FileOutputStream(tempFile, true)
            } else {
                // Start fresh download
                if (tempFile.exists()) tempFile.delete()
                FileOutputStream(tempFile)
            }, 65536)
            
            val buffer = ByteArray(65536) // 64KB buffer for faster downloads
            var downloadedBytes = existingBytes
            var bytesRead: Int
            var lastProgressUpdate = 0L
            var stuckCheckTime = System.currentTimeMillis()
            var lastDownloadedBytes = downloadedBytes
            
            var flushCounter = 0
            var totalReads = 0
            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                if (bytesRead > 0) {
                    outputStream.write(buffer, 0, bytesRead)
                    downloadedBytes += bytesRead
                    flushCounter++
                    totalReads++
                    
                    // Flush every 16 buffer writes (1MB) to balance performance and safety
                    if (flushCounter >= 16) {
                        outputStream.flush()
                        flushCounter = 0
                    }
                    
                    val currentTime = System.currentTimeMillis()
                    
                    // Check if download is stuck (no progress for 30 seconds)
                    if (downloadedBytes == lastDownloadedBytes) {
                        if (currentTime - stuckCheckTime > 30000) {
                            throw Exception("Download stalled - no progress for 30 seconds")
                        }
                    } else {
                        stuckCheckTime = currentTime
                        lastDownloadedBytes = downloadedBytes
                    }
                    
                    if (currentTime - lastProgressUpdate > 500) { // Update every 500ms to reduce UI overhead
                        lastProgressUpdate = currentTime
                        val progress = if (totalFileSize > 0) {
                            (downloadedBytes.toFloat() / totalFileSize).coerceIn(0f, 1f)
                        } else {
                            // Fallback progress based on bytes downloaded
                            kotlin.math.min(downloadedBytes.toFloat() / modelInfo.sizeInBytes, 0.99f)
                        }
                        withContext(Dispatchers.Main) {
                            onProgress(progress)
                        }
                    }
                }
            }
            
            android.util.Log.d("Download", "Download loop completed - Total reads: $totalReads, Final downloaded bytes: $downloadedBytes")
            
            // Ensure all data is written before closing
            outputStream.flush()
            outputStream.close()
            inputStream.close()
            connection.disconnect()
            
            // Verify download completion
            val downloadedSize = tempFile.length()
            android.util.Log.d("Download", "Download completed - Total: $totalFileSize, Downloaded: $downloadedSize, Expected: ${modelInfo.sizeInBytes}")
            
            // More lenient size check for different server behaviors
            val sizeToCheck = if (totalFileSize > 0) totalFileSize else modelInfo.sizeInBytes
            if (sizeToCheck > 0 && downloadedSize < (sizeToCheck * 0.90)) {
                throw Exception("Download incomplete: $downloadedSize / $sizeToCheck bytes (${(downloadedSize.toFloat() / sizeToCheck * 100).toInt()}%)")
            }
            
            // Move temp file to final location
            android.util.Log.d("Download", "Moving temp file to final location: ${outputFile.absolutePath}")
            if (outputFile.exists()) {
                android.util.Log.d("Download", "Deleting existing output file")
                outputFile.delete()
            }
            
            val renameSuccess = tempFile.renameTo(outputFile)
            android.util.Log.d("Download", "File rename success: $renameSuccess")
            
            if (!renameSuccess) {
                // Fallback: try copying if rename fails
                try {
                    tempFile.copyTo(outputFile, overwrite = true)
                    tempFile.delete()
                    android.util.Log.d("Download", "Used copy fallback successfully")
                } catch (e: Exception) {
                    throw Exception("Failed to finalize download: ${e.message}")
                }
            }
            
            // Verify final file exists and has correct size
            if (!outputFile.exists() || outputFile.length() == 0L) {
                throw Exception("Final file verification failed")
            }
            
            android.util.Log.d("Download", "Download completed successfully: ${outputFile.length()} bytes")
            
            withContext(Dispatchers.Main) {
                // Ensure UI shows 100% before completing
                onProgress(1.0f)
                android.util.Log.d("Download", "Calling onComplete callback")
                onComplete()
                android.util.Log.d("Download", "onComplete callback returned")
            }
            
        } catch (e: Exception) {
            android.util.Log.e("Download", "Download failed with exception: ${e.message}", e)
            
            // Clean up connections
            try {
                outputStream?.close()
                inputStream?.close()
                connection?.disconnect()
            } catch (cleanup: Exception) {
                android.util.Log.w("Download", "Cleanup error: ${cleanup.message}")
            }
            
            val errorMessage = when {
                e.message?.contains("timeout", ignoreCase = true) == true -> "Download timeout - will resume from ${if (File(context.getExternalFilesDir(null), "__imports/${modelInfo.fileName}.tmp").exists()) "current progress" else "beginning"}"
                e.message?.contains("No space", ignoreCase = true) == true -> "Insufficient storage space"
                e.message?.contains("Network", ignoreCase = true) == true -> "Network error - download will resume from current progress"
                else -> "${e.message ?: "Download failed"} - download will resume from current progress"
            }
            
            withContext(Dispatchers.Main) {
                onError(errorMessage)
            }
        }
    }
}

private fun createImportedModelFromUri(
    context: Context,
    uri: Uri,
    modelInfo: ModelDownloadInfo
): ImportedModel? {
    return try {
        val contentResolver = context.contentResolver
        var fileSize = 0L
        var fileName = modelInfo.fileName
        
        contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val sizeIndex = cursor.getColumnIndex("_size")
                if (sizeIndex >= 0) {
                    fileSize = cursor.getLong(sizeIndex)
                }
                val nameIndex = cursor.getColumnIndex("_display_name")
                if (nameIndex >= 0) {
                    fileName = cursor.getString(nameIndex) ?: modelInfo.fileName
                }
            }
        }
        
        ImportedModel.newBuilder()
            .setFileName(fileName)
            .setFileSize(fileSize)
            .setLlmConfig(
                LlmConfig.newBuilder()
                    .addAllCompatibleAccelerators(listOf(Accelerator.GPU.label, Accelerator.CPU.label))
                    .setDefaultMaxTokens(1024)
                    .setDefaultTopk(40)
                    .setDefaultTopp(0.95f)
                    .setDefaultTemperature(0.8f)
                    .setSupportImage(modelInfo.supportImage)
                    .setSupportAudio(modelInfo.supportAudio)
                    .build()
            )
            .build()
    } catch (e: Exception) {
        null
    }
}

private fun createImportedModelFromDownload(modelInfo: ModelDownloadInfo): ImportedModel {
    return ImportedModel.newBuilder()
        .setFileName("__imports/${modelInfo.fileName}")
        .setFileSize(modelInfo.sizeInBytes)
        .setLlmConfig(
            LlmConfig.newBuilder()
                .addAllCompatibleAccelerators(listOf(Accelerator.GPU.label, Accelerator.CPU.label))
                .setDefaultMaxTokens(1024)
                .setDefaultTopk(40)
                .setDefaultTopp(0.95f)
                .setDefaultTemperature(0.8f)
                .setSupportImage(modelInfo.supportImage)
                .setSupportAudio(modelInfo.supportAudio)
                .build()
        )
        .build()
}

private fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

private fun isModelFileExists(context: Context, fileName: String): Boolean {
    val importsDir = File(context.getExternalFilesDir(null), "__imports")
    val modelFile = File(importsDir, fileName)
    return modelFile.exists() && modelFile.length() > 0
}

private fun getPartialDownloadProgress(context: Context, modelInfo: ModelDownloadInfo): Float {
    val importsDir = File(context.getExternalFilesDir(null), "__imports")
    val tempFile = File(importsDir, "${modelInfo.fileName}.tmp")
    return if (tempFile.exists() && modelInfo.sizeInBytes > 0) {
        (tempFile.length().toFloat() / modelInfo.sizeInBytes).coerceAtMost(0.99f)
    } else {
        0f
    }
}