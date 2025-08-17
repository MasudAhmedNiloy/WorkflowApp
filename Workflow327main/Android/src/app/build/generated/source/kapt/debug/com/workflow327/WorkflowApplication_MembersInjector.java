package com.workflow327;

import com.workflow327.data.DataStoreRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class WorkflowApplication_MembersInjector implements MembersInjector<WorkflowApplication> {
  private final Provider<DataStoreRepository> dataStoreRepositoryProvider;

  private WorkflowApplication_MembersInjector(
      Provider<DataStoreRepository> dataStoreRepositoryProvider) {
    this.dataStoreRepositoryProvider = dataStoreRepositoryProvider;
  }

  public static MembersInjector<WorkflowApplication> create(
      Provider<DataStoreRepository> dataStoreRepositoryProvider) {
    return new WorkflowApplication_MembersInjector(dataStoreRepositoryProvider);
  }

  @Override
  public void injectMembers(WorkflowApplication instance) {
    injectDataStoreRepository(instance, dataStoreRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.workflow327.WorkflowApplication.dataStoreRepository")
  public static void injectDataStoreRepository(WorkflowApplication instance,
      DataStoreRepository dataStoreRepository) {
    instance.dataStoreRepository = dataStoreRepository;
  }
}
