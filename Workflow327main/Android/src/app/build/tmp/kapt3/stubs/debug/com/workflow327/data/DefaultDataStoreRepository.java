package com.workflow327.data;

import androidx.datastore.core.DataStore;
import com.workflow327.proto.AccessTokenData;
import com.workflow327.proto.ImportedModel;
import com.workflow327.proto.Settings;
import com.workflow327.proto.Theme;

/**
 * Repository for managing data using Proto DataStore.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0016\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/workflow327/data/DefaultDataStoreRepository;", "Lcom/workflow327/data/DataStoreRepository;", "dataStore", "Landroidx/datastore/core/DataStore;", "Lcom/workflow327/proto/Settings;", "(Landroidx/datastore/core/DataStore;)V", "acceptTos", "", "clearAccessTokenData", "isTosAccepted", "", "readAccessTokenData", "Lcom/workflow327/proto/AccessTokenData;", "readImportedModels", "", "Lcom/workflow327/proto/ImportedModel;", "readTextInputHistory", "", "readTheme", "Lcom/workflow327/proto/Theme;", "saveAccessTokenData", "accessToken", "refreshToken", "expiresAt", "", "saveImportedModels", "importedModels", "saveTextInputHistory", "history", "saveTheme", "theme", "app_debug"})
public final class DefaultDataStoreRepository implements com.workflow327.data.DataStoreRepository {
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.core.DataStore<com.workflow327.proto.Settings> dataStore = null;
    
    public DefaultDataStoreRepository(@org.jetbrains.annotations.NotNull()
    androidx.datastore.core.DataStore<com.workflow327.proto.Settings> dataStore) {
        super();
    }
    
    @java.lang.Override()
    public void saveTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> history) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> readTextInputHistory() {
        return null;
    }
    
    @java.lang.Override()
    public void saveTheme(@org.jetbrains.annotations.NotNull()
    com.workflow327.proto.Theme theme) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.workflow327.proto.Theme readTheme() {
        return null;
    }
    
    @java.lang.Override()
    public void saveAccessTokenData(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, long expiresAt) {
    }
    
    @java.lang.Override()
    public void clearAccessTokenData() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.workflow327.proto.AccessTokenData readAccessTokenData() {
        return null;
    }
    
    @java.lang.Override()
    public void saveImportedModels(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.proto.ImportedModel> importedModels) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.workflow327.proto.ImportedModel> readImportedModels() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isTosAccepted() {
        return false;
    }
    
    @java.lang.Override()
    public void acceptTos() {
    }
}