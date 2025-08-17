package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for showing LLM benchmark result.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\rR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "orderedStats", "", "Lcom/workflow327/ui/common/chat/Stat;", "statValues", "", "", "", "running", "", "latencyMs", "accelerator", "(Ljava/util/List;Ljava/util/Map;ZFLjava/lang/String;)V", "getAccelerator", "()Ljava/lang/String;", "getLatencyMs", "()F", "getOrderedStats", "()Ljava/util/List;", "getRunning", "()Z", "getStatValues", "()Ljava/util/Map;", "app_debug"})
public final class ChatMessageBenchmarkLlmResult extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.ui.common.chat.Stat> orderedStats = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Float> statValues = null;
    private final boolean running = false;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    
    public ChatMessageBenchmarkLlmResult(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.ui.common.chat.Stat> orderedStats, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Float> statValues, boolean running, float latencyMs, @org.jetbrains.annotations.NotNull()
    java.lang.String accelerator) {
        super(null, null, 0.0F, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.ui.common.chat.Stat> getOrderedStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Float> getStatValues() {
        return null;
    }
    
    public final boolean getRunning() {
        return false;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAccelerator() {
        return null;
    }
}