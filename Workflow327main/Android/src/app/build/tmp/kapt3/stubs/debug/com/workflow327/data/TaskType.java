package com.workflow327.data;

import androidx.annotation.StringRes;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.workflow327.R;

/**
 * Type of task.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/workflow327/data/TaskType;", "", "label", "", "id", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "LLM_CHAT", "LLM_PROMPT_LAB", "LLM_ASK_IMAGE", "LLM_ASK_AUDIO", "WORKFLOW_EXECUTOR", "MULTIMODAL_ASSISTANT", "WORKFLOW_ASSISTANT", "TEST_TASK_1", "TEST_TASK_2", "app_debug"})
public enum TaskType {
    /*public static final*/ LLM_CHAT /* = new LLM_CHAT(null, null) */,
    /*public static final*/ LLM_PROMPT_LAB /* = new LLM_PROMPT_LAB(null, null) */,
    /*public static final*/ LLM_ASK_IMAGE /* = new LLM_ASK_IMAGE(null, null) */,
    /*public static final*/ LLM_ASK_AUDIO /* = new LLM_ASK_AUDIO(null, null) */,
    /*public static final*/ WORKFLOW_EXECUTOR /* = new WORKFLOW_EXECUTOR(null, null) */,
    /*public static final*/ MULTIMODAL_ASSISTANT /* = new MULTIMODAL_ASSISTANT(null, null) */,
    /*public static final*/ WORKFLOW_ASSISTANT /* = new WORKFLOW_ASSISTANT(null, null) */,
    /*public static final*/ TEST_TASK_1 /* = new TEST_TASK_1(null, null) */,
    /*public static final*/ TEST_TASK_2 /* = new TEST_TASK_2(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String label = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    
    TaskType(java.lang.String label, java.lang.String id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.data.TaskType> getEntries() {
        return null;
    }
}