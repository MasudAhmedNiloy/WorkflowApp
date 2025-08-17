package com.workflow327.ui.workflow;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.workflow327.data.Task;
import com.workflow327.ui.llmchat.LlmChatViewModel;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/workflow327/ui/workflow/WorkflowMode;", "", "(Ljava/lang/String;I)V", "M1_EXECUTOR", "M2_MULTIMODAL", "COMBINED", "app_debug"})
public enum WorkflowMode {
    /*public static final*/ M1_EXECUTOR /* = new M1_EXECUTOR() */,
    /*public static final*/ M2_MULTIMODAL /* = new M2_MULTIMODAL() */,
    /*public static final*/ COMBINED /* = new COMBINED() */;
    
    WorkflowMode() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.ui.workflow.WorkflowMode> getEntries() {
        return null;
    }
}