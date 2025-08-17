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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\rH\u00c6\u0003JS\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/workflow327/ui/modelmanager/ModelManagerUiState;", "", "tasks", "", "Lcom/workflow327/data/Task;", "modelInitializationStatus", "", "", "Lcom/workflow327/ui/modelmanager/ModelInitializationStatus;", "selectedModel", "Lcom/workflow327/data/Model;", "textInputHistory", "downloadProgress", "Lcom/workflow327/ui/modelmanager/ModelDownloadProgress;", "(Ljava/util/List;Ljava/util/Map;Lcom/workflow327/data/Model;Ljava/util/List;Lcom/workflow327/ui/modelmanager/ModelDownloadProgress;)V", "getDownloadProgress", "()Lcom/workflow327/ui/modelmanager/ModelDownloadProgress;", "getModelInitializationStatus", "()Ljava/util/Map;", "getSelectedModel", "()Lcom/workflow327/data/Model;", "getTasks", "()Ljava/util/List;", "getTextInputHistory", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class ModelManagerUiState {
    
    /**
     * A list of tasks available in the application.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.data.Task> tasks = null;
    
    /**
     * A map that tracks the initialization status of each model, indexed by model name.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.workflow327.ui.modelmanager.ModelInitializationStatus> modelInitializationStatus = null;
    
    /**
     * The currently selected model.
     */
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.Model selectedModel = null;
    
    /**
     * The history of text inputs entered by the user.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> textInputHistory = null;
    
    /**
     * Download progress state for background model downloads.
     */
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.ui.modelmanager.ModelDownloadProgress downloadProgress = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.Task> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.workflow327.ui.modelmanager.ModelInitializationStatus> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.Model component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.ModelDownloadProgress component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.ModelManagerUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.Task> tasks, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, com.workflow327.ui.modelmanager.ModelInitializationStatus> modelInitializationStatus, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model selectedModel, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> textInputHistory, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelDownloadProgress downloadProgress) {
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
    
    public ModelManagerUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.Task> tasks, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, com.workflow327.ui.modelmanager.ModelInitializationStatus> modelInitializationStatus, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model selectedModel, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> textInputHistory, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelDownloadProgress downloadProgress) {
        super();
    }
    
    /**
     * A list of tasks available in the application.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.Task> getTasks() {
        return null;
    }
    
    /**
     * A map that tracks the initialization status of each model, indexed by model name.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.workflow327.ui.modelmanager.ModelInitializationStatus> getModelInitializationStatus() {
        return null;
    }
    
    /**
     * The currently selected model.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.Model getSelectedModel() {
        return null;
    }
    
    /**
     * The history of text inputs entered by the user.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTextInputHistory() {
        return null;
    }
    
    /**
     * Download progress state for background model downloads.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.ModelDownloadProgress getDownloadProgress() {
        return null;
    }
}