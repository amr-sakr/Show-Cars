package com.example.showcars.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.showcars.CarsRepository;

class MainViewModelFactory implements ViewModelProvider.Factory {

    private ApiStatus apiStatus;
    private CarsRepository repository;

    public MainViewModelFactory(CarsRepository repository, ApiStatus apiStatus) {
        this.repository = repository;
        this.apiStatus = apiStatus;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repository, apiStatus);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
