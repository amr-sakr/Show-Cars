package com.example.showcars.data

import androidx.lifecycle.MutableLiveData
import com.example.showcars.networking.SafeApiRequest
import com.example.showcars.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//TODO change later to use paging library
class CarsRepository(private val webService: WebService) : SafeApiRequest() {

    private val cars = MutableLiveData<List<Data>>()


    suspend fun getCars(page: Int): MutableLiveData<List<Data>>{
        val response = apiRequest { webService.getCars(page) }
        cars.value = response.data
        cars.postValue(cars.value)
        return withContext(Dispatchers.IO){
            cars
        }
    }
}