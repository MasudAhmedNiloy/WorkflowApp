package com.workflow327.ui.common.chat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.Log;
import android.util.Size;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.StringRes;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.core.content.ContextCompat;
import com.workflow327.common.AudioClip;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;
import java.util.concurrent.Executors;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0003\u001a\u00ca\u0001\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000bH\u0007\u001a$\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002\u001a2\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00152\u0006\u0010\'\u001a\u00020\u0001H\u0002\u001aB\u0010(\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00152\u0018\u0010+\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0015\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010,\u001a\u00020\u000bH\u0002\u001a\u001a\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"TAG", "", "MediaPanelCloseButton", "", "onClicked", "Lkotlin/Function0;", "MessageInputText", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "curMessage", "isResettingSession", "", "inProgress", "imageMessageCount", "", "audioClipMessageCount", "modelInitializing", "textFieldPlaceHolderRes", "onValueChanged", "Lkotlin/Function1;", "onSendMessage", "", "Lcom/workflow327/ui/common/chat/ChatMessage;", "modelPreparing", "onOpenPromptTemplatesClicked", "onStopButtonClicked", "showPromptTemplatesInMenu", "showImagePickerInMenu", "showAudioItemsInMenu", "showStopButtonWhenInProgress", "checkFrontCamera", "context", "Landroid/content/Context;", "callback", "createMessagesToSend", "pickedImages", "Landroid/graphics/Bitmap;", "audioClips", "Lcom/workflow327/common/AudioClip;", "text", "handleImagesSelected", "uris", "Landroid/net/Uri;", "onImagesSelected", "rotateForPortrait", "rotateImageIfNecessary", "bitmap", "app_debug"})
public final class MessageInputTextKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGMessageInputText";
    
    /**
     * Composable function to display a text input field for composing chat messages.
     *
     * This function renders a row containing a text field for message input and a send button. It
     * handles message composition, input validation, and sending messages.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void MessageInputText(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String curMessage, boolean isResettingSession, boolean inProgress, int imageMessageCount, int audioClipMessageCount, boolean modelInitializing, @androidx.annotation.StringRes()
    int textFieldPlaceHolderRes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChanged, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends com.workflow327.ui.common.chat.ChatMessage>, kotlin.Unit> onSendMessage, boolean modelPreparing, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onOpenPromptTemplatesClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStopButtonClicked, boolean showPromptTemplatesInMenu, boolean showImagePickerInMenu, boolean showAudioItemsInMenu, boolean showStopButtonWhenInProgress) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MediaPanelCloseButton(kotlin.jvm.functions.Function0<kotlin.Unit> onClicked) {
    }
    
    private static final void handleImagesSelected(android.content.Context context, java.util.List<? extends android.net.Uri> uris, kotlin.jvm.functions.Function1<? super java.util.List<android.graphics.Bitmap>, kotlin.Unit> onImagesSelected, boolean rotateForPortrait) {
    }
    
    private static final android.graphics.Bitmap rotateImageIfNecessary(android.graphics.Bitmap bitmap, boolean rotateForPortrait) {
        return null;
    }
    
    private static final void checkFrontCamera(android.content.Context context, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    private static final java.util.List<com.workflow327.ui.common.chat.ChatMessage> createMessagesToSend(java.util.List<android.graphics.Bitmap> pickedImages, java.util.List<com.workflow327.common.AudioClip> audioClips, java.lang.String text) {
        return null;
    }
}