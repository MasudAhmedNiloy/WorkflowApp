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

/**
 * Navigation destination data
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/workflow327/ui/home/HomeScreenDestination;", "", "()V", "titleRes", "", "getTitleRes", "()I", "app_debug"})
public final class HomeScreenDestination {
    @androidx.annotation.StringRes()
    private static final int titleRes = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.workflow327.ui.home.HomeScreenDestination INSTANCE = null;
    
    private HomeScreenDestination() {
        super();
    }
    
    public final int getTitleRes() {
        return 0;
    }
}