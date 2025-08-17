package com.workflow327.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.Serializer;
import com.workflow327.proto.Settings;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideSettingsDataStoreFactory implements Factory<DataStore<Settings>> {
  private final Provider<Context> contextProvider;

  private final Provider<Serializer<Settings>> settingsSerializerProvider;

  private AppModule_ProvideSettingsDataStoreFactory(Provider<Context> contextProvider,
      Provider<Serializer<Settings>> settingsSerializerProvider) {
    this.contextProvider = contextProvider;
    this.settingsSerializerProvider = settingsSerializerProvider;
  }

  @Override
  public DataStore<Settings> get() {
    return provideSettingsDataStore(contextProvider.get(), settingsSerializerProvider.get());
  }

  public static AppModule_ProvideSettingsDataStoreFactory create(Provider<Context> contextProvider,
      Provider<Serializer<Settings>> settingsSerializerProvider) {
    return new AppModule_ProvideSettingsDataStoreFactory(contextProvider, settingsSerializerProvider);
  }

  public static DataStore<Settings> provideSettingsDataStore(Context context,
      Serializer<Settings> settingsSerializer) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSettingsDataStore(context, settingsSerializer));
  }
}
