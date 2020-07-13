package com.example.showcars.data

import androidx.lifecycle.LiveData
import com.example.showcars.ui.Result

interface CarsDataSource {

    fun observeCars(): LiveData<Result<List<Data>>>

    suspend fun getCars(): Result<List<Data>>
}