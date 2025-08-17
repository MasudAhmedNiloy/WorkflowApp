package com.workflow327.ui.llmchat;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.workflow327.data.Accelerator;
import com.workflow327.data.ConfigKey;
import com.workflow327.data.Model;
import com.google.mediapipe.framework.image.BitmapImageBuilder;
import com.google.mediapipe.tasks.genai.llminference.GraphOptions;
import com.google.mediapipe.tasks.genai.llminference.LlmInference;
import com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/workflow327/ui/llmchat/LlmModelInstance;", "", "engine", "Lcom/google/mediapipe/tasks/genai/llminference/LlmInference;", "session", "Lcom/google/mediapipe/tasks/genai/llminference/LlmInferenceSession;", "(Lcom/google/mediapipe/tasks/genai/llminference/LlmInference;Lcom/google/mediapipe/tasks/genai/llminference/LlmInferenceSession;)V", "getEngine", "()Lcom/google/mediapipe/tasks/genai/llminference/LlmInference;", "getSession", "()Lcom/google/mediapipe/tasks/genai/llminference/LlmInferenceSession;", "setSession", "(Lcom/google/mediapipe/tasks/genai/llminference/LlmInferenceSession;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class LlmModelInstance {
    @org.jetbrains.annotations.NotNull()
    private final com.google.mediapipe.tasks.genai.llminference.LlmInference engine = null;
    @org.jetbrains.annotations.NotNull()
    private com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession session;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.mediapipe.tasks.genai.llminference.LlmInference component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.llmchat.LlmModelInstance copy(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.genai.llminference.LlmInference engine, @org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession session) {
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
    
    public LlmModelInstance(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.genai.llminference.LlmInference engine, @org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession session) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.mediapipe.tasks.genai.llminference.LlmInference getEngine() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession getSession() {
        return null;
    }
    
    public final void setSession(@org.jetbrains.annotations.NotNull()
    com.google.mediapipe.tasks.genai.llminference.LlmInferenceSession p0) {
    }
}