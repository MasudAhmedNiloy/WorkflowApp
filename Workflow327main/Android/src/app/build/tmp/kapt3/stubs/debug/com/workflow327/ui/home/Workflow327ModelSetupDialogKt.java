package com.workflow327.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.window.DialogProperties;
import com.workflow327.data.Accelerator;
import com.workflow327.proto.ImportedModel;
import com.workflow327.proto.LlmConfig;
import kotlinx.coroutines.Dispatchers;
import java.util.concurrent.Executors;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003\u001a\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0003\u001a6\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0003\u001a:\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0003\u001a:\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0003\u001a:\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0003\u001aT\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010#\u001a\u00020$H\u0007\u001a\u0010\u0010%\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\"\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001aV\u0010+\u001a\u00020\u00032\u0006\u0010\'\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030 2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0002\u001a\u0018\u00100\u001a\u00020\u00072\u0006\u0010\'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u00101\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020(2\u0006\u00102\u001a\u00020\tH\u0002\u001a\u0018\u00103\u001a\u00020\u00032\u0006\u0010\'\u001a\u00020(2\u0006\u00104\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"downloadDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "AutoDownloadStepContent", "", "modelInfo", "Lcom/workflow327/ui/home/ModelDownloadInfo;", "progress", "", "error", "", "isDownloading", "", "CompletedStepContent", "onComplete", "Lkotlin/Function0;", "DownloadStepContent", "onCancel", "M2SelectionStepContent", "m2ModelInfo", "onBrowseM2", "onDownloadM2", "onOpenHuggingFace", "ModelInfoCard", "onBrowse", "onDownload", "SelectionStepContent", "m1ModelInfo", "onBrowseM1", "onDownloadM1", "Workflow327ModelSetupDialog", "onDismiss", "onM1ModelReady", "Lkotlin/Function1;", "Lcom/workflow327/proto/ImportedModel;", "onM2ModelReady", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "createImportedModelFromDownload", "createImportedModelFromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "downloadModel", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onProgress", "onError", "getPartialDownloadProgress", "isModelFileExists", "fileName", "openUrl", "url", "app_debug"})
public final class Workflow327ModelSetupDialogKt {
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.ExecutorCoroutineDispatcher downloadDispatcher = null;
    
    @androidx.compose.runtime.Composable()
    public static final void Workflow327ModelSetupDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.proto.ImportedModel, kotlin.Unit> onM1ModelReady, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.proto.ImportedModel, kotlin.Unit> onM2ModelReady, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SelectionStepContent(com.workflow327.ui.home.ModelDownloadInfo m1ModelInfo, kotlin.jvm.functions.Function0<kotlin.Unit> onBrowseM1, kotlin.jvm.functions.Function0<kotlin.Unit> onDownloadM1, kotlin.jvm.functions.Function0<kotlin.Unit> onOpenHuggingFace) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void M2SelectionStepContent(com.workflow327.ui.home.ModelDownloadInfo m2ModelInfo, kotlin.jvm.functions.Function0<kotlin.Unit> onBrowseM2, kotlin.jvm.functions.Function0<kotlin.Unit> onDownloadM2, kotlin.jvm.functions.Function0<kotlin.Unit> onOpenHuggingFace) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AutoDownloadStepContent(com.workflow327.ui.home.ModelDownloadInfo modelInfo, float progress, java.lang.String error, boolean isDownloading) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DownloadStepContent(com.workflow327.ui.home.ModelDownloadInfo modelInfo, float progress, java.lang.String error, @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    boolean isDownloading, kotlin.jvm.functions.Function0<kotlin.Unit> onCancel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CompletedStepContent(kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModelInfoCard(com.workflow327.ui.home.ModelDownloadInfo modelInfo, kotlin.jvm.functions.Function0<kotlin.Unit> onBrowse, kotlin.jvm.functions.Function0<kotlin.Unit> onDownload, kotlin.jvm.functions.Function0<kotlin.Unit> onOpenHuggingFace) {
    }
    
    private static final void downloadModel(android.content.Context context, kotlinx.coroutines.CoroutineScope coroutineScope, com.workflow327.ui.home.ModelDownloadInfo modelInfo, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> onProgress, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError, kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    private static final com.workflow327.proto.ImportedModel createImportedModelFromUri(android.content.Context context, android.net.Uri uri, com.workflow327.ui.home.ModelDownloadInfo modelInfo) {
        return null;
    }
    
    private static final com.workflow327.proto.ImportedModel createImportedModelFromDownload(com.workflow327.ui.home.ModelDownloadInfo modelInfo) {
        return null;
    }
    
    private static final void openUrl(android.content.Context context, java.lang.String url) {
    }
    
    private static final boolean isModelFileExists(android.content.Context context, java.lang.String fileName) {
        return false;
    }
    
    private static final float getPartialDownloadProgress(android.content.Context context, com.workflow327.ui.home.ModelDownloadInfo modelInfo) {
        return 0.0F;
    }
}