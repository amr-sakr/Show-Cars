package com.example.showcars.data

import androidx.lifecycle.MutableLiveData
import com.example.showcars.networking.SafeApiRequest
import com.example.showcars.networking.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//TODO change later to use paging library
class CarsRepository(private val webService: WebService) : SafeApiRequest() {

    private val carsResponse = MutableLiveData<CarsResponse>()


    suspend fun getCars(page: Int): MutableLiveData<CarsResponse>{
        val response = apiRequest { webService.getCars(page) }
        carsResponse.value = response
        carsResponse.postValue(carsResponse.value)
        return withContext(Dispatchers.IO){
            carsResponse
        }
    }
}