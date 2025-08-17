package com.workflow327.ui.home;

import android.util.Log;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.workflow327.BuildConfig;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"REPO", "", "TAG", "NewReleaseNotification", "", "isNewerRelease", "", "currentRelease", "newRelease", "app_debug"})
public final class NewReleaseNotificationKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGNewReleaseNotifi";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REPO = "google-ai-edge/gallery";
    
    @androidx.compose.runtime.Composable()
    public static final void NewReleaseNotification() {
    }
    
    private static final boolean isNewerRelease(java.lang.String currentRelease, java.lang.String newRelease) {
        return false;
    }
}