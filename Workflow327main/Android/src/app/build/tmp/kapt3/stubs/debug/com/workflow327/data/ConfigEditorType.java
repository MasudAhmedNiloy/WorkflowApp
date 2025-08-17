package com.workflow327.data;

/**
 * The types of configuration editors available.
 *
 * This enum defines the different UI components used to edit configuration values. Each type
 * corresponds to a specific editor widget, such as a slider or a switch.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/workflow327/data/ConfigEditorType;", "", "(Ljava/lang/String;I)V", "LABEL", "NUMBER_SLIDER", "BOOLEAN_SWITCH", "DROPDOWN", "app_debug"})
public enum ConfigEditorType {
    /*public static final*/ LABEL /* = new LABEL() */,
    /*public static final*/ NUMBER_SLIDER /* = new NUMBER_SLIDER() */,
    /*public static final*/ BOOLEAN_SWITCH /* = new BOOLEAN_SWITCH() */,
    /*public static final*/ DROPDOWN /* = new DROPDOWN() */;
    
    ConfigEditorType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.workflow327.data.ConfigEditorType> getEntries() {
        return null;
    }
}