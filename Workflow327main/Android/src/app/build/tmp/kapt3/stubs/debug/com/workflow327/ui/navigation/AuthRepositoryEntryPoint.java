package com.workflow327.ui.navigation;

import android.util.Log;
import dagger.hilt.EntryPoint;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import androidx.navigation.NavType;
import com.workflow327.data.Model;
import com.workflow327.data.Task;
import com.workflow327.data.TaskType;
import com.workflow327.ui.llmchat.LlmAskAudioDestination;
import com.workflow327.ui.llmchat.LlmAskAudioViewModel;
import com.workflow327.ui.llmchat.LlmAskImageDestination;
import com.workflow327.ui.llmchat.LlmAskImageViewModel;
import com.workflow327.ui.llmchat.LlmChatDestination;
import com.workflow327.ui.llmchat.LlmChatViewModel;
import com.workflow327.ui.llmsingleturn.LlmSingleTurnDestination;
import com.workflow327.ui.llmsingleturn.LlmSingleTurnViewModel;
import com.workflow327.ui.modelmanager.ModelManagerViewModel;
import com.workflow327.ui.auth.LoginViewModel;
import com.workflow327.data.AuthRepository;
import com.workflow327.data.AuthState;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0004\u00c0\u0006\u0001"}, d2 = {"Lcom/workflow327/ui/navigation/AuthRepositoryEntryPoint;", "", "authRepository", "Lcom/workflow327/data/AuthRepository;", "app_debug"})
@dagger.hilt.EntryPoint()
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface AuthRepositoryEntryPoint {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.workflow327.data.AuthRepository authRepository();
}