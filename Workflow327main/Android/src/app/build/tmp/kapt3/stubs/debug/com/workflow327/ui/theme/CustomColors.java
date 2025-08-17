package com.workflow327.ui.theme;

import android.app.Activity;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.core.view.WindowCompat;
import com.workflow327.proto.Theme;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u00ab\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0011J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0016\u0010#\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u0013J\u0016\u0010%\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0013J\u0016\u0010\'\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0013J\u0016\u0010)\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0013J\u0016\u0010+\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0015\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0016\u00100\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0013J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0016\u00103\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0013J\u0016\u00105\u001a\u00020\u0004H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u0013J\u00b9\u0001\u00107\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020>H\u00d6\u0001J\t\u0010?\u001a\u00020@H\u00d6\u0001R\u0019\u0010\f\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\r\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\u000f\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u000e\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010\u0005\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010\t\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010\u000b\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b \u0010\u0013R\u0019\u0010\u0010\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0013\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006A"}, d2 = {"Lcom/workflow327/ui/theme/CustomColors;", "", "appTitleGradientColors", "", "Landroidx/compose/ui/graphics/Color;", "taskCardBgColor", "taskBgColors", "taskBgGradientColors", "taskIconColors", "taskIconShapeBgColor", "homeBottomGradient", "userBubbleBgColor", "agentBubbleBgColor", "linkColor", "successColor", "recordButtonBgColor", "waveFormBgColor", "(Ljava/util/List;JLjava/util/List;Ljava/util/List;Ljava/util/List;JLjava/util/List;JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAgentBubbleBgColor-0d7_KjU", "()J", "J", "getAppTitleGradientColors", "()Ljava/util/List;", "getHomeBottomGradient", "getLinkColor-0d7_KjU", "getRecordButtonBgColor-0d7_KjU", "getSuccessColor-0d7_KjU", "getTaskBgColors", "getTaskBgGradientColors", "getTaskCardBgColor-0d7_KjU", "getTaskIconColors", "getTaskIconShapeBgColor-0d7_KjU", "getUserBubbleBgColor-0d7_KjU", "getWaveFormBgColor-0d7_KjU", "component1", "component10", "component10-0d7_KjU", "component11", "component11-0d7_KjU", "component12", "component12-0d7_KjU", "component13", "component13-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component4", "component5", "component6", "component6-0d7_KjU", "component7", "component8", "component8-0d7_KjU", "component9", "component9-0d7_KjU", "copy", "copy-ADGicVo", "(Ljava/util/List;JLjava/util/List;Ljava/util/List;Ljava/util/List;JLjava/util/List;JJJJJJ)Lcom/workflow327/ui/theme/CustomColors;", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
@androidx.compose.runtime.Immutable()
public final class CustomColors {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.compose.ui.graphics.Color> appTitleGradientColors = null;
    private final long taskCardBgColor = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.compose.ui.graphics.Color> taskBgColors = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.List<androidx.compose.ui.graphics.Color>> taskBgGradientColors = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.compose.ui.graphics.Color> taskIconColors = null;
    private final long taskIconShapeBgColor = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<androidx.compose.ui.graphics.Color> homeBottomGradient = null;
    private final long userBubbleBgColor = 0L;
    private final long agentBubbleBgColor = 0L;
    private final long linkColor = 0L;
    private final long successColor = 0L;
    private final long recordButtonBgColor = 0L;
    private final long waveFormBgColor = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<androidx.compose.ui.graphics.Color>> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> component7() {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    private CustomColors(java.util.List<androidx.compose.ui.graphics.Color> appTitleGradientColors, long taskCardBgColor, java.util.List<androidx.compose.ui.graphics.Color> taskBgColors, java.util.List<? extends java.util.List<androidx.compose.ui.graphics.Color>> taskBgGradientColors, java.util.List<androidx.compose.ui.graphics.Color> taskIconColors, long taskIconShapeBgColor, java.util.List<androidx.compose.ui.graphics.Color> homeBottomGradient, long userBubbleBgColor, long agentBubbleBgColor, long linkColor, long successColor, long recordButtonBgColor, long waveFormBgColor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> getAppTitleGradientColors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> getTaskBgColors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.List<androidx.compose.ui.graphics.Color>> getTaskBgGradientColors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> getTaskIconColors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<androidx.compose.ui.graphics.Color> getHomeBottomGradient() {
        return null;
    }
}