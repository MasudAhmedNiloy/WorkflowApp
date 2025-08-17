package com.workflow327.ui.llmsingleturn;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult;
import com.workflow327.ui.common.chat.Stat;
import com.workflow327.ui.llmchat.LlmChatModelHelper;
import com.workflow327.ui.llmchat.LlmModelInstance;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006!"}, d2 = {"Lcom/workflow327/ui/llmsingleturn/LlmSingleTurnViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/workflow327/ui/llmsingleturn/LlmSingleTurnUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "createUiState", "task", "Lcom/workflow327/data/Task;", "generateResponse", "", "model", "Lcom/workflow327/data/Model;", "input", "", "selectPromptTemplate", "promptTemplateType", "Lcom/workflow327/ui/llmsingleturn/PromptTemplateType;", "setInProgress", "inProgress", "", "setPreparing", "preparing", "stopResponse", "updateBenchmark", "benchmark", "Lcom/workflow327/ui/common/chat/ChatMessageBenchmarkLlmResult;", "updateResponse", "response", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class LlmSingleTurnViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.workflow327.ui.llmsingleturn.LlmSingleTurnUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.workflow327.ui.llmsingleturn.LlmSingleTurnUiState> uiState = null;
    
    @javax.inject.Inject()
    public LlmSingleTurnViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.workflow327.ui.llmsingleturn.LlmSingleTurnUiState> getUiState() {
        return null;
    }
    
    public final void generateResponse(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    java.lang.String input) {
    }
    
    public final void selectPromptTemplate(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmsingleturn.PromptTemplateType promptTemplateType) {
    }
    
    public final void setInProgress(boolean inProgress) {
    }
    
    public final void setPreparing(boolean preparing) {
    }
    
    public final void updateResponse(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmsingleturn.PromptTemplateType promptTemplateType, @org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void updateBenchmark(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.llmsingleturn.PromptTemplateType promptTemplateType, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.common.chat.ChatMessageBenchmarkLlmResult benchmark) {
    }
    
    public final void stopResponse(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.Model model) {
    }
    
    private final com.workflow327.ui.llmsingleturn.LlmSingleTurnUiState createUiState(com.workflow327.data.Task task) {
        return null;
    }
}