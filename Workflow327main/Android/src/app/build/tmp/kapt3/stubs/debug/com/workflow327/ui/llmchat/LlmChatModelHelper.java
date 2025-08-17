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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ*\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0084\u0001\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052:\u0010\u0014\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00070\u0015j\u0002`\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001eR$\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/workflow327/ui/llmchat/LlmChatModelHelper;", "", "()V", "cleanUpListeners", "", "", "Lkotlin/Function0;", "", "Lcom/workflow327/ui/llmchat/CleanUpListener;", "cleanUp", "model", "Lcom/workflow327/data/Model;", "initialize", "context", "Landroid/content/Context;", "onDone", "Lkotlin/Function1;", "resetSession", "runInference", "input", "resultListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "partialResult", "", "done", "Lcom/workflow327/ui/llmchat/ResultListener;", "cleanUpListener", "images", "", "Landroid/graphics/Bitmap;", "audioClips", "", "app_debug"})
public final class LlmChatModelHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, kotlin.jvm.functions.Function0<kotlin.Unit>> cleanUpListeners = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.workflow327.ui.llmchat.LlmChatModelHelper INSTANCE = null;
    
    private LlmChatModelHelper() {
        super();
    }
    
    public final void initialize(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone) {
    }
    
    public final void resetSession(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void cleanUp(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void runInference(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> resultListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> cleanUpListener, @org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> images, @org.jetbrains.annotations.NotNull()
    java.util.List<byte[]> audioClips) {
    }
}