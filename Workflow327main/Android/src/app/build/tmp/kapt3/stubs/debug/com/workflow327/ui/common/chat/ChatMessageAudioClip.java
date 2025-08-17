package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

/**
 * Chat message for audio clip.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0000H\u0016J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageAudioClip;", "Lcom/workflow327/ui/common/chat/ChatMessage;", "audioData", "", "sampleRate", "", "side", "Lcom/workflow327/ui/common/chat/ChatSide;", "latencyMs", "", "([BILcom/workflow327/ui/common/chat/ChatSide;F)V", "getAudioData", "()[B", "getLatencyMs", "()F", "getSampleRate", "()I", "getSide", "()Lcom/workflow327/ui/common/chat/ChatSide;", "clone", "genByteArrayForWav", "getDurationInSeconds", "app_debug"})
public final class ChatMessageAudioClip extends com.workflow327.ui.common.chat.ChatMessage {
    @org.jetbrains.annotations.NotNull()
    private final byte[] audioData = null;
    private final int sampleRate = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.ui.common.chat.ChatSide side = null;
    private final float latencyMs = 0.0F;
    
    public ChatMessageAudioClip(@org.jetbrains.annotations.NotNull()
    byte[] audioData, int sampleRate, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatSide side, float latencyMs) {
        super(null, null, 0.0F, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getAudioData() {
        return null;
    }
    
    public final int getSampleRate() {
        return 0;
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
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.ui.common.chat.ChatMessageAudioClip clone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] genByteArrayForWav() {
        return null;
    }
    
    public final float getDurationInSeconds() {
        return 0.0F;
    }
}