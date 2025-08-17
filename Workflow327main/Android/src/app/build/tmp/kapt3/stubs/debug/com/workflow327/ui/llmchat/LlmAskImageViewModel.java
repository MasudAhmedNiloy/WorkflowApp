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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/workflow327/ui/llmchat/LlmAskImageViewModel;", "Lcom/workflow327/ui/llmchat/LlmChatViewModelBase;", "()V", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LlmAskImageViewModel extends com.workflow327.ui.llmchat.LlmChatViewModelBase {
    
    @javax.inject.Inject()
    public LlmAskImageViewModel() {
        super(null);
    }
}