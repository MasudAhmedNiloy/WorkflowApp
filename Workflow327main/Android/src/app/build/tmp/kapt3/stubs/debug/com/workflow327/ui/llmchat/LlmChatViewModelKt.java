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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"STATS", "", "Lcom/workflow327/ui/common/chat/Stat;", "TAG", "", "app_debug"})
public final class LlmChatViewModelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGLlmChatViewModel";
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.workflow327.ui.common.chat.Stat> STATS = null;
}