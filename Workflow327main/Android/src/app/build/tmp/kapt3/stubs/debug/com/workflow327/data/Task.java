package com.workflow327.data;

import androidx.annotation.StringRes;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.workflow327.R;

/**
 * Data class for a task listed in home screen.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\t\u00101\u001a\u00020\fH\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\fH\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\u0007H\u00c6\u0003J\u008c\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0003\u0010\u000f\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u00c6\u0001\u00a2\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010;\u001a\u00020\u0007H\u00d6\u0001J\t\u0010<\u001a\u00020\fH\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\"R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u0006="}, d2 = {"Lcom/workflow327/data/Task;", "", "type", "Lcom/workflow327/data/TaskType;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconVectorResourceId", "", "models", "", "Lcom/workflow327/data/Model;", "description", "", "docUrl", "sourceCodeUrl", "agentNameRes", "textInputPlaceHolderRes", "index", "updateTrigger", "Landroidx/compose/runtime/MutableState;", "", "(Lcom/workflow327/data/TaskType;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILandroidx/compose/runtime/MutableState;)V", "getAgentNameRes", "()I", "getDescription", "()Ljava/lang/String;", "getDocUrl", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getIconVectorResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIndex", "setIndex", "(I)V", "getModels", "()Ljava/util/List;", "getSourceCodeUrl", "getTextInputPlaceHolderRes", "getType", "()Lcom/workflow327/data/TaskType;", "getUpdateTrigger", "()Landroidx/compose/runtime/MutableState;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/workflow327/data/TaskType;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILandroidx/compose/runtime/MutableState;)Lcom/workflow327/data/Task;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Task {
    
    /**
     * Type of the task.
     */
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.TaskType type = null;
    
    /**
     * Icon to be shown in the task tile.
     */
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    
    /**
     * Vector resource id for the icon. This precedes the icon if both are set.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer iconVectorResourceId = null;
    
    /**
     * List of models for the task.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.data.Model> models = null;
    
    /**
     * Description of the task.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    
    /**
     * Documentation url for the task.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String docUrl = null;
    
    /**
     * Source code url for the model-related functions.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String sourceCodeUrl = null;
    
    /**
     * Placeholder text for the name of the agent shown above chat messages.
     */
    private final int agentNameRes = 0;
    
    /**
     * Placeholder text for the text input field.
     */
    private final int textInputPlaceHolderRes = 0;
    private int index;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.Long> updateTrigger = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.TaskType component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Long> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.ui.graphics.vector.ImageVector component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.Model> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.Task copy(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.TaskType type, @org.jetbrains.annotations.Nullable()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer iconVectorResourceId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.Model> models, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String docUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceCodeUrl, @androidx.annotation.StringRes()
    int agentNameRes, @androidx.annotation.StringRes()
    int textInputPlaceHolderRes, int index, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Long> updateTrigger) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public Task(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.TaskType type, @org.jetbrains.annotations.Nullable()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer iconVectorResourceId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.Model> models, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String docUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String sourceCodeUrl, @androidx.annotation.StringRes()
    int agentNameRes, @androidx.annotation.StringRes()
    int textInputPlaceHolderRes, int index, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Long> updateTrigger) {
        super();
    }
    
    /**
     * Type of the task.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.TaskType getType() {
        return null;
    }
    
    /**
     * Icon to be shown in the task tile.
     */
    @org.jetbrains.annotations.Nullable()
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    /**
     * Vector resource id for the icon. This precedes the icon if both are set.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIconVectorResourceId() {
        return null;
    }
    
    /**
     * List of models for the task.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.Model> getModels() {
        return null;
    }
    
    /**
     * Description of the task.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    /**
     * Documentation url for the task.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocUrl() {
        return null;
    }
    
    /**
     * Source code url for the model-related functions.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourceCodeUrl() {
        return null;
    }
    
    /**
     * Placeholder text for the name of the agent shown above chat messages.
     */
    public final int getAgentNameRes() {
        return 0;
    }
    
    /**
     * Placeholder text for the text input field.
     */
    public final int getTextInputPlaceHolderRes() {
        return 0;
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Long> getUpdateTrigger() {
        return null;
    }
}