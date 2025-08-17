package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatMessageType;", "", "(Ljava/lang/String;I)V", "INFO", "WARNING", "TEXT", "IMAGE", "IMAGE_WITH_HISTORY", "AUDIO_CLIP", "LOADING", "CLASSIFICATION", "CONFIG_VALUES_CHANGE", "BENCHMARK_RESULT", "BENCHMARK_LLM_RESULT", "PROMPT_TEMPLATES", "app_debug"})
public enum ChatMessageType {
    /*public static final*/ INFO /* = new INFO() */,
    /*public static final*/ WARNING /* = new WARNING() */,
    /*public static final*/ TEXT /* = new TEXT() */,
    /*public static final*/ IMAGE /* = new IMAGE() */,
    /*public static final*/ IMAGE_WITH_HISTORY /* = new IMAGE_WITH_HISTORY() */,
    /*public static final*/ AUDIO_CLIP /* = new AUDIO_CLIP() */,
    /*public static final*/ LOADING /* = new LOADING() */,
    /*public static final*/ CLASSIFICATION /* = new CLASSIFICATION() */,
    /*public static final*/ CONFIG_VALUES_CHANGE /* = new CONFIG_VALUES_CHANGE() */,
    /*public static final*/ BENCHMARK_RESULT /* = new BENCHMARK_RESULT() */,
    /*public static final*/ BENCHMARK_LLM_RESULT /* = new BENCHMARK_LLM_RESULT() */,
    /*public static final*/ PROMPT_TEMPLATES /* = new PROMPT_TEMPLATES() */;
    
    ChatMessageType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.ui.common.chat.ChatMessageType> getEntries() {
        return null;
    }
}