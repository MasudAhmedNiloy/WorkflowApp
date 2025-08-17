package com.workflow327.ui.common.chat;

import android.content.ClipData;
import android.graphics.Bitmap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.ClipEntry;
import com.workflow327.R;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.data.TaskType;
import com.workflow327.ui.modelmanager.ModelInitializationStatusType;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatInputType;", "", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "app_debug"})
public enum ChatInputType {
    /*public static final*/ TEXT /* = new TEXT() */,
    /*public static final*/ IMAGE /* = new IMAGE() */;
    
    ChatInputType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.ui.common.chat.ChatInputType> getEntries() {
        return null;
    }
}