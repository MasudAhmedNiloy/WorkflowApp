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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000*\u0016\u0010\u0002\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003*j\u0010\u0005\"2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u000622\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006\u00a8\u0006\f"}, d2 = {"TAG", "", "CleanUpListener", "Lkotlin/Function0;", "", "ResultListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "partialResult", "", "done", "app_debug"})
public final class LlmChatModelHelperKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGLlmChatModelHelper";
}