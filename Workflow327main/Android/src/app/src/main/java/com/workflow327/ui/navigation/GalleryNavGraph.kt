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

package com.workflow327.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.EntryPoint
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseOutExpo
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.zIndex
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.workflow327.data.Model
import com.workflow327.data.TASK_LLM_ASK_AUDIO
import com.workflow327.data.TASK_LLM_ASK_IMAGE
import com.workflow327.data.TASK_LLM_CHAT
import com.workflow327.data.TASK_LLM_PROMPT_LAB
import com.workflow327.data.Task
import com.workflow327.data.TaskType
import com.workflow327.data.getModelByName
import com.workflow327.firebaseAnalytics
import com.workflow327.ui.home.HomeScreen
import com.workflow327.ui.llmchat.LlmAskAudioDestination
import com.workflow327.ui.llmchat.LlmAskAudioScreen
import com.workflow327.ui.llmchat.LlmAskAudioViewModel
import com.workflow327.ui.llmchat.LlmAskImageDestination
import com.workflow327.ui.llmchat.LlmAskImageScreen
import com.workflow327.ui.llmchat.LlmAskImageViewModel
import com.workflow327.ui.llmchat.LlmChatDestination
import com.workflow327.ui.llmchat.LlmChatScreen
import com.workflow327.ui.llmchat.LlmChatViewModel
import com.workflow327.ui.llmsingleturn.LlmSingleTurnDestination
import com.workflow327.ui.llmsingleturn.LlmSingleTurnScreen
import com.workflow327.ui.llmsingleturn.LlmSingleTurnViewModel
import com.workflow327.ui.modelmanager.ModelManager
import com.workflow327.ui.modelmanager.ModelManagerViewModel
import com.workflow327.ui.auth.LoginScreen
import com.workflow327.ui.auth.LoginViewModel
import com.workflow327.data.AuthRepository
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.workflow327.data.AuthState

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AuthRepositoryEntryPoint {
  fun authRepository(): AuthRepository
}

private const val TAG = "AGWorkflowNavGraph"
private const val ROUTE_PLACEHOLDER = "placeholder"
private const val ENTER_ANIMATION_DURATION_MS = 500
private val ENTER_ANIMATION_EASING = EaseOutExpo
private const val ENTER_ANIMATION_DELAY_MS = 100

private const val EXIT_ANIMATION_DURATION_MS = 500
private val EXIT_ANIMATION_EASING = EaseOutExpo

private fun enterTween(): FiniteAnimationSpec<IntOffset> {
  return tween(
    ENTER_ANIMATION_DURATION_MS,
    easing = ENTER_ANIMATION_EASING,
    delayMillis = ENTER_ANIMATION_DELAY_MS,
  )
}

private fun exitTween(): FiniteAnimationSpec<IntOffset> {
  return tween(EXIT_ANIMATION_DURATION_MS, easing = EXIT_ANIMATION_EASING)
}

private fun AnimatedContentTransitionScope<*>.slideEnter(): EnterTransition {
  return slideIntoContainer(
    animationSpec = enterTween(),
    towards = AnimatedContentTransitionScope.SlideDirection.Left,
  )
}

private fun AnimatedContentTransitionScope<*>.slideExit(): ExitTransition {
  return slideOutOfContainer(
    animationSpec = exitTween(),
    towards = AnimatedContentTransitionScope.SlideDirection.Right,
  )
}

