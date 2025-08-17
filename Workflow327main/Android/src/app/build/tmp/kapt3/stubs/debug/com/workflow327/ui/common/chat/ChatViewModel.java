package com.workflow327.ui.common.chat;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.workflow327.data.Model;
import com.workflow327.data.Task;

/**
 * ViewModel responsible for managing the chat UI state and handling chat-related operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010%\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001eJ\u001e\u0010\'\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020#J\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020#J\u000e\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020#J\u0016\u00101\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u00102\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006:"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "task", "Lcom/workflow327/data/Task;", "(Lcom/workflow327/data/Task;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/workflow327/ui/common/chat/ChatUiState;", "getTask", "()Lcom/workflow327/data/Task;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addConfigChangedMessage", "", "oldConfigValues", "", "", "", "newConfigValues", "model", "Lcom/workflow327/data/Model;", "addMessage", "message", "Lcom/workflow327/ui/common/chat/ChatMessage;", "clearAllMessages", "createUiState", "getLastMessage", "getMessageIndex", "", "insertMessageAfter", "anchorMessage", "messageToAdd", "isShowingStats", "", "removeLastMessage", "removeMessageAt", "index", "replaceLastMessage", "type", "Lcom/workflow327/ui/common/chat/ChatMessageType;", "replaceMessage", "setInProgress", "inProgress", "setIsResettingSession", "isResettingSession", "setPreparing", "preparing", "toggleShowingStats", "updateLastTextMessageContentIncrementally", "partialContent", "latencyMs", "", "updateLastTextMessageLlmBenchmarkResult", "llmBenchmarkResult", "Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;", "updateStreamingMessage", "app_debug"})
public abstract class ChatViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.Task task = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.common.chat.ChatUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.workflow327.ui.common.chat.ChatUiState> uiState = null;
    
    public ChatViewModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.Task getTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.workflow327.ui.common.chat.ChatUiState> getUiState() {
        return null;
    }
    
    public final void addMessage(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message) {
    }
    
    public final void insertMessageAfter(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage anchorMessage, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage messageToAdd) {
    }
    
    public final void removeMessageAt(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, int index) {
    }
    
    public final void removeLastMessage(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void clearAllMessages(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.workflow327.ui.common.chat.ChatMessage getLastMessage(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
        return null;
    }
    
    public final void updateLastTextMessageContentIncrementally(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String partialContent, float latencyMs) {
    }
    
    public final void updateLastTextMessageLlmBenchmarkResult(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult llmBenchmarkResult) {
    }
    
    public final void replaceLastMessage(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessageType type) {
    }
    
    public final void replaceMessage(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, int index, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message) {
    }
    
    public final void updateStreamingMessage(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message) {
    }
    
    public final void setInProgress(boolean inProgress) {
    }
    
    public final void setIsResettingSession(boolean isResettingSession) {
    }
    
    public final void setPreparing(boolean preparing) {
    }
    
    public final void addConfigChangedMessage(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> oldConfigValues, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> newConfigValues, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final int getMessageIndex(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message) {
        return 0;
    }
    
    public final boolean isShowingStats(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message) {
        return false;
    }
    
    public final void toggleShowingStats(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessage message) {
    }
    
    private final com.workflow327.ui.common.chat.ChatUiState createUiState(com.workflow327.data.Task task) {
        return null;
    }
}