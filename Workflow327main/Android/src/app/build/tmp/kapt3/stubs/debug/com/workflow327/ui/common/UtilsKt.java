package com.workflow327.ui.common;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;
import java.io.File;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0013\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"TAG", "", "ensureValidFileName", "fileName", "getDistinctiveColor", "Landroidx/compose/ui/graphics/Color;", "index", "", "(I)J", "createTempPictureUri", "Landroid/net/Uri;", "Landroid/content/Context;", "fileExtension", "formatToHourMinSecond", "", "humanReadableDuration", "", "humanReadableSize", "si", "", "extraDecimalForGbAndAbove", "app_debug"})
public final class UtilsKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGUtils";
    
    /**
     * Format the bytes into a human-readable format.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String humanReadableSize(long $this$humanReadableSize, boolean si, boolean extraDecimalForGbAndAbove) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String humanReadableDuration(float $this$humanReadableDuration) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatToHourMinSecond(long $this$formatToHourMinSecond) {
        return null;
    }
    
    public static final long getDistinctiveColor(int index) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.net.Uri createTempPictureUri(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$createTempPictureUri, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.lang.String fileExtension) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ensureValidFileName(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
}