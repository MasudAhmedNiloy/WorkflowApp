package com.workflow327.ui.llmchat;

import android.graphics.Bitmap;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import com.workflow327.ui.common.chat.ChatMessageAudioClip;
import com.workflow327.ui.common.chat.ChatMessageImage;
import com.workflow327.ui.common.chat.ChatMessageText;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007\u001a0\u0010\f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\rH\u0007\u001a0\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"ChatViewWrapper", "", "viewModel", "Lcom/workflow327/ui/llmchat/LlmChatViewModelBase;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "navigateUp", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "LlmAskAudioScreen", "Lcom/workflow327/ui/llmchat/LlmAskAudioViewModel;", "LlmAskImageScreen", "Lcom/workflow327/ui/llmchat/LlmAskImageViewModel;", "LlmChatScreen", "Lcom/workflow327/ui/llmchat/LlmChatViewModel;", "app_debug"})
public final class LlmChatScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void LlmChatScreen(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmchat.LlmChatViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LlmAskImageScreen(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmchat.LlmAskImageViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LlmAskAudioScreen(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmchat.LlmAskAudioViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ChatViewWrapper(@org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmchat.LlmChatViewModelBase viewModel, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navigateUp, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}