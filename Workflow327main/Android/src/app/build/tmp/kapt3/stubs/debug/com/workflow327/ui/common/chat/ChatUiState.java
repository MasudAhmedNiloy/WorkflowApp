package com.workflow327.ui.common.chat;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.workflow327.data.Model;
import com.workflow327.data.Task;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0007\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u001b\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007H\u00c6\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003J\u001b\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0007H\u00c6\u0003Ju\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00072\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0007H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/workflow327/ui/common/chat/ChatUiState;", "", "inProgress", "", "isResettingSession", "preparing", "messagesByModel", "", "", "", "Lcom/workflow327/ui/common/chat/ChatMessage;", "streamingMessagesByModel", "showingStatsByModel", "", "(ZZZLjava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getInProgress", "()Z", "getMessagesByModel", "()Ljava/util/Map;", "getPreparing", "getShowingStatsByModel", "getStreamingMessagesByModel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ChatUiState {
    
    /**
     * Indicates whether the runtime is currently processing a message.
     */
    private final boolean inProgress = false;
    
    /**
     * Indicates whether the session is being reset.
     */
    private final boolean isResettingSession = false;
    
    /**
     * Indicates whether the model is preparing (before outputting any result and after initializing).
     */
    private final boolean preparing = false;
    
    /**
     * A map of model names to lists of chat messages.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.List<com.workflow327.ui.common.chat.ChatMessage>> messagesByModel = null;
    
    /**
     * A map of model names to the currently streaming chat message.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.workflow327.ui.common.chat.ChatMessage> streamingMessagesByModel = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.Set<com.workflow327.ui.common.chat.ChatMessage>> showingStatsByModel = null;
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<com.workflow327.ui.common.chat.ChatMessage>> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.workflow327.ui.common.chat.ChatMessage> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.Set<com.workflow327.ui.common.chat.ChatMessage>> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.common.chat.ChatUiState copy(boolean inProgress, boolean isResettingSession, boolean preparing, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<com.workflow327.ui.common.chat.ChatMessage>> messagesByModel, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends com.workflow327.ui.common.chat.ChatMessage> streamingMessagesByModel, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.Set<com.workflow327.ui.common.chat.ChatMessage>> showingStatsByModel) {
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
    
    public ChatUiState(boolean inProgress, boolean isResettingSession, boolean preparing, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<com.workflow327.ui.common.chat.ChatMessage>> messagesByModel, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends com.workflow327.ui.common.chat.ChatMessage> streamingMessagesByModel, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.Set<com.workflow327.ui.common.chat.ChatMessage>> showingStatsByModel) {
        super();
    }
    
    /**
     * Indicates whether the runtime is currently processing a message.
     */
    public final boolean getInProgress() {
        return false;
    }
    
    /**
     * Indicates whether the session is being reset.
     */
    public final boolean isResettingSession() {
        return false;
    }
    
    /**
     * Indicates whether the model is preparing (before outputting any result and after initializing).
     */
    public final boolean getPreparing() {
        return false;
    }
    
    /**
     * A map of model names to lists of chat messages.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<com.workflow327.ui.common.chat.ChatMessage>> getMessagesByModel() {
        return null;
    }
    
    /**
     * A map of model names to the currently streaming chat message.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.workflow327.ui.common.chat.ChatMessage> getStreamingMessagesByModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.Set<com.workflow327.ui.common.chat.ChatMessage>> getShowingStatsByModel() {
        return null;
    }
    
    public ChatUiState() {
        super();
    }
}