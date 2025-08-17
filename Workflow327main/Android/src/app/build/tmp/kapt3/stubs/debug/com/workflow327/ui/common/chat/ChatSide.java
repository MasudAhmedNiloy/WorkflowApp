package com.workflow327.ui.common.chat;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import com.workflow327.common.Classification;
import com.workflow327.data.Model;
import com.workflow327.data.PromptTemplate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/workflow327/ui/common/chat/ChatSide;", "", "(Ljava/lang/String;I)V", "USER", "AGENT", "SYSTEM", "app_debug"})
public enum ChatSide {
    /*public static final*/ USER /* = new USER() */,
    /*public static final*/ AGENT /* = new AGENT() */,
    /*public static final*/ SYSTEM /* = new SYSTEM() */;
    
    ChatSide() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.ui.common.chat.ChatSide> getEntries() {
        return null;
    }
}