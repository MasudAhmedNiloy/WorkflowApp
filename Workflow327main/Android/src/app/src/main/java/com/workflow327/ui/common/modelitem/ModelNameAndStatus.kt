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

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.workflow327.data.Model
import com.workflow327.data.Task
import com.workflow327.ui.common.getTaskIconColor
import com.workflow327.ui.common.humanReadableSize
import com.workflow327.ui.theme.labelSmallNarrow

/**
 * Composable function to display the model name and its download status information.
 *
 * This function renders the model's name and its current download status, including:
 * - Model name.
 * - Failure message (if download failed).
 * - Download progress (received size, total size, download rate, remaining time) for in-progress
 *   downloads.
 * - "Unzipping..." status for unzipping processes.
 * - Model size for successful downloads.
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ModelNameAndStatus(
  model: Model,
  task: Task,
  isExpanded: Boolean,
  sharedTransitionScope: SharedTransitionScope,
  animatedVisibilityScope: AnimatedVisibilityScope,
  modifier: Modifier = Modifier,
) {

  with(sharedTransitionScope) {
    Column(
      horizontalAlignment = if (isExpanded) Alignment.CenterHorizontally else Alignment.Start
    ) {
      // Model name.
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
          model.name,
          maxLines = 1,
          overflow = TextOverflow.MiddleEllipsis,
          style = MaterialTheme.typography.titleMedium,
          modifier =
            Modifier.sharedElement(
              rememberSharedContentState(key = "model_name"),
              animatedVisibilityScope = animatedVisibilityScope,
            ),
        )
      }

      Row(verticalAlignment = Alignment.CenterVertically) {
        // Show model size
        Text(
          model.totalBytes.humanReadableSize(),
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          maxLines = 1,
          style = labelSmallNarrow.copy(fontSize = 11.sp, lineHeight = 10.sp),
          textAlign = if (isExpanded) TextAlign.Center else TextAlign.Start,
          overflow = TextOverflow.Visible,
          modifier =
            Modifier.sharedElement(
              rememberSharedContentState(key = "status_label_0"),
              animatedVisibilityScope = animatedVisibilityScope,
            ),
        )
      }
    }
  }
}
