package com.workflow327.data;

/**
 * Base class for configuration settings.
 *
 * @param type The type of configuration editor.
 * @param key The unique key for the configuration setting.
 * @param defaultValue The default value for the configuration setting.
 * @param valueType The data type of the configuration value.
 * @param needReinitialization Indicates whether the model needs to be reinitialized after changing
 *  this config.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/workflow327/data/Config;", "", "type", "Lcom/workflow327/data/ConfigEditorType;", "key", "Lcom/workflow327/data/ConfigKey;", "defaultValue", "valueType", "Lcom/workflow327/data/ValueType;", "needReinitialization", "", "(Lcom/workflow327/data/ConfigEditorType;Lcom/workflow327/data/ConfigKey;Ljava/lang/Object;Lcom/workflow327/data/ValueType;Z)V", "getDefaultValue", "()Ljava/lang/Object;", "getKey", "()Lcom/workflow327/data/ConfigKey;", "getNeedReinitialization", "()Z", "getType", "()Lcom/workflow327/data/ConfigEditorType;", "getValueType", "()Lcom/workflow327/data/ValueType;", "app_debug"})
public class Config {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.ConfigEditorType type = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.ConfigKey key = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object defaultValue = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.ValueType valueType = null;
    private final boolean needReinitialization = false;
    
    public Config(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigEditorType type, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigKey key, @org.jetbrains.annotations.NotNull()
    java.lang.Object defaultValue, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.ValueType valueType, boolean needReinitialization) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.ConfigEditorType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.data.ConfigKey getKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.Object getDefaultValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.data.ValueType getValueType() {
        return null;
    }
    
    public boolean getNeedReinitialization() {
        return false;
    }
}