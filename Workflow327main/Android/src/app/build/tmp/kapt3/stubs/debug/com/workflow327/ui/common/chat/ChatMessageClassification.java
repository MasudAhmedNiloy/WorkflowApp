package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for showing classification result.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u0010"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageClassification;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "classifications", "", "Lcom/workflow327/common/Classification;", "latencyMs", "", "maxBarWidth", "Landroidx/compose/ui/unit/Dp;", "(Ljava/util/List;FLandroidx/compose/ui/unit/Dp;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClassifications", "()Ljava/util/List;", "getLatencyMs", "()F", "getMaxBarWidth-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "app_debug"})
public final class ChatMessageClassification extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.common.Classification> classifications = null;
    private final float latencyMs = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final androidx.compose.ui.unit.Dp maxBarWidth = null;
    
    private ChatMessageClassification(java.util.List<com.workflow327.common.Classification> classifications, float latencyMs, androidx.compose.ui.unit.Dp maxBarWidth) {
        super(null, null, 0.0F, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.common.Classification> getClassifications() {
        return null;
    }
    
    @java.lang.Override()
    public float getLatencyMs() {
        return 0.0F;
    }
}