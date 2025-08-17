package com.workflow327.common;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a!\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0086\b\u001a\u000e\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r\u001a(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0002\u001a\u000e\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"DONE_THINKING", "", "LAUNCH_INFO_FILE_NAME", "START_THINKING", "TAG", "cleanUpMediapipeTaskErrorMessage", "message", "convert8BitTo16Bit", "", "eightBitData", "convertWavToMonoWithMaxSeconds", "Lcom/workflow327/common/AudioClip;", "context", "Landroid/content/Context;", "stereoUri", "Landroid/net/Uri;", "maxSeconds", "", "getJsonResponse", "Lcom/workflow327/common/JsonObjAndTextContent;", "T", "url", "processLlmResponse", "response", "readLaunchInfo", "Lcom/workflow327/common/LaunchInfo;", "resample", "", "inputSamples", "originalSampleRate", "targetSampleRate", "channels", "writeLaunchInfo", "", "app_debug"})
public final class UtilsKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGUtils";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LAUNCH_INFO_FILE_NAME = "launch_info";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String START_THINKING = "***Thinking...***";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DONE_THINKING = "***Done thinking***";
    
    @org.jetbrains.annotations.Nullable()
    public static final com.workflow327.common.LaunchInfo readLaunchInfo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String cleanUpMediapipeTaskErrorMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String processLlmResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
        return null;
    }
    
    public static final void writeLaunchInfo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.workflow327.common.AudioClip convertWavToMonoWithMaxSeconds(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri stereoUri, int maxSeconds) {
        return null;
    }
    
    /**
     * Converts 8-bit unsigned PCM audio data to 16-bit signed PCM.
     */
    private static final byte[] convert8BitTo16Bit(byte[] eightBitData) {
        return null;
    }
    
    /**
     * Resamples PCM audio data from an original sample rate to a target sample rate.
     */
    private static final short[] resample(short[] inputSamples, int originalSampleRate, int targetSampleRate, int channels) {
        return null;
    }
}