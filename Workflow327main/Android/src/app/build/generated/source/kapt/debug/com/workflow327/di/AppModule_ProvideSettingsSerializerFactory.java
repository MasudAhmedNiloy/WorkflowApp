package com.workflow327.di;

import androidx.datastore.core.Serializer;
import com.workflow327.proto.Settings;
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
public final class AppModule_ProvideSettingsSerializerFactory implements Factory<Serializer<Settings>> {
  @Override
  public Serializer<Settings> get() {
    return provideSettingsSerializer();
  }

  public static AppModule_ProvideSettingsSerializerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Serializer<Settings> provideSettingsSerializer() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSettingsSerializer());
  }

  private static final class InstanceHolder {
    static final AppModule_ProvideSettingsSerializerFactory INSTANCE = new AppModule_ProvideSettingsSerializerFactory();
  }
}
