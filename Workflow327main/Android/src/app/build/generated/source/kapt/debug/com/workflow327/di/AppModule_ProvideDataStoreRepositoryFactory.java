package com.workflow327.di;

import androidx.datastore.core.DataStore;
import com.workflow327.data.DataStoreRepository;
import com.workflow327.proto.Settings;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
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
public final class AppModule_ProvideDataStoreRepositoryFactory implements Factory<DataStoreRepository> {
  private final Provider<DataStore<Settings>> dataStoreProvider;

  private AppModule_ProvideDataStoreRepositoryFactory(
      Provider<DataStore<Settings>> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public DataStoreRepository get() {
    return provideDataStoreRepository(dataStoreProvider.get());
  }

  public static AppModule_ProvideDataStoreRepositoryFactory create(
      Provider<DataStore<Settings>> dataStoreProvider) {
    return new AppModule_ProvideDataStoreRepositoryFactory(dataStoreProvider);
  }

  public static DataStoreRepository provideDataStoreRepository(DataStore<Settings> dataStore) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDataStoreRepository(dataStore));
  }
}
