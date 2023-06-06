package com.vaibhavmojidra.androidjavademo2roomdatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    private EmployeeRepository repository;

    public MainActivityViewModelFactory(EmployeeRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainActivityViewModel.class)){
            return (T) new MainActivityViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
