package com.workflow327.ui.common.modelitem;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ExperimentalSharedTransitionApi;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import com.workflow327.data.Model;
import com.workflow327.data.Task;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u000e"}, d2 = {"ModelNameAndStatus", "", "model", "Lcom/workflow327/data/Model;", "task", "Lcom/workflow327/data/Task;", "isExpanded", "", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class ModelNameAndStatusKt {
    
    /**
     * Composable function to display the model name and its download status information.
     *
     * This function renders the model's name and its current download status, including:
     * - Model name.
     * - Failure message (if download failed).
     * - Download progress (received size, total size, download rate, remaining time) for in-progress
     *  downloads.
     * - "Unzipping..." status for unzipping processes.
     * - Model size for successful downloads.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalSharedTransitionApi.class})
    @androidx.compose.runtime.Composable()
    public static final void ModelNameAndStatus(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, boolean isExpanded, @org.jetbrains.annotations.NotNull()
    androidx.compose.animation.SharedTransitionScope sharedTransitionScope, @org.jetbrains.annotations.NotNull()
    androidx.compose.animation.AnimatedVisibilityScope animatedVisibilityScope, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}