package com.workflow327.ui.common.chat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a6\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"TAG", "", "MessageInputImage", "", "onImageSelected", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "streamingMessage", "Lcom/workflow327/ui/common/chat/ChatMessage;", "onStreamImage", "onStreamEnd", "", "disableButtons", "", "handleImageSelected", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "rotateForPortrait", "app_debug"})
public final class MessageInputImageKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGMessageInputImage";
    
    /**
     * Composable function to display image input options for chat messages.
     *
     * This function renders a row containing buttons that allow the user to select images from albums,
     * take photos using the camera, or initiate a live camera stream. It handles permission requests,
     * image selection, and launching camera activities.
     */
    @androidx.compose.runtime.Composable()
    public static final void MessageInputImage(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onImageSelected, @org.jetbrains.annotations.Nullable()
    com.workflow327.ui.common.chat.ChatMessage streamingMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onStreamImage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onStreamEnd, boolean disableButtons) {
    }
    
    private static final void handleImageSelected(android.content.Context context, android.net.Uri uri, kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onImageSelected, boolean rotateForPortrait) {
    }
}