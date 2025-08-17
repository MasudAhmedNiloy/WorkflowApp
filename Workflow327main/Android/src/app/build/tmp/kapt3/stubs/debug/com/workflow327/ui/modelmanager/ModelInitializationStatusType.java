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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/workflow327/ui/modelmanager/ModelInitializationStatusType;", "", "(Ljava/lang/String;I)V", "NOT_INITIALIZED", "INITIALIZING", "INITIALIZED", "ERROR", "app_debug"})
public enum ModelInitializationStatusType {
    /*public static final*/ NOT_INITIALIZED /* = new NOT_INITIALIZED() */,
    /*public static final*/ INITIALIZING /* = new INITIALIZING() */,
    /*public static final*/ INITIALIZED /* = new INITIALIZED() */,
    /*public static final*/ ERROR /* = new ERROR() */;
    
    ModelInitializationStatusType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.ui.modelmanager.ModelInitializationStatusType> getEntries() {
        return null;
    }
}