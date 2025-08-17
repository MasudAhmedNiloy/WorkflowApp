package com.workflow327.di;

import android.content.Context;
import com.workflow327.data.AuthRepository;
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
public final class AppModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<Context> contextProvider;

  private AppModule_ProvideAuthRepositoryFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(contextProvider.get());
  }

  public static AppModule_ProvideAuthRepositoryFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideAuthRepositoryFactory(contextProvider);
  }

  public static AuthRepository provideAuthRepository(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRepository(context));
  }
}
