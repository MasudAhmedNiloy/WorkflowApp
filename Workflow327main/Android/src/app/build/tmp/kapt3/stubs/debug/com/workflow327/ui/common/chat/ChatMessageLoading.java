package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for showing loading status.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageLoading;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "accelerator", "", "(Ljava/lang/String;)V", "getAccelerator", "()Ljava/lang/String;", "app_debug"})
public final class ChatMessageLoading extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String accelerator = null;
    
    public ChatMessageLoading(@org.jetbrains.annotations.NotNull()
    java.lang.String accelerator) {
        super(null, null, 0.0F, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getAccelerator() {
        return null;
    }
    
    public ChatMessageLoading() {
        super(null, null, 0.0F, null);
    }
}