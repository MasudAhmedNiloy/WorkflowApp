package com.workflow327.ui.modelmanager;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.workflow327.AppLifecycleProvider;
import com.workflow327.data.Accelerator;
import com.workflow327.data.Config;
import com.workflow327.data.DataStoreRepository;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.data.TaskType;
import com.workflow327.proto.AccessTokenData;
import com.workflow327.proto.ImportedModel;
import com.workflow327.proto.Theme;
import com.workflow327.ui.common.AuthConfig;
import com.workflow327.ui.llmchat.LlmChatModelHelper;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.inject.Inject;
import kotlinx.coroutines.Dispatchers;

/**
 * ViewModel responsible for managing models, their download status, and initialization.
 *
 * This ViewModel handles model-related operations such as downloading, deleting, initializing, and
 * cleaning up models. It also manages the UI state for model management, including the list of
 * tasks, models, download statuses, and initialization statuses.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000fJ\u0016\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020 J\u0006\u0010+\u001a\u00020 J\b\u0010,\u001a\u00020\u000bH\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u000fH\u0002J\u0010\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u000fH\u0002J\u0016\u00103\u001a\u00020 2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u000e\u00104\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000fJ\u001a\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000fJ\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020 H\u0002J(\u0010;\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020=2\u0006\u00102\u001a\u00020\u000fH\u0002J\u0010\u0010?\u001a\u00020=2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010@\u001a\u00020 H\u0014J\u000e\u0010A\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010B\u001a\u00020CJ\u001e\u0010D\u001a\u00020 2\u0006\u00107\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020GJ\u000e\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020CJ\u000e\u0010J\u001a\u00020 2\u0006\u0010(\u001a\u00020)J\u000e\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020=J8\u0010M\u001a\u00020 2\b\b\u0002\u0010N\u001a\u00020=2\b\b\u0002\u0010O\u001a\u00020\u000f2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020\u000f2\b\b\u0002\u0010S\u001a\u00020\u000fJ\"\u0010T\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\u0006\u0010U\u001a\u00020V2\b\b\u0002\u0010R\u001a\u00020\u000fH\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006W"}, d2 = {"Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "dataStoreRepository", "Lcom/workflow327/data/DataStoreRepository;", "lifecycleProvider", "Lcom/workflow327/AppLifecycleProvider;", "context", "Landroid/content/Context;", "(Lcom/workflow327/data/DataStoreRepository;Lcom/workflow327/AppLifecycleProvider;Landroid/content/Context;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/workflow327/ui/modelmanager/ModelManagerUiState;", "get_uiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "curAccessToken", "", "getCurAccessToken", "()Ljava/lang/String;", "setCurAccessToken", "(Ljava/lang/String;)V", "externalFilesDir", "Ljava/io/File;", "pagerScrollState", "Lcom/workflow327/ui/modelmanager/PagerScrollState;", "getPagerScrollState", "setPagerScrollState", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addImportedLlmModel", "", "info", "Lcom/workflow327/proto/ImportedModel;", "addTextInputHistory", "text", "cleanupModel", "task", "Lcom/workflow327/data/Task;", "model", "Lcom/workflow327/data/Model;", "clearAccessToken", "clearTextInputHistory", "createEmptyUiState", "createModelFromImportedModelInfo", "createUiState", "deleteDirFromExternalFilesDir", "dir", "deleteFileFromExternalFilesDir", "fileName", "deleteModel", "deleteTextInputHistory", "getModelUrlResponse", "", "accessToken", "getTokenStatusAndData", "Lcom/workflow327/ui/modelmanager/TokenStatusAndData;", "initializeLocalModels", "initializeModel", "force", "", "isFileInExternalFilesDir", "isModelDownloaded", "onCleared", "promoteTextInputHistoryItem", "readThemeOverride", "Lcom/workflow327/proto/Theme;", "saveAccessToken", "refreshToken", "expiresAt", "", "saveThemeOverride", "theme", "selectModel", "setAppInForeground", "foreground", "updateDownloadProgress", "isDownloading", "currentModel", "progress", "", "error", "step", "updateModelInitializationStatus", "status", "Lcom/workflow327/ui/modelmanager/ModelInitializationStatusType;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public class ModelManagerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.DataStoreRepository dataStoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.AppLifecycleProvider lifecycleProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private final java.io.File externalFilesDir = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.modelmanager.ModelManagerUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.workflow327.ui.modelmanager.ModelManagerUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String curAccessToken = "";
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.modelmanager.PagerScrollState> pagerScrollState;
    
    @javax.inject.Inject()
    public ModelManagerViewModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.DataStoreRepository dataStoreRepository, @org.jetbrains.annotations.NotNull()
    com.workflow327.AppLifecycleProvider lifecycleProvider, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.modelmanager.ModelManagerUiState> get_uiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.workflow327.ui.modelmanager.ModelManagerUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurAccessToken() {
        return null;
    }
    
    public final void setCurAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.modelmanager.PagerScrollState> getPagerScrollState() {
        return null;
    }
    
    public final void setPagerScrollState(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.modelmanager.PagerScrollState> p0) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void selectModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void deleteModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void initializeModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, boolean force) {
    }
    
    public final void cleanupModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void addTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void promoteTextInputHistoryItem(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void deleteTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void clearTextInputHistory() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.proto.Theme readThemeOverride() {
        return null;
    }
    
    public final void saveThemeOverride(@org.jetbrains.annotations.NotNull()
    com.workflow327.proto.Theme theme) {
    }
    
    public final int getModelUrlResponse(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken) {
        return 0;
    }
    
    public final void addImportedLlmModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.proto.ImportedModel info) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.TokenStatusAndData getTokenStatusAndData() {
        return null;
    }
    
    public final void saveAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, long expiresAt) {
    }
    
    public final void clearAccessToken() {
    }
    
    private final void initializeLocalModels() {
    }
    
    public final void updateDownloadProgress(boolean isDownloading, @org.jetbrains.annotations.NotNull()
    java.lang.String currentModel, float progress, @org.jetbrains.annotations.NotNull()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    java.lang.String step) {
    }
    
    public final void setAppInForeground(boolean foreground) {
    }
    
    private final com.workflow327.ui.modelmanager.ModelManagerUiState createEmptyUiState() {
        return null;
    }
    
    private final com.workflow327.ui.modelmanager.ModelManagerUiState createUiState() {
        return null;
    }
    
    private final com.workflow327.data.Model createModelFromImportedModelInfo(com.workflow327.proto.ImportedModel info) {
        return null;
    }
    
    private final boolean isFileInExternalFilesDir(java.lang.String fileName) {
        return false;
    }
    
    private final void deleteFileFromExternalFilesDir(java.lang.String fileName) {
    }
    
    private final void deleteDirFromExternalFilesDir(java.lang.String dir) {
    }
    
    private final void updateModelInitializationStatus(com.workflow327.data.Model model, com.workflow327.ui.modelmanager.ModelInitializationStatusType status, java.lang.String error) {
    }
    
    private final boolean isModelDownloaded(com.workflow327.data.Model model) {
        return false;
    }
}