package com.workflow327.ui.common;

import android.util.Log;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import com.workflow327.data.BooleanSwitchConfig;
import com.workflow327.data.Config;
import com.workflow327.data.LabelConfig;
import com.workflow327.data.NumberSliderConfig;
import com.workflow327.data.SegmentedButtonConfig;
import com.workflow327.data.ValueType;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001a~\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a*\u0010\u0018\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001a$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001a2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001a$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001c2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001a$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001e2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"TAG", "", "BooleanSwitchRow", "", "config", "Lcom/workflow327/data/BooleanSwitchConfig;", "values", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "ConfigDialog", "title", "configs", "", "Lcom/workflow327/data/Config;", "initialValues", "", "onDismissed", "Lkotlin/Function0;", "onOk", "Lkotlin/Function1;", "okBtnLabel", "subtitle", "showCancel", "", "ConfigEditorsPanel", "LabelRow", "Lcom/workflow327/data/LabelConfig;", "NumberSliderRow", "Lcom/workflow327/data/NumberSliderConfig;", "SegmentedButtonRow", "Lcom/workflow327/data/SegmentedButtonConfig;", "app_debug"})
public final class ConfigDialogKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AGConfigDialog";
    
    /**
     * Displays a configuration dialog allowing users to modify settings through various input controls.
     */
    @androidx.compose.runtime.Composable()
    public static final void ConfigDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.workflow327.data.Config> configs, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> initialValues, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, ? extends java.lang.Object>, kotlin.Unit> onOk, @org.jetbrains.annotations.NotNull()
    java.lang.String okBtnLabel, @org.jetbrains.annotations.NotNull()
    java.lang.String subtitle, boolean showCancel) {
    }
    
    /**
     * Composable function to display a list of config editor rows.
     */
    @androidx.compose.runtime.Composable()
    public static final void ConfigEditorsPanel(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.workflow327.data.Config> configs, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.String, java.lang.Object> values) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LabelRow(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.LabelConfig config, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.String, java.lang.Object> values) {
    }
    
    /**
     * Composable function to display a number slider with an associated text input field.
     *
     * This function renders a row containing a slider and a text field, both used to modify a numeric
     * value. The slider allows users to visually adjust the value within a specified range, while the
     * text field provides precise numeric input.
     */
    @androidx.compose.runtime.Composable()
    public static final void NumberSliderRow(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.NumberSliderConfig config, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.String, java.lang.Object> values) {
    }
    
    /**
     * Composable function to display a row with a boolean switch.
     *
     * This function renders a row containing a label and a switch, allowing users to toggle a boolean
     * value.
     */
    @androidx.compose.runtime.Composable()
    public static final void BooleanSwitchRow(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.BooleanSwitchConfig config, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.String, java.lang.Object> values) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SegmentedButtonRow(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.SegmentedButtonConfig config, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateMap<java.lang.String, java.lang.Object> values) {
    }
}