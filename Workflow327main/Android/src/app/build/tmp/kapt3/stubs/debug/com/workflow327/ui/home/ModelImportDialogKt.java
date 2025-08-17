package com.workflow327.ui.home;

import android.content.Context;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.util.Log;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.DialogProperties;
import com.workflow327.data.Accelerator;
import com.workflow327.data.BooleanSwitchConfig;
import com.workflow327.data.Config;
import com.workflow327.data.ConfigKey;
import com.workflow327.data.LabelConfig;
import com.workflow327.data.NumberSliderConfig;
import com.workflow327.data.SegmentedButtonConfig;
import com.workflow327.data.ValueType;
import com.workflow327.proto.ImportedModel;
import com.workflow327.proto.LlmConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fH\u0007\u001a:\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fH\u0007\u001a$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001af\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\fH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"IMPORT_CONFIGS_LLM", "", "Lcom/workflow327/data/Config;", "TAG", "", "ModelImportDialog", "", "uri", "Landroid/net/Uri;", "onDismiss", "Lkotlin/Function0;", "onDone", "Lkotlin/Function1;", "Lcom/workflow327/proto/ImportedModel;", "ModelImportingDialog", "info", "getFileSizeAndDisplayNameFromUri", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "importModel", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fileName", "fileSize", "onProgress", "", "onError", "app_debug"})
public final class ModelImportDialogKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGModelImportDialog";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.workflow327.data.Config> IMPORT_CONFIGS_LLM = null;
    
    @androidx.compose.runtime.Composable()
    public static final void ModelImportDialog(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.proto.ImportedModel, kotlin.Unit> onDone) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModelImportingDialog(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    com.workflow327.proto.ImportedModel info, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.proto.ImportedModel, kotlin.Unit> onDone) {
    }
    
    private static final void importModel(android.content.Context context, kotlinx.coroutines.CoroutineScope coroutineScope, java.lang.String fileName, long fileSize, android.net.Uri uri, kotlin.jvm.functions.Function0<kotlin.Unit> onDone, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onProgress, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    private static final kotlin.Pair<java.lang.Long, java.lang.String> getFileSizeAndDisplayNameFromUri(android.content.Context context, android.net.Uri uri) {
        return null;
    }
}