package com.example.showcars.ui;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.showcars.CarsRepository;
import com.example.showcars.data.Data;
import com.example.showcars.data.CarsResponse;

import java.util.List;

public class MainViewModel extends ViewModel {

    ApiStatus apiStatus;
    private CarsRepository repository;
    private MutableLiveData<List<Data>> carsList;

    public MainViewModel(CarsRepository repository, ApiStatus apiStatus) {
        this.repository = repository;
        this.apiStatus = apiStatus;
    }

    public void setPage(int page) {
        getCars(page);
    }

    @SuppressLint("LogNotTimber")
    public void getCars(int page) {
//        apiStatus.isLoading();
        if (page > 0) {
//            MutableLiveData<CarsResponse> response = repository.getCars(page);
            carsList = repository.getCars(page);
//                carsList.setValue(response.getValue().getData());
        }
    }


    public LiveData<List<Data>> getCarsData() {
        return carsList;
    }


}
