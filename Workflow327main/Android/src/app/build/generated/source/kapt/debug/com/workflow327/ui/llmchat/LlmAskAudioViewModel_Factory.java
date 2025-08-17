package com.workflow327.ui.llmchat;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class LlmAskAudioViewModel_Factory implements Factory<LlmAskAudioViewModel> {
  @Override
  public LlmAskAudioViewModel get() {
    return newInstance();
  }

  public static LlmAskAudioViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LlmAskAudioViewModel newInstance() {
    return new LlmAskAudioViewModel();
  }

  private static final class InstanceHolder {
    static final LlmAskAudioViewModel_Factory INSTANCE = new LlmAskAudioViewModel_Factory();
  }
}
