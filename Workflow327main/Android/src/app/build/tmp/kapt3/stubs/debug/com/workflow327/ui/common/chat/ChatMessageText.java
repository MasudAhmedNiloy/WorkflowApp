package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for plain text.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u0000H\u0016R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageText;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "content", "", "side", "Lcom/workflow327/ui/common/chat/ChatSide;", "latencyMs", "", "isMarkdown", "", "llmBenchmarkResult", "Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;", "accelerator", "(Ljava/lang/String;Lcom/workflow327/ui/common/chat/ChatSide;FZLcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;Ljava/lang/String;)V", "getAccelerator", "()Ljava/lang/String;", "getContent", "()Z", "getLatencyMs", "()F", "getLlmBenchmarkResult", "()Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;", "setLlmBenchmarkResult", "(Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;)V", "getSide", "()Lcom/workflow327/ui/common/chat/ChatSide;", "clone", "app_debug"})
public class ChatMessageText extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    private final boolean isMarkdown = false;
    @org.jetbrains.annotations.Nullable()
    private com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult llmBenchmarkResult;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    
    public ChatMessageText(@org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatSide side, float latencyMs, boolean isMarkdown, @org.jetbrains.annotations.Nullable()
    com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult llmBenchmarkResult, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator) {
        super(null, null, 0.0F, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.ui.common.chat.ChatSide getSide() {
        return null;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
    
    public final boolean isMarkdown() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult getLlmBenchmarkResult() {
        return null;
    }
    
    public final void setLlmBenchmarkResult(@org.jetbrains.annotations.Nullable()
    com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAccelerator() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.ui.common.chat.ChatMessageText clone() {
        return null;
    }
}