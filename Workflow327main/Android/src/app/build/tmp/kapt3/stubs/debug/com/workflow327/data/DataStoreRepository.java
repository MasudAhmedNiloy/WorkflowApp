package com.workflow327.data;

import androidx.datastore.core.DataStore;
import com.workflow327.proto.AccessTokenData;
import com.workflow327.proto.ImportedModel;
import com.workflow327.proto.Settings;
import com.workflow327.proto.Theme;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH&J\b\u0010\u000e\u001a\u00020\u000fH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\nH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000fH&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001b\u00c0\u0006\u0001"}, d2 = {"Lcom/workflow327/data/DataStoreRepository;", "", "acceptTos", "", "clearAccessTokenData", "isTosAccepted", "", "readAccessTokenData", "Lcom/workflow327/proto/AccessTokenData;", "readImportedModels", "", "Lcom/workflow327/proto/ImportedModel;", "readTextInputHistory", "", "readTheme", "Lcom/workflow327/proto/Theme;", "saveAccessTokenData", "accessToken", "refreshToken", "expiresAt", "", "saveImportedModels", "importedModels", "saveTextInputHistory", "history", "saveTheme", "theme", "app_debug"})
public abstract interface DataStoreRepository {
    
    public abstract void saveTextInputHistory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> history);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> readTextInputHistory();
    
    public abstract void saveTheme(@org.jetbrains.annotations.NotNull()
    com.workflow327.proto.Theme theme);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.workflow327.proto.Theme readTheme();
    
    public abstract void saveAccessTokenData(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken, long expiresAt);
    
    public abstract void clearAccessTokenData();
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.workflow327.proto.AccessTokenData readAccessTokenData();
    
    public abstract void saveImportedModels(@org.jetbrains.annotations.NotNull()
    java.util.List<com.workflow327.proto.ImportedModel> importedModels);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.workflow327.proto.ImportedModel> readImportedModels();
    
    public abstract boolean isTosAccepted();
    
    public abstract void acceptTos();
}