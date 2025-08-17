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

package com.workflow327.ui.common.modelitem

// import androidx.compose.ui.tooling.preview.Preview
// import com.workflow327.ui.preview.MODEL_TEST1
// import com.workflow327.ui.preview.MODEL_TEST2
// import com.workflow327.ui.preview.MODEL_TEST3
// import com.workflow327.ui.preview.MODEL_TEST4
// import com.workflow327.ui.preview.PreviewModelManagerViewModel
// import com.workflow327.ui.preview.TASK_TEST1
// import com.workflow327.ui.preview.TASK_TEST2
// import com.workflow327.ui.theme.WorkflowTheme

import android.content.Intent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.UnfoldLess
import androidx.compose.material.icons.rounded.UnfoldMore
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.workflow327.data.Model
import com.workflow327.data.Task
import com.workflow327.ui.common.MarkdownText
import com.workflow327.ui.common.TaskIcon
import com.workflow327.ui.common.getTaskBgColor
import com.workflow327.ui.common.getTaskIconColor
import com.workflow327.ui.modelmanager.ModelManagerViewModel

private val DEFAULT_VERTICAL_PADDING = 16.dp

/**
 * Composable function to display a model item in the model manager list.
 *
 * This function renders a card representing a model, displaying its task icon, name, and
 * providing action buttons. It supports expanding to show a model description and
 * buttons for learning more (opening a URL) and trying imported models.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ModelItem(
  model: Model,
  task: Task,
  modelManagerViewModel: ModelManagerViewModel,
  onModelClicked: (Model) -> Unit,
  modifier: Modifier = Modifier,
  onConfigClicked: () -> Unit = {},
  verticalSpacing: Dp = DEFAULT_VERTICAL_PADDING,
  showDeleteButton: Boolean = true,
  showConfigButtonIfExisted: Boolean = false,
  canExpand: Boolean = true,
) {
  val context = LocalContext.current
  val modelManagerUiState by modelManagerViewModel.uiState.collectAsState()

  var isExpanded by remember { mutableStateOf(false) }

  var boxModifier =
    modifier.fillMaxWidth().clip(RoundedCornerShape(size = 42.dp)).background(getTaskBgColor(task))
  boxModifier =
    if (canExpand) {
      boxModifier.clickable(
        onClick = {
          if (!model.imported) {
            isExpanded = !isExpanded
          } else {
            onModelClicked(model)
          }
        },
        interactionSource = remember { MutableInteractionSource() },
        indication = ripple(bounded = true, radius = 1000.dp),
      )
    } else {
      boxModifier
    }

  Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
    SharedTransitionLayout {
      AnimatedContent(isExpanded, label = "item_layout_transition") { targetState ->
        val taskIcon =
          @Composable {
            TaskIcon(
              task = task,
              width = 40.dp,
              modifier =
                Modifier.sharedElement(
                  sharedContentState = rememberSharedContentState(key = "task_icon"),
                  animatedVisibilityScope = this@AnimatedContent,
                ),
            )
          }

        val modelNameAndStatus =
          @Composable {
            ModelNameAndStatus(
              model = model,
              task = task,
              isExpanded = isExpanded,
              sharedTransitionScope = this@SharedTransitionLayout,
              animatedVisibilityScope = this@AnimatedContent,
            )
          }

        val actionButton =
          @Composable {
            ModelItemActionButton(
              context = context,
              model = model,
              task = task,
              modelManagerViewModel = modelManagerViewModel,
              modifier =
                Modifier.sharedElement(
                  sharedContentState = rememberSharedContentState(key = "action_button"),
                  animatedVisibilityScope = this@AnimatedContent,
                ),
              showDeleteButton = showDeleteButton,
            )
          }

        val expandButton =
          @Composable {
            Icon(
              // For imported model, show ">" directly indicating users can just tap the model item
              // to
              // go into it without needing to expand it first.
              if (model.imported) Icons.Rounded.ChevronRight
              else if (isExpanded) Icons.Rounded.UnfoldLess else Icons.Rounded.UnfoldMore,
              contentDescription = "",
              tint = getTaskIconColor(task),
              modifier =
                Modifier.sharedElement(
                  sharedContentState = rememberSharedContentState(key = "expand_button"),
                  animatedVisibilityScope = this@AnimatedContent,
                ),
            )
          }

        val description =
          @Composable {
            if (model.info.isNotEmpty()) {
              MarkdownText(
                model.info,
                smallFontSize = true,
                modifier =
                  Modifier.sharedElement(
                      sharedContentState = rememberSharedContentState(key = "description"),
                      animatedVisibilityScope = this@AnimatedContent,
                    )
                    .skipToLookaheadSize(),
              )
            }
          }

        val buttonsRow =
          @Composable {
            Row(
              horizontalArrangement = Arrangement.spacedBy(12.dp),
              modifier =
                Modifier.sharedElement(
                    sharedContentState = rememberSharedContentState(key = "buttons_row"),
                    animatedVisibilityScope = this@AnimatedContent,
                  )
                  .skipToLookaheadSize(),
            ) {
              // The "learn more" button. Click to show related urls in a bottom sheet.
              if (model.learnMoreUrl.isNotEmpty()) {
                OutlinedButton(
                  onClick = {
                    if (isExpanded) {
                      val intent = Intent(Intent.ACTION_VIEW, model.learnMoreUrl.toUri())
                      context.startActivity(intent)
                    }
                  }
                ) {
                  Text("Learn More", maxLines = 1)
                }
              }

              // Button to try the model
              OutlinedButton(
                onClick = { if (isExpanded) onModelClicked(model) },
                enabled = isExpanded && model.imported
              ) {
                Text("Try Model", maxLines = 1)
              }
            }
          }

        // Collapsed state.
        if (!targetState) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(12.dp),
              modifier =
                Modifier.fillMaxWidth()
                  .padding(start = 18.dp, end = 18.dp)
                  .padding(vertical = verticalSpacing),
            ) {
              // Icon at the left.
              taskIcon()
              // Model name and status at the center.
              Row(modifier = Modifier.weight(1f)) { modelNameAndStatus() }
              // Action button and expand/collapse button at the right.
              Row(verticalAlignment = Alignment.CenterVertically) {
                actionButton()
                expandButton()
              }
            }
          }
        } else {
          Column(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
              Modifier.fillMaxWidth().padding(vertical = verticalSpacing, horizontal = 18.dp),
          ) {
            Box(contentAlignment = Alignment.Center) {
              // Icon at the top-center.
              taskIcon()
              // Action button and expand/collapse button at the right.
              Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
              ) {
                actionButton()
                expandButton()
              }
            }
            // Name and status below the icon.
            modelNameAndStatus()
            // Description.
            description()
            // Buttons
            buttonsRow()
          }
        }
      }
    }
  }
}

// @Preview(showBackground = true)
// @Composable
// fun PreviewModelItem() {
//   WorkflowTheme {
//     Column(
//       verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(16.dp)
//     ) {
//       ModelItem(
//         model = MODEL_TEST1,
//         task = TASK_TEST1,
//         onModelClicked = { },
//         modelManagerViewModel = PreviewModelManagerViewModel(context = LocalContext.current),
//       )
//       ModelItem(
//         model = MODEL_TEST2,
//         task = TASK_TEST1,
//         onModelClicked = { },
//         modelManagerViewModel = PreviewModelManagerViewModel(context = LocalContext.current),
//       )
//       ModelItem(
//         model = MODEL_TEST3,
//         task = TASK_TEST2,
//         onModelClicked = { },
//         modelManagerViewModel = PreviewModelManagerViewModel(context = LocalContext.current),
//       )
//       ModelItem(
//         model = MODEL_TEST4,
//         task = TASK_TEST2,
//         onModelClicked = { },
//         modelManagerViewModel = PreviewModelManagerViewModel(context = LocalContext.current),
//       )
//     }
//   }
// }
