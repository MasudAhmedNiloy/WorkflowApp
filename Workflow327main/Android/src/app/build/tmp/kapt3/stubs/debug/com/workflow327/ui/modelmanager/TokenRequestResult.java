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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/workflow327/ui/modelmanager/TokenRequestResult;", "", "status", "Lcom/workflow327/ui/modelmanager/TokenRequestResultType;", "errorMessage", "", "(Lcom/workflow327/ui/modelmanager/TokenRequestResultType;Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "getStatus", "()Lcom/workflow327/ui/modelmanager/TokenRequestResultType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class TokenRequestResult {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.ui.modelmanager.TokenRequestResultType status = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String errorMessage = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.TokenRequestResultType component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.TokenRequestResult copy(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.TokenRequestResultType status, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
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
    
    public TokenRequestResult(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.TokenRequestResultType status, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.ui.modelmanager.TokenRequestResultType getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMessage() {
        return null;
    }
}