/** Navigation routes. */
@Composable
fun WorkflowNavHost(
  navController: NavHostController,
  modifier: Modifier = Modifier,
  modelManagerViewModel: ModelManagerViewModel = hiltViewModel(),
) {
  val lifecycleOwner = LocalLifecycleOwner.current
  var showModelManager by remember { mutableStateOf(false) }
  var pickedTask by remember { mutableStateOf<Task?>(null) }
  
  val authRepository: AuthRepository = LocalContext.current.let { context ->
    EntryPointAccessors.fromApplication(context, AuthRepositoryEntryPoint::class.java).authRepository()
  }
  val authState by authRepository.authState.collectAsStateWithLifecycle()
  val loginViewModel: LoginViewModel = hiltViewModel()
  
  // Show login screen if not authenticated
  if (authState is AuthState.NotAuthenticated || authState is AuthState.Loading || authState is AuthState.Error) {
    LoginScreen(
      onLoginSuccess = {
        // For demo mode, create a dummy user profile
        loginViewModel.skipToDemo()
      },
      modifier = modifier
    )
    return
  }

  // Track whether app is in foreground.
  DisposableEffect(lifecycleOwner) {
    val observer = LifecycleEventObserver { _, event ->
      when (event) {
        Lifecycle.Event.ON_START,
        Lifecycle.Event.ON_RESUME -> {
          modelManagerViewModel.setAppInForeground(foreground = true)
        }
        Lifecycle.Event.ON_STOP,
        Lifecycle.Event.ON_PAUSE -> {
          modelManagerViewModel.setAppInForeground(foreground = false)
        }
        else -> {
          /* Do nothing for other events */
        }
      }
    }

    lifecycleOwner.lifecycle.addObserver(observer)

    onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
  }

  HomeScreen(
    modelManagerViewModel = modelManagerViewModel,
    tosViewModel = hiltViewModel(),
    navigateToTaskScreen = { task ->
      pickedTask = task
      showModelManager = true
      firebaseAnalytics?.logEvent(
        "capability_select",
        bundleOf("capability_name" to task.type.toString()),
      )
    },
    onSignOut = { loginViewModel.signOut() }
  )

  // Model manager.
  AnimatedVisibility(
    visible = showModelManager,
    enter = slideInHorizontally(initialOffsetX = { it }),
    exit = slideOutHorizontally(targetOffsetX = { it }),
  ) {
    val curPickedTask = pickedTask
    if (curPickedTask != null) {
      ModelManager(
        viewModel = modelManagerViewModel,
        task = curPickedTask,
        onModelClicked = { model ->
          navigateToTaskScreen(
            navController = navController,
            taskType = curPickedTask.type,
            model = model,
          )
        },
        navigateUp = { showModelManager = false },
      )
    }
  }

  NavHost(
    navController = navController,
    // Default to open home screen.
    startDestination = ROUTE_PLACEHOLDER,
    enterTransition = { EnterTransition.None },
    exitTransition = { ExitTransition.None },
    modifier = modifier.zIndex(1f),
  ) {
    // Placeholder root screen
    composable(route = ROUTE_PLACEHOLDER) { Text("") }

    // LLM chat demos.
    composable(
      route = "${LlmChatDestination.route}/{modelName}",
      arguments = listOf(navArgument("modelName") { type = NavType.StringType }),
      enterTransition = { slideEnter() },
      exitTransition = { slideExit() },
    ) { backStackEntry ->
      val viewModel: LlmChatViewModel = hiltViewModel(backStackEntry)

      val defaultModel = getModelFromNavigationParam(backStackEntry, TASK_LLM_CHAT)
      if (defaultModel != null) {
        modelManagerViewModel.selectModel(defaultModel)

        LlmChatScreen(
          viewModel = viewModel,
          modelManagerViewModel = modelManagerViewModel,
          navigateUp = { navController.navigateUp() },
        )
      } else {
        // Handle case where model is not found - show error or navigate back
        android.util.Log.e("Navigation", "Failed to load model for LLM Chat")
        LaunchedEffect(Unit) {
          navController.navigateUp()
        }
      }
    }

    // LLM single turn.
    composable(
      route = "${LlmSingleTurnDestination.route}/{modelName}",
      arguments = listOf(navArgument("modelName") { type = NavType.StringType }),
      enterTransition = { slideEnter() },
      exitTransition = { slideExit() },
    ) { backStackEntry ->
      val viewModel: LlmSingleTurnViewModel = hiltViewModel(backStackEntry)

      getModelFromNavigationParam(backStackEntry, TASK_LLM_PROMPT_LAB)?.let { defaultModel ->
        modelManagerViewModel.selectModel(defaultModel)

        LlmSingleTurnScreen(
          viewModel = viewModel,
          modelManagerViewModel = modelManagerViewModel,
          navigateUp = { navController.navigateUp() },
        )
      }
    }

    // Ask image.
    composable(
      route = "${LlmAskImageDestination.route}/{modelName}",
      arguments = listOf(navArgument("modelName") { type = NavType.StringType }),
      enterTransition = { slideEnter() },
      exitTransition = { slideExit() },
    ) { backStackEntry ->
      val viewModel: LlmAskImageViewModel = hiltViewModel()

      getModelFromNavigationParam(backStackEntry, TASK_LLM_ASK_IMAGE)?.let { defaultModel ->
        modelManagerViewModel.selectModel(defaultModel)

        LlmAskImageScreen(
          viewModel = viewModel,
          modelManagerViewModel = modelManagerViewModel,
          navigateUp = { navController.navigateUp() },
        )
      }
    }

    // Ask audio.
    composable(
      route = "${LlmAskAudioDestination.route}/{modelName}",
      arguments = listOf(navArgument("modelName") { type = NavType.StringType }),
      enterTransition = { slideEnter() },
      exitTransition = { slideExit() },
    ) { backStackEntry ->
      val viewModel: LlmAskAudioViewModel = hiltViewModel()

      getModelFromNavigationParam(backStackEntry, TASK_LLM_ASK_AUDIO)?.let { defaultModel ->
        modelManagerViewModel.selectModel(defaultModel)

        LlmAskAudioScreen(
          viewModel = viewModel,
          modelManagerViewModel = modelManagerViewModel,
          navigateUp = { navController.navigateUp() },
        )
      }
    }
  }

  // Handle incoming intents for deep links
  val intent = androidx.activity.compose.LocalActivity.current?.intent
  val data = intent?.data
  if (data != null) {
    intent.data = null
    Log.d(TAG, "navigation link clicked: $data")
    if (data.toString().startsWith("com.workflow327://model/")) {
      val modelName = data.pathSegments.last()
      getModelByName(modelName)?.let { model ->
        // TODO(jingjin): need to show a list of possible tasks for this model.
        navigateToTaskScreen(
          navController = navController,
          taskType = TaskType.LLM_CHAT,
          model = model,
        )
      }
    }
  }
}

