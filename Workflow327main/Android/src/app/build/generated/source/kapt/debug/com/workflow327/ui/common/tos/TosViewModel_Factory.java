package com.workflow327.ui.common.tos;

import com.workflow327.data.DataStoreRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
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
public final class TosViewModel_Factory implements Factory<TosViewModel> {
  private final Provider<DataStoreRepository> dataStoreRepositoryProvider;

  private TosViewModel_Factory(Provider<DataStoreRepository> dataStoreRepositoryProvider) {
    this.dataStoreRepositoryProvider = dataStoreRepositoryProvider;
  }

  @Override
  public TosViewModel get() {
    return newInstance(dataStoreRepositoryProvider.get());
  }

  public static TosViewModel_Factory create(
      Provider<DataStoreRepository> dataStoreRepositoryProvider) {
    return new TosViewModel_Factory(dataStoreRepositoryProvider);
  }

  public static TosViewModel newInstance(DataStoreRepository dataStoreRepository) {
    return new TosViewModel(dataStoreRepository);
  }
}
