package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for showing benchmark result.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bq\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0011\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019\u00a8\u0006\'"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkResult;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "orderedStats", "", "Lcom/workflow327/ui/common/chat/Stat;", "statValues", "", "", "", "values", "histogram", "Lcom/workflow327/ui/common/chat/Histogram;", "warmupCurrent", "", "warmupTotal", "iterationCurrent", "iterationTotal", "latencyMs", "highlightStat", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;Lcom/workflow327/ui/common/chat/Histogram;IIIIFLjava/lang/String;)V", "getHighlightStat", "()Ljava/lang/String;", "getHistogram", "()Lcom/workflow327/ui/common/chat/Histogram;", "getIterationCurrent", "()I", "getIterationTotal", "getLatencyMs", "()F", "getOrderedStats", "()Ljava/util/List;", "getStatValues", "()Ljava/util/Map;", "getValues", "getWarmupCurrent", "getWarmupTotal", "isRunning", "", "isWarmingUp", "app_debug"})
public final class ChatMessageBenchmarkResult extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.ui.common.chat.Stat> orderedStats = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Float> statValues = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Float> values = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.ui.common.chat.Histogram histogram = null;
    private final int warmupCurrent = 0;
    private final int warmupTotal = 0;
    private final int iterationCurrent = 0;
    private final int iterationTotal = 0;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String highlightStat = null;
    
    public ChatMessageBenchmarkResult(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.ui.common.chat.Stat> orderedStats, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Float> statValues, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Float> values, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.Histogram histogram, int warmupCurrent, int warmupTotal, int iterationCurrent, int iterationTotal, float latencyMs, @org.jetbrains.annotations.NotNull()
    java.lang.String highlightStat) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Float> getValues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.common.chat.Histogram getHistogram() {
        return null;
    }
    
    public final int getWarmupCurrent() {
        return 0;
    }
    
    public final int getWarmupTotal() {
        return 0;
    }
    
    public final int getIterationCurrent() {
        return 0;
    }
    
    public final int getIterationTotal() {
        return 0;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHighlightStat() {
        return null;
    }
    
    public final boolean isWarmingUp() {
        return false;
    }
    
    public final boolean isRunning() {
        return false;
    }
}