fun navigateToTaskScreen(
  navController: NavHostController,
  taskType: TaskType,
  model: Model? = null,
) {
  val modelName = java.net.URLEncoder.encode(model?.name ?: "", "UTF-8")
  when (taskType) {
    TaskType.LLM_CHAT -> navController.navigate("${LlmChatDestination.route}/${modelName}")
    TaskType.LLM_ASK_IMAGE -> navController.navigate("${LlmAskImageDestination.route}/${modelName}")
    TaskType.LLM_ASK_AUDIO -> navController.navigate("${LlmAskAudioDestination.route}/${modelName}")
    TaskType.LLM_PROMPT_LAB ->
      navController.navigate("${LlmSingleTurnDestination.route}/${modelName}")
    TaskType.WORKFLOW_EXECUTOR -> navController.navigate("${LlmChatDestination.route}/${modelName}")
    TaskType.MULTIMODAL_ASSISTANT -> navController.navigate("${LlmAskImageDestination.route}/${modelName}")
    TaskType.WORKFLOW_ASSISTANT -> navController.navigate("${LlmChatDestination.route}/${modelName}")
    TaskType.TEST_TASK_1 -> {}
    TaskType.TEST_TASK_2 -> {}
  }
}

fun getModelFromNavigationParam(entry: NavBackStackEntry, task: Task): Model? {
  var modelName = entry.arguments?.getString("modelName") ?: ""
  if (modelName.isNotEmpty()) {
    // URL decode the model name
    try {
      modelName = java.net.URLDecoder.decode(modelName, "UTF-8")
    } catch (e: Exception) {
      android.util.Log.w("Navigation", "Failed to decode model name: $modelName", e)
    }
  }
  
  if (modelName.isEmpty()) {
    if (task.models.isNotEmpty()) {
      modelName = task.models[0].name
    } else {
      android.util.Log.w("Navigation", "No models available for task: ${task.type}")
      return null
    }
  }
  
  val model = getModelByName(modelName)
  if (model == null) {
    android.util.Log.w("Navigation", "Model not found: $modelName")
  }
  return model
}
