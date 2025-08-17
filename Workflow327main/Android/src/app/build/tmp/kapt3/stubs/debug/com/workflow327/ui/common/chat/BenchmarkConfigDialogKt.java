package com.workflow327.ui.common.chat;

import androidx.compose.runtime.Composable;
import com.workflow327.data.Config;
import com.workflow327.data.ConfigKey;
import com.workflow327.data.NumberSliderConfig;
import com.workflow327.data.ValueType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a^\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2<\u0010\u000f\u001a8\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n0\u0010H\u0007\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"BENCHMARK_CONFIGS", "", "Lcom/workflow327/data/Config;", "BENCHMARK_CONFIGS_INITIAL_VALUES", "", "", "", "DEFAULT_BENCHMARK_ITERATIONS", "DEFAULT_BENCHMARK_WARM_UP_ITERATIONS", "BenchmarkConfigDialog", "", "onDismissed", "Lkotlin/Function0;", "messageToBenchmark", "Lcom/workflow327/ui/common/chat/ChatMessage;", "onBenchmarkClicked", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "warmUpIterations", "benchmarkIterations", "app_debug"})
public final class BenchmarkConfigDialogKt {
    private static final float DEFAULT_BENCHMARK_WARM_UP_ITERATIONS = 50.0F;
    private static final float DEFAULT_BENCHMARK_ITERATIONS = 200.0F;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.workflow327.data.Config> BENCHMARK_CONFIGS = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.lang.Float> BENCHMARK_CONFIGS_INITIAL_VALUES = null;
    
    /**
     * Composable function to display a configuration dialog for benchmarking a chat message.
     *
     * This function renders a configuration dialog specifically tailored for setting up benchmark
     * parameters. It allows users to specify warm-up and benchmark iterations before running a
     * benchmark test on a given chat message.
     */
    @androidx.compose.runtime.Composable()
    public static final void BenchmarkConfigDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissed, @org.jetbrains.annotations.Nullable()
    com.workflow327.ui.common.chat.ChatMessage messageToBenchmark, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super com.workflow327.ui.common.chat.ChatMessage, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onBenchmarkClicked) {
    }
}