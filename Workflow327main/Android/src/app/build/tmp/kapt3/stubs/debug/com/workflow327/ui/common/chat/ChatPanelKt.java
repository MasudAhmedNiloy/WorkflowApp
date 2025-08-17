package com.workflow327.ui.common.chat;

import android.content.ClipData;
import android.graphics.Bitmap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.ClipEntry;
import com.workflow327.R;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.data.TaskType;
import com.workflow327.ui.modelmanager.ModelInitializationStatusType;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u00aa\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00010\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000b2B\u0010\u000f\u001a>\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007\u00a8\u0006%"}, d2 = {"ChatPanel", "", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "task", "Lcom/workflow327/data/Task;", "selectedModel", "Lcom/workflow327/data/Model;", "viewModel", "Lcom/workflow327/ui/common/chat/ChatViewModel;", "onSendMessage", "Lkotlin/Function2;", "", "Lcom/workflow327/ui/common/chat/ChatMessage;", "onRunAgainClicked", "onBenchmarkClicked", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "warmUpIterations", "benchmarkIterations", "navigateUp", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onStreamImageMessage", "Lcom/workflow327/ui/common/chat/ChatMessageImage;", "onStreamEnd", "Lkotlin/Function1;", "onStopButtonClicked", "onImageSelected", "Landroid/graphics/Bitmap;", "chatInputType", "Lcom/workflow327/ui/common/chat/ChatInputType;", "showStopButtonInInputWhenInProgress", "", "app_debug"})
public final class ChatPanelKt {
    
    /**
     * Composable function for the main chat panel, displaying messages and handling user input.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ChatPanel(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model selectedModel, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.workflow327.data.Model, ? super java.util.List<? extends com.workflow327.ui.common.chat.ChatMessage>, kotlin.Unit> onSendMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.workflow327.data.Model, ? super com.workflow327.ui.common.chat.ChatMessage, kotlin.Unit> onRunAgainClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super com.workflow327.data.Model, ? super com.workflow327.ui.common.chat.ChatMessage, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onBenchmarkClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.workflow327.data.Model, ? super com.workflow327.ui.common.chat.ChatMessageImage, kotlin.Unit> onStreamImageMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onStreamEnd, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStopButtonClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> onImageSelected, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatInputType chatInputType, boolean showStopButtonInInputWhenInProgress) {
    }
}