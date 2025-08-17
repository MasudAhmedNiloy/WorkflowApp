package com.workflow327.di;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Serializer;
import com.workflow327.AppLifecycleProvider;
import com.workflow327.WorkflowLifecycleProvider;
import com.workflow327.SettingsSerializer;
import com.workflow327.data.DataStoreRepository;
import com.workflow327.data.DefaultDataStoreRepository;
import com.workflow327.data.AuthRepository;
import com.workflow327.proto.Settings;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/workflow327/di/AppModule;", "", "()V", "provideAppLifecycleProvider", "Lcom/workflow327/AppLifecycleProvider;", "provideAuthRepository", "Lcom/workflow327/data/AuthRepository;", "context", "Landroid/content/Context;", "provideDataStoreRepository", "Lcom/workflow327/data/DataStoreRepository;", "dataStore", "Landroidx/datastore/core/DataStore;", "Lcom/workflow327/proto/Settings;", "provideSettingsDataStore", "settingsSerializer", "Landroidx/datastore/core/Serializer;", "provideSettingsSerializer", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.workflow327.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.Serializer<com.workflow327.proto.Settings> provideSettingsSerializer() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final androidx.datastore.core.DataStore<com.workflow327.proto.Settings> provideSettingsDataStore(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.datastore.core.Serializer<com.workflow327.proto.Settings> settingsSerializer) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.AppLifecycleProvider provideAppLifecycleProvider() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.DataStoreRepository provideDataStoreRepository(@org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<com.workflow327.proto.Settings> dataStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.workflow327.data.AuthRepository provideAuthRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}