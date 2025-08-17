package com.workflow327.ui.llmsingleturn;

import android.content.ClipData;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import com.workflow327.R;
import com.workflow327.data.Model;
import com.workflow327.ui.common.chat.MessageBubbleShape;
import com.workflow327.ui.modelmanager.ModelInitializationStatusType;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aa\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n0\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"FULL_PROMPT_SWITCH_KEY", "", "ICON_BUTTON_SIZE", "Landroidx/compose/ui/unit/Dp;", "F", "TAB_TITLES", "", "promptTemplateTypes", "Lcom/workflow327/ui/llmsingleturn/PromptTemplateType;", "PromptTemplatesPanel", "", "model", "Lcom/workflow327/data/Model;", "viewModel", "Lcom/workflow327/ui/llmsingleturn/LlmSingleTurnViewModel;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "onSend", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "fullPrompt", "onStopButtonClicked", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class PromptTemplatesPanelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.workflow327.ui.llmsingleturn.PromptTemplateType> promptTemplateTypes = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> TAB_TITLES = null;
    private static final float ICON_BUTTON_SIZE = 0.0F;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FULL_PROMPT_SWITCH_KEY = "full_prompt";
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PromptTemplatesPanel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmsingleturn.LlmSingleTurnViewModel viewModel, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSend, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.workflow327.data.Model, kotlin.Unit> onStopButtonClicked, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}