package com.workflow327.ui.common;

import net.openid.appauth.AuthorizationServiceConfiguration;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/workflow327/ui/common/AuthConfig;", "", "()V", "authEndpoint", "", "authServiceConfig", "Lnet/openid/appauth/AuthorizationServiceConfiguration;", "getAuthServiceConfig", "()Lnet/openid/appauth/AuthorizationServiceConfiguration;", "clientId", "getClientId", "()Ljava/lang/String;", "googleClientId", "huggingFaceAuthServiceConfig", "getHuggingFaceAuthServiceConfig", "huggingFaceClientId", "huggingFaceRedirectUri", "redirectUri", "getRedirectUri", "tokenEndpoint", "app_debug"})
public final class AuthConfig {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String googleClientId = "185268756345-i15lgqd3dclckev7somsf0pj6pjcg8bh.apps.googleusercontent.com";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String huggingFaceClientId = "workflow327";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String huggingFaceRedirectUri = "com.workflow327://oauth/huggingface";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String authEndpoint = "https://huggingface.co/oauth/authorize";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String tokenEndpoint = "https://huggingface.co/oauth/token";
    @org.jetbrains.annotations.NotNull()
    private static final net.openid.appauth.AuthorizationServiceConfiguration huggingFaceAuthServiceConfig = null;
    @org.jetbrains.annotations.NotNull()
    private static final net.openid.appauth.AuthorizationServiceConfiguration authServiceConfig = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String clientId = "workflow327";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String redirectUri = "com.workflow327://oauth/huggingface";
    @org.jetbrains.annotations.NotNull()
    public static final com.workflow327.ui.common.AuthConfig INSTANCE = null;
    
    private AuthConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.openid.appauth.AuthorizationServiceConfiguration getHuggingFaceAuthServiceConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final net.openid.appauth.AuthorizationServiceConfiguration getAuthServiceConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRedirectUri() {
        return null;
    }
}