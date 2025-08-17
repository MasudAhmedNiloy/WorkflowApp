package com.workflow327;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/workflow327/WorkflowLifecycleProvider;", "Lcom/workflow327/AppLifecycleProvider;", "()V", "_isAppInForeground", "", "value", "isAppInForeground", "()Z", "setAppInForeground", "(Z)V", "app_debug"})
public final class WorkflowLifecycleProvider implements com.workflow327.AppLifecycleProvider {
    private boolean _isAppInForeground = false;
    
    public WorkflowLifecycleProvider() {
        super();
    }
    
    @java.lang.Override()
    public boolean isAppInForeground() {
        return false;
    }
    
    @java.lang.Override()
    public void setAppInForeground(boolean value) {
    }
}