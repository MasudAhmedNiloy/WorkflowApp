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

package com.workflow327.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Mms
import androidx.compose.material.icons.outlined.Widgets
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import com.workflow327.R

/** Type of task. */
enum class TaskType(val label: String, val id: String) {
  LLM_CHAT(label = "AI Chat", id = "llm_chat"),
  LLM_PROMPT_LAB(label = "Prompt Lab", id = "llm_prompt_lab"),
  LLM_ASK_IMAGE(label = "Ask Image", id = "llm_ask_image"),
  LLM_ASK_AUDIO(label = "Audio Scribe", id = "llm_ask_audio"),
  WORKFLOW_EXECUTOR(label = "Workflow Executor", id = "workflow_executor"),
  MULTIMODAL_ASSISTANT(label = "Multimodal Assistant", id = "multimodal_assistant"),
  WORKFLOW_ASSISTANT(label = "Workflow Assistant", id = "workflow_assistant"),
  TEST_TASK_1(label = "Test task 1", id = "test_task_1"),
  TEST_TASK_2(label = "Test task 2", id = "test_task_2"),
}

/** Data class for a task listed in home screen. */
data class Task(
  /** Type of the task. */
  val type: TaskType,

  /** Icon to be shown in the task tile. */
  val icon: ImageVector? = null,

  /** Vector resource id for the icon. This precedes the icon if both are set. */
  val iconVectorResourceId: Int? = null,

  /** List of models for the task. */
  val models: MutableList<Model>,

  /** Description of the task. */
  val description: String,

  /** Documentation url for the task. */
  val docUrl: String = "",

  /** Source code url for the model-related functions. */
  val sourceCodeUrl: String = "",

  /** Placeholder text for the name of the agent shown above chat messages. */
  @StringRes val agentNameRes: Int = R.string.chat_generic_agent_name,

  /** Placeholder text for the text input field. */
  @StringRes val textInputPlaceHolderRes: Int = R.string.chat_textinput_placeholder,

  // The following fields are managed by the app. Don't need to set manually.
  var index: Int = -1,
  val updateTrigger: MutableState<Long> = mutableLongStateOf(0),
)

val TASK_LLM_CHAT =
  Task(
    type = TaskType.LLM_CHAT,
    icon = Icons.Outlined.Forum,
    models = mutableListOf(),
    description = "Chat with on-device large language models",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

val TASK_LLM_PROMPT_LAB =
  Task(
    type = TaskType.LLM_PROMPT_LAB,
    icon = Icons.Outlined.Widgets,
    models = mutableListOf(),
    description = "Single turn use cases with on-device large language models",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

val TASK_LLM_ASK_IMAGE =
  Task(
    type = TaskType.LLM_ASK_IMAGE,
    icon = Icons.Outlined.Mms,
    models = mutableListOf(),
    description = "Ask questions about images with on-device large language models",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

val TASK_LLM_ASK_AUDIO =
  Task(
    type = TaskType.LLM_ASK_AUDIO,
    icon = Icons.Outlined.Mic,
    models = mutableListOf(),
    // TODO(do not submit)
    description =
      "Instantly transcribe and/or translate audio clips using on-device large language models",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

val TASK_WORKFLOW_EXECUTOR =
  Task(
    type = TaskType.WORKFLOW_EXECUTOR,
    iconVectorResourceId = R.drawable.pantegon,
    models = mutableListOf(),
    description = "M1 - Execute complex workflows and break down tasks into actionable steps using Phi-2 model",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    agentNameRes = R.string.chat_generic_agent_name,
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

val TASK_MULTIMODAL_ASSISTANT =
  Task(
    type = TaskType.MULTIMODAL_ASSISTANT,
    icon = Icons.Outlined.Mms,
    models = mutableListOf(),
    description = "M2 - Advanced multimodal AI that understands images, text, and speech to help with real-world tasks",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    agentNameRes = R.string.chat_generic_agent_name,
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

val TASK_WORKFLOW_ASSISTANT =
  Task(
    type = TaskType.WORKFLOW_ASSISTANT,
    icon = Icons.Outlined.Widgets,
    models = mutableListOf(),
    description = "Complete workflow assistant combining both M1 and M2 models for comprehensive task management",
    docUrl = "https://ai.google.dev/edge/mediapipe/solutions/genai/llm_inference/android",
    sourceCodeUrl =
      "https://github.com/google-ai-edge/workflow/blob/main/Android/src/app/src/main/java/com/google/ai/edge/workflow/ui/llmchat/LlmChatModelHelper.kt",
    agentNameRes = R.string.chat_generic_agent_name,
    textInputPlaceHolderRes = R.string.text_input_placeholder_llm_chat,
  )

/** All tasks - Focused on 327 Workflow functionality */
val TASKS: List<Task> =
  listOf(
    TASK_WORKFLOW_ASSISTANT,
    TASK_WORKFLOW_EXECUTOR, 
    TASK_MULTIMODAL_ASSISTANT,
    TASK_LLM_CHAT
  )

fun getModelByName(name: String): Model? {
  for (task in TASKS) {
    for (model in task.models) {
      if (model.name == name) {
        return model
      }
    }
  }
  return null
}

fun processTasks() {
  for ((index, task) in TASKS.withIndex()) {
    task.index = index
    for (model in task.models) {
      model.preProcess()
    }
  }
}
