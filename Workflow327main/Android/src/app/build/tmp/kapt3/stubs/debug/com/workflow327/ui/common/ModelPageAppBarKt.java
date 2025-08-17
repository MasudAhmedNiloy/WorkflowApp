package com.workflow327.ui.common;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.workflow327.data.Model;
import com.workflow327.data.ModelDownloadStatusType;
import com.workflow327.data.Task;
import com.workflow327.ui.modelmanager.ModelInitializationStatusType;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00d8\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\r2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\r2P\b\u0002\u0010\u0014\u001aJ\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00010\u0015H\u0007\u00a8\u0006\u001d"}, d2 = {"ModelPageAppBar", "", "task", "Lcom/workflow327/data/Task;", "model", "Lcom/workflow327/data/Model;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "onBackClicked", "Lkotlin/Function0;", "onModelSelected", "Lkotlin/Function1;", "inProgress", "", "modelPreparing", "modifier", "Landroidx/compose/ui/Modifier;", "isResettingSession", "onResetSessionClicked", "canShowResetSessionButton", "onConfigChanged", "Lkotlin/Function2;", "", "", "", "Lkotlin/ParameterName;", "name", "oldConfigValues", "newConfigValues", "app_debug"})
public final class ModelPageAppBarKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ModelPageAppBar(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.data.Model, kotlin.Unit> onModelSelected, boolean inProgress, boolean modelPreparing, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean isResettingSession, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.data.Model, kotlin.Unit> onResetSessionClicked, boolean canShowResetSessionButton, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.util.Map<java.lang.String, ? extends java.lang.Object>, ? super java.util.Map<java.lang.String, ? extends java.lang.Object>, kotlin.Unit> onConfigChanged) {
    }
}