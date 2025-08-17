package com.workflow327.data;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.workflow327.AppLifecycleProvider;
import com.workflow327.WorkflowLifecycleProvider;
import com.workflow327.proto.Settings;

/**
 * App container for Dependency injection.
 *
 * This interface defines the dependencies required by the application.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2 = {"Lcom/workflow327/data/AppContainer;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataStoreRepository", "Lcom/workflow327/data/DataStoreRepository;", "getDataStoreRepository", "()Lcom/workflow327/data/DataStoreRepository;", "lifecycleProvider", "Lcom/workflow327/AppLifecycleProvider;", "getLifecycleProvider", "()Lcom/workflow327/AppLifecycleProvider;", "app_debug"})
public abstract interface AppContainer {
    
    @org.jetbrains.annotations.NotNull()
    public abstract android.content.Context getContext();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.workflow327.AppLifecycleProvider getLifecycleProvider();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.workflow327.data.DataStoreRepository getDataStoreRepository();
}