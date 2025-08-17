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
public final class LlmAskImageViewModel_Factory implements Factory<LlmAskImageViewModel> {
  @Override
  public LlmAskImageViewModel get() {
    return newInstance();
  }

  public static LlmAskImageViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LlmAskImageViewModel newInstance() {
    return new LlmAskImageViewModel();
  }

  private static final class InstanceHolder {
    static final LlmAskImageViewModel_Factory INSTANCE = new LlmAskImageViewModel_Factory();
  }
}
