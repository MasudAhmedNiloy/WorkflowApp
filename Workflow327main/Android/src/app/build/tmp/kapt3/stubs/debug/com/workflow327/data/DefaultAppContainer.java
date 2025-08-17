package com.workflow327.data;

import android.content.Context;
import androidx.datastore.core.DataStore;
import com.workflow327.AppLifecycleProvider;
import com.workflow327.WorkflowLifecycleProvider;
import com.workflow327.proto.Settings;

/**
 * Default implementation of the AppContainer interface.
 *
 * This class provides concrete implementations for the application's dependencies,
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/workflow327/data/DefaultAppContainer;", "Lcom/workflow327/data/AppContainer;", "ctx", "Landroid/content/Context;", "dataStore", "Landroidx/datastore/core/DataStore;", "Lcom/workflow327/proto/Settings;", "(Landroid/content/Context;Landroidx/datastore/core/DataStore;)V", "context", "getContext", "()Landroid/content/Context;", "dataStoreRepository", "Lcom/workflow327/data/DefaultDataStoreRepository;", "getDataStoreRepository", "()Lcom/workflow327/data/DefaultDataStoreRepository;", "lifecycleProvider", "Lcom/workflow327/WorkflowLifecycleProvider;", "getLifecycleProvider", "()Lcom/workflow327/WorkflowLifecycleProvider;", "app_debug"})
public final class DefaultAppContainer implements com.workflow327.data.AppContainer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.WorkflowLifecycleProvider lifecycleProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.DefaultDataStoreRepository dataStoreRepository = null;
    
    public DefaultAppContainer(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<com.workflow327.proto.Settings> dataStore) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.content.Context getContext() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.WorkflowLifecycleProvider getLifecycleProvider() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.data.DefaultDataStoreRepository getDataStoreRepository() {
        return null;
    }
}