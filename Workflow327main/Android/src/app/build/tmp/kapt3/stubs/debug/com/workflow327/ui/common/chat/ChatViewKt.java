package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import com.workflow327.data.Model;
import com.workflow327.data.ModelDownloadStatusType;
import com.workflow327.data.Task;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;
import com.workflow327.ui.modelmanager.PagerScrollState;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u00f4\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u000b2$\u0010\u0010\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u00182\u001a\b\u0002\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u000b2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"TAG", "", "ChatView", "", "task", "Lcom/workflow327/data/Task;", "viewModel", "Lcom/workflow327/ui/common/chat/ChatViewModel;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "onSendMessage", "Lkotlin/Function2;", "Lcom/workflow327/data/Model;", "", "Lcom/workflow327/ui/common/chat/ChatMessage;", "onRunAgainClicked", "onBenchmarkClicked", "Lkotlin/Function4;", "", "navigateUp", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onResetSessionClicked", "Lkotlin/Function1;", "onStreamImageMessage", "Lcom/workflow327/ui/common/chat/ChatMessageImage;", "onStopButtonClicked", "chatInputType", "Lcom/workflow327/ui/common/chat/ChatInputType;", "showStopButtonInInputWhenInProgress", "", "app_debug"})
public final class ChatViewKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGChatView";
    
    /**
     * A composable that displays a chat interface, allowing users to interact with different models
     * associated with a given task.
     *
     * This composable provides a horizontal pager for switching between models, a model selector for
     * configuring the selected model, and a chat panel for sending and receiving messages. It also
     * manages model initialization, cleanup, and download status, and handles navigation and system
     * back gestures.
     */
    @androidx.compose.runtime.Composable()
    public static final void ChatView(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.workflow327.data.Model, ? super java.util.List<? extends com.workflow327.ui.common.chat.ChatMessage>, kotlin.Unit> onSendMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.workflow327.data.Model, ? super com.workflow327.ui.common.chat.ChatMessage, kotlin.Unit> onRunAgainClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super com.workflow327.data.Model, ? super com.workflow327.ui.common.chat.ChatMessage, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onBenchmarkClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.data.Model, kotlin.Unit> onResetSessionClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.workflow327.data.Model, ? super com.workflow327.ui.common.chat.ChatMessageImage, kotlin.Unit> onStreamImageMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.data.Model, kotlin.Unit> onStopButtonClicked, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatInputType chatInputType, boolean showStopButtonInInputWhenInProgress) {
    }
}