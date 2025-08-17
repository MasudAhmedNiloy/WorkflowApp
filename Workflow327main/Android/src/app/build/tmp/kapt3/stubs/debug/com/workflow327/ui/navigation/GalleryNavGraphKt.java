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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001a\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001a\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b\u001a\"\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0017\u001a\u0010\u0010 \u001a\u00020!*\u0006\u0012\u0002\b\u00030\"H\u0002\u001a\u0010\u0010#\u001a\u00020$*\u0006\u0012\u0002\b\u00030\"H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"ENTER_ANIMATION_DELAY_MS", "", "ENTER_ANIMATION_DURATION_MS", "ENTER_ANIMATION_EASING", "Landroidx/compose/animation/core/Easing;", "EXIT_ANIMATION_DURATION_MS", "EXIT_ANIMATION_EASING", "ROUTE_PLACEHOLDER", "", "TAG", "WorkflowNavHost", "", "navController", "Landroidx/navigation/NavHostController;", "modifier", "Landroidx/compose/ui/Modifier;", "modelManagerViewModel", "Lcom/workflow327/ui/modelmanager/ModelManagerViewModel;", "enterTween", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "exitTween", "getModelFromNavigationParam", "Lcom/workflow327/data/Model;", "entry", "Landroidx/navigation/NavBackStackEntry;", "task", "Lcom/workflow327/data/Task;", "navigateToTaskScreen", "taskType", "Lcom/workflow327/data/TaskType;", "model", "slideEnter", "Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "slideExit", "Landroidx/compose/animation/ExitTransition;", "app_debug"})
public final class GalleryNavGraphKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGWorkflowNavGraph";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ROUTE_PLACEHOLDER = "placeholder";
    private static final int ENTER_ANIMATION_DURATION_MS = 500;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.animation.core.Easing ENTER_ANIMATION_EASING = null;
    private static final int ENTER_ANIMATION_DELAY_MS = 100;
    private static final int EXIT_ANIMATION_DURATION_MS = 500;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.compose.animation.core.Easing EXIT_ANIMATION_EASING = null;
    
    private static final androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> enterTween() {
        return null;
    }
    
    private static final androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> exitTween() {
        return null;
    }
    
    private static final androidx.compose.animation.EnterTransition slideEnter(androidx.compose.animation.AnimatedContentTransitionScope<?> $this$slideEnter) {
        return null;
    }
    
    private static final androidx.compose.animation.ExitTransition slideExit(androidx.compose.animation.AnimatedContentTransitionScope<?> $this$slideExit) {
        return null;
    }
    
    /**
     * Navigation routes.
     */
    @androidx.compose.runtime.Composable()
    public static final void WorkflowNavHost(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.workflow327.ui.modelmanager.ModelManagerViewModel modelManagerViewModel) {
    }
    
    public static final void navigateToTaskScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.TaskType taskType, @org.jetbrains.annotations.Nullable()
    com.workflow327.data.Model model) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.workflow327.data.Model getModelFromNavigationParam(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavBackStackEntry entry, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.Task task) {
        return null;
    }
}