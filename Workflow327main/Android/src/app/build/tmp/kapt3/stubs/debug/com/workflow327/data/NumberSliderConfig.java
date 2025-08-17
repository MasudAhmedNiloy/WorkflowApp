package com.workflow327.data;

/**
 * Configuration setting for a number slider.
 *
 * @param sliderMin The minimum value of the slider.
 * @param sliderMax The maximum value of the slider.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/workflow327/data/NumberSliderConfig;", "Lcom/workflow327/data/Config;", "key", "Lcom/workflow327/data/ConfigKey;", "sliderMin", "", "sliderMax", "defaultValue", "valueType", "Lcom/workflow327/data/ValueType;", "needReinitialization", "", "(Lcom/workflow327/data/ConfigKey;FFFLcom/workflow327/data/ValueType;Z)V", "getDefaultValue", "()Ljava/lang/Float;", "getKey", "()Lcom/workflow327/data/ConfigKey;", "getNeedReinitialization", "()Z", "getSliderMax", "()F", "getSliderMin", "getValueType", "()Lcom/workflow327/data/ValueType;", "app_debug"})
public final class NumberSliderConfig extends com.workflow327.data.Config {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.ConfigKey key = null;
    private final float sliderMin = 0.0F;
    private final float sliderMax = 0.0F;
    private final float defaultValue = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.ValueType valueType = null;
    private final boolean needReinitialization = false;
    
    public NumberSliderConfig(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigKey key, float sliderMin, float sliderMax, float defaultValue, @org.jetbrains.annotations.NotNull()
    com.workflow327.data.ValueType valueType, boolean needReinitialization) {
        super(null, null, null, null, false);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.data.ConfigKey getKey() {
        return null;
    }
    
    public final float getSliderMin() {
        return 0.0F;
    }
    
    public final float getSliderMax() {
        return 0.0F;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.Float getDefaultValue() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.data.ValueType getValueType() {
        return null;
    }
    
    @java.lang.Override()
    public boolean getNeedReinitialization() {
        return false;
    }
}