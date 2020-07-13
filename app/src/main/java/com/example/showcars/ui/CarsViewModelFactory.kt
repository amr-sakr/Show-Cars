package com.example.showcars.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.showcars.data.CarsRepository

@Suppress("UNCHECKED_CAST")
class CarsViewModelFactory(private val repository: CarsRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CarsViewModel(repository ) as T
    }
}