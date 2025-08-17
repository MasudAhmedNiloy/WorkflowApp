package com.workflow327.ui.common.modelitem;

import android.content.Context;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u000e"}, d2 = {"ModelItemActionButton", "", "context", "Landroid/content/Context;", "model", "Lcom/workflow327/data/Model;", "task", "Lcom/workflow327/data/Task;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "showDeleteButton", "", "app_debug"})
public final class ModelItemActionButtonKt {
    
    /**
     * Composable function to display action buttons for a model item, based on its download status.
     *
     * This function renders the appropriate action button (download, delete, cancel) based on the
     * provided ModelDownloadStatus. It also handles notification permission requests for downloading
     * and displays a confirmation dialog for deleting models.
     */
    @androidx.compose.runtime.Composable()
    public static final void ModelItemActionButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean showDeleteButton) {
    }
}