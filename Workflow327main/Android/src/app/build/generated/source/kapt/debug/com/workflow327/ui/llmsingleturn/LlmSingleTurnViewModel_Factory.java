package com.workflow327.ui.llmsingleturn;

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
public final class LlmSingleTurnViewModel_Factory implements Factory<LlmSingleTurnViewModel> {
  @Override
  public LlmSingleTurnViewModel get() {
    return newInstance();
  }

  public static LlmSingleTurnViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LlmSingleTurnViewModel newInstance() {
    return new LlmSingleTurnViewModel();
  }

  private static final class InstanceHolder {
    static final LlmSingleTurnViewModel_Factory INSTANCE = new LlmSingleTurnViewModel_Factory();
  }
}
