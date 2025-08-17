package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for showing prompt templates.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessagePromptTemplates;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "templates", "", "Lcom/workflow327/data/PromptTemplate;", "showMakeYourOwn", "", "(Ljava/util/List;Z)V", "getShowMakeYourOwn", "()Z", "getTemplates", "()Ljava/util/List;", "app_debug"})
public final class ChatMessagePromptTemplates extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.data.PromptTemplate> templates = null;
    private final boolean showMakeYourOwn = false;
    
    public ChatMessagePromptTemplates(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.PromptTemplate> templates, boolean showMakeYourOwn) {
        super(null, null, 0.0F, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.PromptTemplate> getTemplates() {
        return null;
    }
    
    public final boolean getShowMakeYourOwn() {
        return false;
    }
}