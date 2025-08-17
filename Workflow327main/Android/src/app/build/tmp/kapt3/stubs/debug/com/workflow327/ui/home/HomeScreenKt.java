package com.workflow327.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.StringRes;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextDecoration;
import com.workflow327.R;
import com.workflow327.data.AppBarAction;
import com.workflow327.data.AppBarActionType;
import com.workflow327.data.Task;
import com.workflow327.data.TaskType;
import com.workflow327.proto.ImportedModel;
import com.workflow327.ui.common.tos.TosViewModel;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;
import com.workflow327.ui.modelmanager.ModelDownloadProgress;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0003\u001a(\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003\u001aH\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u00132\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0007\u001a\b\u0010\u0016\u001a\u00020\u0005H\u0003\u001a(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003\u001a*\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013H\u0003\u001a\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"TAG", "", "TASK_COUNT_ANIMATION_DURATION", "", "AppTitle", "", "DownloadProgressBanner", "downloadProgress", "Lcom/workflow327/ui/modelmanager/ModelDownloadProgress;", "onShowDetails", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "HomeScreen", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "tosViewModel", "Lcom/workflow327/ui/common/tos/TosViewModel;", "navigateToTaskScreen", "Lkotlin/Function1;", "Lcom/workflow327/data/Task;", "onSignOut", "IntroText", "TaskCard", "task", "onClick", "TaskList", "tasks", "", "getFileName", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "app_debug"})
public final class HomeScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGHomeScreen";
    private static final int TASK_COUNT_ANIMATION_DURATION = 250;
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.tos.TosViewModel tosViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.data.Task, kotlin.Unit> navigateToTaskScreen, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignOut) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AppTitle() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void IntroText() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaskList(java.util.List<com.workflow327.data.Task> tasks, kotlin.jvm.functions.Function1<? super com.workflow327.data.Task, kotlin.Unit> navigateToTaskScreen) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TaskCard(com.workflow327.data.Task task, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, androidx.compose.ui.Modifier modifier) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String getFileName(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DownloadProgressBanner(com.workflow327.ui.modelmanager.ModelDownloadProgress downloadProgress, kotlin.jvm.functions.Function0<kotlin.Unit> onShowDetails, androidx.compose.ui.Modifier modifier) {
    }
}