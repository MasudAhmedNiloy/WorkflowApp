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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/workflow327/ui/home/ModelSetupStep;", "", "(Ljava/lang/String;I)V", "SELECTION", "M1_DOWNLOAD", "M2_SELECTION", "M2_DOWNLOAD", "COMPLETED", "app_debug"})
public enum ModelSetupStep {
    /*public static final*/ SELECTION /* = new SELECTION() */,
    /*public static final*/ M1_DOWNLOAD /* = new M1_DOWNLOAD() */,
    /*public static final*/ M2_SELECTION /* = new M2_SELECTION() */,
    /*public static final*/ M2_DOWNLOAD /* = new M2_DOWNLOAD() */,
    /*public static final*/ COMPLETED /* = new COMPLETED() */;
    
    ModelSetupStep() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.ui.home.ModelSetupStep> getEntries() {
        return null;
    }
}