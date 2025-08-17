package com.workflow327.ui.common.tos;

import androidx.lifecycle.ViewModel;
import com.workflow327.data.DataStoreRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

/**
 * ViewModel responsible for managing terms of services related tasks.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/workflow327/ui/common/tos/TosViewModel;", "Landroidx/lifecycle/ViewModel;", "dataStoreRepository", "Lcom/workflow327/data/DataStoreRepository;", "(Lcom/workflow327/data/DataStoreRepository;)V", "acceptTos", "", "getIsTosAccepted", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public class TosViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.workflow327.data.DataStoreRepository dataStoreRepository = null;
    
    @javax.inject.Inject()
    public TosViewModel(@org.jetbrains.annotations.NotNull()
    com.workflow327.data.DataStoreRepository dataStoreRepository) {
        super();
    }
    
    public final boolean getIsTosAccepted() {
        return false;
    }
    
    public final void acceptTos() {
    }
}