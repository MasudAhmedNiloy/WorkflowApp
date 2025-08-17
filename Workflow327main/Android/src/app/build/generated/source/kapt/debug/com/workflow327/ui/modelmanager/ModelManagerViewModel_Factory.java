package com.workflow327.ui.modelmanager;

import android.content.Context;
import com.workflow327.AppLifecycleProvider;
import com.workflow327.data.DataStoreRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class ModelManagerViewModel_Factory implements Factory<ModelManagerViewModel> {
  private final Provider<DataStoreRepository> dataStoreRepositoryProvider;

  private final Provider<AppLifecycleProvider> lifecycleProvider;

  private final Provider<Context> contextProvider;

  private ModelManagerViewModel_Factory(Provider<DataStoreRepository> dataStoreRepositoryProvider,
      Provider<AppLifecycleProvider> lifecycleProvider, Provider<Context> contextProvider) {
    this.dataStoreRepositoryProvider = dataStoreRepositoryProvider;
    this.lifecycleProvider = lifecycleProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public ModelManagerViewModel get() {
    return newInstance(dataStoreRepositoryProvider.get(), lifecycleProvider.get(), contextProvider.get());
  }

  public static ModelManagerViewModel_Factory create(
      Provider<DataStoreRepository> dataStoreRepositoryProvider,
      Provider<AppLifecycleProvider> lifecycleProvider, Provider<Context> contextProvider) {
    return new ModelManagerViewModel_Factory(dataStoreRepositoryProvider, lifecycleProvider, contextProvider);
  }

  public static ModelManagerViewModel newInstance(DataStoreRepository dataStoreRepository,
      AppLifecycleProvider lifecycleProvider, Context context) {
    return new ModelManagerViewModel(dataStoreRepository, lifecycleProvider, context);
  }
}
