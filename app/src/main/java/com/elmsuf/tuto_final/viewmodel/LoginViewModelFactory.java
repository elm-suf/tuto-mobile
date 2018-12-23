package com.elmsuf.tuto_final.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.elmsuf.tuto_final.view.ResultLoginCallbacks;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private ResultLoginCallbacks callbacks;

    public LoginViewModelFactory(ResultLoginCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(callbacks);
    }
}
