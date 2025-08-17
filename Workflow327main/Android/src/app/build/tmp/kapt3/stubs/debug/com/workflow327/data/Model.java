package com.workflow327.data;

import android.content.Context;
import java.io.File;

/**
 * A model for a task
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\bO\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010#J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0011H\u00c6\u0003J\t\u0010R\u001a\u00020\u0011H\u00c6\u0003J\t\u0010S\u001a\u00020\u0011H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00160\nH\u00c6\u0003J\t\u0010V\u001a\u00020\u0011H\u00c6\u0003J\t\u0010W\u001a\u00020\u0011H\u00c6\u0003J\t\u0010X\u001a\u00020\u0011H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0011H\u00c6\u0003J\t\u0010]\u001a\u00020\u0011H\u00c6\u0003J\u0015\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001fH\u00c6\u0003J\t\u0010_\u001a\u00020\bH\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u00104J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010d\u001a\u00020\bH\u00c6\u0003J\u000f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\t\u0010f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010g\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u00c6\u0003J\u00ac\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\u00112\b\u0010l\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0018\u0010m\u001a\u00020\u00112\u0006\u0010n\u001a\u00020o2\b\b\u0002\u0010p\u001a\u00020\u0011J\u0010\u0010q\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010r\u001a\u00020s2\u0006\u0010n\u001a\u00020o2\b\b\u0002\u0010p\u001a\u00020sJ\u0018\u0010t\u001a\u00020u2\u0006\u0010n\u001a\u00020o2\b\b\u0002\u0010p\u001a\u00020uJ\u0018\u0010v\u001a\u00020\u00032\u0006\u0010w\u001a\u00020x2\b\b\u0002\u0010y\u001a\u00020\u0003J\u0018\u0010z\u001a\u00020\u00032\u0006\u0010n\u001a\u00020o2\b\b\u0002\u0010p\u001a\u00020\u0003J \u0010{\u001a\u00020\u00012\u0006\u0010n\u001a\u00020o2\u0006\u0010|\u001a\u00020}2\u0006\u0010p\u001a\u00020\u0001H\u0002J\t\u0010~\u001a\u00020uH\u00d6\u0001J\u0007\u0010\u007f\u001a\u00030\u0080\u0001J\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010\u001d\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0015\u0010\"\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00101R\u0011\u0010\u0019\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010)R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00101R\u0011\u0010\u0018\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0011\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010%R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010\'R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010)R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001a\u0010 \u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010I\"\u0004\bK\u0010LR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010%\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/workflow327/data/Model;", "", "name", "", "version", "downloadFileName", "url", "sizeInBytes", "", "extraDataFiles", "", "Lcom/workflow327/data/ModelDataFile;", "info", "learnMoreUrl", "configs", "Lcom/workflow327/data/Config;", "showRunAgainButton", "", "showBenchmarkButton", "isZip", "unzipDir", "llmPromptTemplates", "Lcom/workflow327/data/PromptTemplate;", "llmSupportImage", "llmSupportAudio", "imported", "normalizedName", "instance", "initializing", "cleanUpAfterInit", "configValues", "", "totalBytes", "accessToken", "estimatedPeakMemoryInBytes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZLjava/lang/String;Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/Object;ZZLjava/util/Map;JLjava/lang/String;Ljava/lang/Long;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getCleanUpAfterInit", "()Z", "setCleanUpAfterInit", "(Z)V", "getConfigValues", "()Ljava/util/Map;", "setConfigValues", "(Ljava/util/Map;)V", "getConfigs", "()Ljava/util/List;", "getDownloadFileName", "getEstimatedPeakMemoryInBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtraDataFiles", "getImported", "getInfo", "getInitializing", "setInitializing", "getInstance", "()Ljava/lang/Object;", "setInstance", "(Ljava/lang/Object;)V", "getLearnMoreUrl", "getLlmPromptTemplates", "getLlmSupportAudio", "getLlmSupportImage", "getName", "getNormalizedName", "setNormalizedName", "getShowBenchmarkButton", "getShowRunAgainButton", "getSizeInBytes", "()J", "getTotalBytes", "setTotalBytes", "(J)V", "getUnzipDir", "getUrl", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZLjava/lang/String;Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/Object;ZZLjava/util/Map;JLjava/lang/String;Ljava/lang/Long;)Lcom/workflow327/data/Model;", "equals", "other", "getBooleanConfigValue", "key", "Lcom/workflow327/data/ConfigKey;", "defaultValue", "getExtraDataFile", "getFloatConfigValue", "", "getIntConfigValue", "", "getPath", "context", "Landroid/content/Context;", "fileName", "getStringConfigValue", "getTypedConfigValue", "valueType", "Lcom/workflow327/data/ValueType;", "hashCode", "preProcess", "", "toString", "app_debug"})
public final class Model {
    
    /**
     * The name (for display purpose) of the model.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    
    /**
     * The version of the model.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String version = null;
    
    /**
     * The name of the downloaded model file.
     *
     * The final file path of the downloaded model will be:
     * {context.getExternalFilesDir}/{normalizedName}/{version}/{downloadFileName}
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String downloadFileName = null;
    
    /**
     * The URL to download the model from.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    
    /**
     * The size of the model file in bytes.
     */
    private final long sizeInBytes = 0L;
    
    /**
     * A list of additional data files required by the model.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.data.ModelDataFile> extraDataFiles = null;
    
    /**
     * A description or information about the model.
     *
     * Will be shown at the start of the chat session and in the expanded model item.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String info = null;
    
    /**
     * The url to jump to when clicking "learn more" in expanded model item.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String learnMoreUrl = null;
    
    /**
     * A list of configurable parameters for the model.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.data.Config> configs = null;
    
    /**
     * Whether to show the "run again" button in the UI.
     */
    private final boolean showRunAgainButton = false;
    
    /**
     * Whether to show the "benchmark" button in the UI.
     */
    private final boolean showBenchmarkButton = false;
    
    /**
     * Indicates whether the model is a zip file.
     */
    private final boolean isZip = false;
    
    /**
     * The name of the directory to unzip the model to (if it's a zip file).
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String unzipDir = null;
    
    /**
     * The prompt templates for the model (only for LLM).
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.workflow327.data.PromptTemplate> llmPromptTemplates = null;
    
    /**
     * Whether the LLM model supports image input.
     */
    private final boolean llmSupportImage = false;
    
    /**
     * Whether the LLM model supports audio input.
     */
    private final boolean llmSupportAudio = false;
    
    /**
     * Whether the model is imported or not.
     */
    private final boolean imported = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String normalizedName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object instance;
    private boolean initializing;
    private boolean cleanUpAfterInit;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, ? extends java.lang.Object> configValues;
    private long totalBytes;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String accessToken;
    
    /**
     * The estimated peak memory in byte to run the model.
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long estimatedPeakMemoryInBytes = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.PromptTemplate> component14() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean component17() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component20() {
        return false;
    }
    
    public final boolean component21() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> component22() {
        return null;
    }
    
    public final long component23() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.ModelDataFile> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.Config> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.Model copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadFileName, @org.jetbrains.annotations.NotNull()
    java.lang.String url, long sizeInBytes, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.ModelDataFile> extraDataFiles, @org.jetbrains.annotations.NotNull()
    java.lang.String info, @org.jetbrains.annotations.NotNull()
    java.lang.String learnMoreUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.workflow327.data.Config> configs, boolean showRunAgainButton, boolean showBenchmarkButton, boolean isZip, @org.jetbrains.annotations.NotNull()
    java.lang.String unzipDir, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.PromptTemplate> llmPromptTemplates, boolean llmSupportImage, boolean llmSupportAudio, boolean imported, @org.jetbrains.annotations.NotNull()
    java.lang.String normalizedName, @org.jetbrains.annotations.Nullable()
    java.lang.Object instance, boolean initializing, boolean cleanUpAfterInit, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> configValues, long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    java.lang.Long estimatedPeakMemoryInBytes) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public Model(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadFileName, @org.jetbrains.annotations.NotNull()
    java.lang.String url, long sizeInBytes, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.ModelDataFile> extraDataFiles, @org.jetbrains.annotations.NotNull()
    java.lang.String info, @org.jetbrains.annotations.NotNull()
    java.lang.String learnMoreUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.workflow327.data.Config> configs, boolean showRunAgainButton, boolean showBenchmarkButton, boolean isZip, @org.jetbrains.annotations.NotNull()
    java.lang.String unzipDir, @org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.data.PromptTemplate> llmPromptTemplates, boolean llmSupportImage, boolean llmSupportAudio, boolean imported, @org.jetbrains.annotations.NotNull()
    java.lang.String normalizedName, @org.jetbrains.annotations.Nullable()
    java.lang.Object instance, boolean initializing, boolean cleanUpAfterInit, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> configValues, long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken, @org.jetbrains.annotations.Nullable()
    java.lang.Long estimatedPeakMemoryInBytes) {
        super();
    }
    
    /**
     * The name (for display purpose) of the model.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    /**
     * The version of the model.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVersion() {
        return null;
    }
    
    /**
     * The name of the downloaded model file.
     *
     * The final file path of the downloaded model will be:
     * {context.getExternalFilesDir}/{normalizedName}/{version}/{downloadFileName}
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDownloadFileName() {
        return null;
    }
    
    /**
     * The URL to download the model from.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    /**
     * The size of the model file in bytes.
     */
    public final long getSizeInBytes() {
        return 0L;
    }
    
    /**
     * A list of additional data files required by the model.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.ModelDataFile> getExtraDataFiles() {
        return null;
    }
    
    /**
     * A description or information about the model.
     *
     * Will be shown at the start of the chat session and in the expanded model item.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInfo() {
        return null;
    }
    
    /**
     * The url to jump to when clicking "learn more" in expanded model item.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLearnMoreUrl() {
        return null;
    }
    
    /**
     * A list of configurable parameters for the model.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.Config> getConfigs() {
        return null;
    }
    
    /**
     * Whether to show the "run again" button in the UI.
     */
    public final boolean getShowRunAgainButton() {
        return false;
    }
    
    /**
     * Whether to show the "benchmark" button in the UI.
     */
    public final boolean getShowBenchmarkButton() {
        return false;
    }
    
    /**
     * Indicates whether the model is a zip file.
     */
    public final boolean isZip() {
        return false;
    }
    
    /**
     * The name of the directory to unzip the model to (if it's a zip file).
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnzipDir() {
        return null;
    }
    
    /**
     * The prompt templates for the model (only for LLM).
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.workflow327.data.PromptTemplate> getLlmPromptTemplates() {
        return null;
    }
    
    /**
     * Whether the LLM model supports image input.
     */
    public final boolean getLlmSupportImage() {
        return false;
    }
    
    /**
     * Whether the LLM model supports audio input.
     */
    public final boolean getLlmSupportAudio() {
        return false;
    }
    
    /**
     * Whether the model is imported or not.
     */
    public final boolean getImported() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNormalizedName() {
        return null;
    }
    
    public final void setNormalizedName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getInstance() {
        return null;
    }
    
    public final void setInstance(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    public final boolean getInitializing() {
        return false;
    }
    
    public final void setInitializing(boolean p0) {
    }
    
    public final boolean getCleanUpAfterInit() {
        return false;
    }
    
    public final void setCleanUpAfterInit(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> getConfigValues() {
        return null;
    }
    
    public final void setConfigValues(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> p0) {
    }
    
    public final long getTotalBytes() {
        return 0L;
    }
    
    public final void setTotalBytes(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAccessToken() {
        return null;
    }
    
    public final void setAccessToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    /**
     * The estimated peak memory in byte to run the model.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getEstimatedPeakMemoryInBytes() {
        return null;
    }
    
    public final void preProcess() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    public final int getIntConfigValue(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigKey key, int defaultValue) {
        return 0;
    }
    
    public final float getFloatConfigValue(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigKey key, float defaultValue) {
        return 0.0F;
    }
    
    public final boolean getBooleanConfigValue(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigKey key, boolean defaultValue) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStringConfigValue(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.ConfigKey key, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultValue) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.workflow327.data.ModelDataFile getExtraDataFile(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    private final java.lang.Object getTypedConfigValue(com.workflow327.data.ConfigKey key, com.workflow327.data.ValueType valueType, java.lang.Object defaultValue) {
        return null;
    }
}