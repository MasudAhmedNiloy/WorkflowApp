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

package com.workflow327.ui.workflow


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.workflow327.data.Task
import com.workflow327.ui.llmchat.LlmChatScreen
import com.workflow327.ui.llmchat.LlmChatViewModel
import com.workflow327.ui.modelmanager.ModelManagerViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkflowAssistantScreen(
  task: Task,
  modelManagerViewModel: ModelManagerViewModel,
  navigateUp: () -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedMode by remember { mutableStateOf(WorkflowMode.COMBINED) }
  val chatViewModel: LlmChatViewModel = viewModel()
  
  Column(modifier = modifier.fillMaxSize()) {
    // Mode Selection Header
    WorkflowModeSelector(
      selectedMode = selectedMode,
      onModeSelected = { selectedMode = it },
      modifier = Modifier.padding(16.dp)
    )
    
    // Main Content - Use existing LlmChatScreen
    LlmChatScreen(
      viewModel = chatViewModel,
      modelManagerViewModel = modelManagerViewModel,
      navigateUp = navigateUp,
      modifier = Modifier.fillMaxSize()
    )
  }
}

@Composable
fun WorkflowModeSelector(
  selectedMode: WorkflowMode,
  onModeSelected: (WorkflowMode) -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      Text(
        text = "327 Workflow Assistant Mode",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
      )
      
      Spacer(modifier = Modifier.height(12.dp))
      
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        FilterChip(
          onClick = { onModeSelected(WorkflowMode.M1_EXECUTOR) },
          label = { 
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.Psychology,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text("M1 Executor")
            }
          },
          selected = selectedMode == WorkflowMode.M1_EXECUTOR,
          modifier = Modifier.weight(1f)
        )
        
        FilterChip(
          onClick = { onModeSelected(WorkflowMode.M2_MULTIMODAL) },
          label = { 
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.SmartToy,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text("M2 Multimodal")
            }
          },
          selected = selectedMode == WorkflowMode.M2_MULTIMODAL,
          modifier = Modifier.weight(1f)
        )
        
        FilterChip(
          onClick = { onModeSelected(WorkflowMode.COMBINED) },
          label = { Text("Combined") },
          selected = selectedMode == WorkflowMode.COMBINED,
          modifier = Modifier.weight(1f)
        )
      }
      
      // Mode Description
      Spacer(modifier = Modifier.height(8.dp))
      Text(
        text = when (selectedMode) {
          WorkflowMode.M1_EXECUTOR -> "M1 (Phi-2): Specialized in workflow task execution and action planning"
          WorkflowMode.M2_MULTIMODAL -> "M2 (Gemma-3n): Advanced multimodal AI for images, text, and speech"
          WorkflowMode.COMBINED -> "Combined: M1 handles execution while M2 provides multimodal understanding"
        },
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

enum class WorkflowMode {
  M1_EXECUTOR,
  M2_MULTIMODAL,
  COMBINED
}
