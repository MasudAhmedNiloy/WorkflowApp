package com.workflow327.di;

import com.workflow327.AppLifecycleProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideAppLifecycleProviderFactory implements Factory<AppLifecycleProvider> {
  @Override
  public AppLifecycleProvider get() {
    return provideAppLifecycleProvider();
  }

  public static AppModule_ProvideAppLifecycleProviderFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AppLifecycleProvider provideAppLifecycleProvider() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAppLifecycleProvider());
  }

  private static final class InstanceHolder {
    static final AppModule_ProvideAppLifecycleProviderFactory INSTANCE = new AppModule_ProvideAppLifecycleProviderFactory();
  }
}
