package com.workflow327.ui.llmchat;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.workflow327.data.ConfigKey;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.ui.common.chat.ChatMessageAudioClip;
import com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult;
import com.workflow327.ui.common.chat.ChatMessageLoading;
import com.workflow327.ui.common.chat.ChatMessageText;
import com.workflow327.ui.common.chat.ChatMessageType;
import com.workflow327.ui.common.chat.ChatMessageWarning;
import com.workflow327.ui.common.chat.ChatSide;
import com.workflow327.ui.common.chat.ChatViewModel;
import com.workflow327.ui.common.chat.Stat;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/workflow327/ui/llmchat/LlmChatViewModelBase;", "Lcom/workflow327/ui/common/chat/ChatViewModel;", "curTask", "Lcom/workflow327/data/Task;", "(Lcom/workflow327/data/Task;)V", "getCurTask", "()Lcom/workflow327/data/Task;", "generateResponse", "", "model", "Lcom/workflow327/data/Model;", "input", "", "images", "", "Landroid/graphics/Bitmap;", "audioMessages", "Lcom/workflow327/ui/common/chat/ChatMessageAudioClip;", "onError", "Lkotlin/Function0;", "handleError", "context", "Landroid/content/Context;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "triggeredMessage", "Lcom/workflow327/ui/common/chat/ChatMessageText;", "resetSession", "runAgain", "message", "stopResponse", "app_debug"})
public class LlmChatViewModelBase extends com.workflow327.ui.common.chat.ChatViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.Task curTask = null;
    
    public LlmChatViewModelBase(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task curTask) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.Task getCurTask() {
        return null;
    }
    
    public final void generateResponse(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input, @org.jetbrains.annotations.NotNull()
    java.util.List<android.graphics.Bitmap> images, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.ui.common.chat.ChatMessageAudioClip> audioMessages, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onError) {
    }
    
    public final void stopResponse(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void resetSession(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    public final void runAgain(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessageText message, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onError) {
    }
    
    public final void handleError(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.Nullable()
    com.workflow327.ui.common.chat.ChatMessageText triggeredMessage) {
    }
}