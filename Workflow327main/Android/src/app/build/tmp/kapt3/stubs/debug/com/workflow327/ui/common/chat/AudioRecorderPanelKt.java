package com.workflow327.ui.common.chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.workflow327.R;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0007\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001H\u0002\u001aX\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0083@\u00a2\u0006\u0002\u0010\u001a\u001a \u0010\u001b\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"AUDIO_FORMAT", "", "CHANNEL_CONFIG", "TAG", "", "AudioRecorderPanel", "", "onSendAudioClip", "Lkotlin/Function1;", "", "calculatePeakAmplitude", "buffer", "bytesRead", "startRecording", "context", "Landroid/content/Context;", "audioRecordState", "Landroidx/compose/runtime/MutableState;", "Landroid/media/AudioRecord;", "audioStream", "Ljava/io/ByteArrayOutputStream;", "elapsedMs", "Landroidx/compose/runtime/MutableLongState;", "onAmplitudeChanged", "onMaxDurationReached", "Lkotlin/Function0;", "(Landroid/content/Context;Landroidx/compose/runtime/MutableState;Ljava/io/ByteArrayOutputStream;Landroidx/compose/runtime/MutableLongState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "app_debug"})
public final class AudioRecorderPanelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGAudioRecorderPanel";
    private static final int CHANNEL_CONFIG = android.media.AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = android.media.AudioFormat.ENCODING_PCM_16BIT;
    
    /**
     * A Composable that provides an audio recording panel. It allows users to record audio clips,
     * displays the recording duration and a live amplitude visualization, and provides options to play
     * back the recorded clip or send it.
     */
    @androidx.compose.runtime.Composable()
    public static final void AudioRecorderPanel(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> onSendAudioClip) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private static final java.lang.Object startRecording(android.content.Context context, androidx.compose.runtime.MutableState<android.media.AudioRecord> audioRecordState, java.io.ByteArrayOutputStream audioStream, androidx.compose.runtime.MutableLongState elapsedMs, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAmplitudeChanged, kotlin.jvm.functions.Function0<kotlin.Unit> onMaxDurationReached, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private static final byte[] stopRecording(androidx.compose.runtime.MutableState<android.media.AudioRecord> audioRecordState, java.io.ByteArrayOutputStream audioStream) {
        return null;
    }
    
    private static final int calculatePeakAmplitude(byte[] buffer, int bytesRead) {
        return 0;
    }
}