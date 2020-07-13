package com.example.showcars.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.showcars.data.CarsRepository
import com.example.showcars.data.Data
import androidx.lifecycle.viewModelScope
import com.example.showcars.util.ApiException
import com.example.showcars.util.NoInternetException
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class CarsViewModel(private val repository: CarsRepository) : ViewModel() {


    private val _cars = MutableLiveData<List<Data>>()
    val cars: LiveData<List<Data>>
    get() = _cars


    fun setPage(page: Int) {
        getCars(page)
    }




    private fun getCars(page: Int) {

        try {
            viewModelScope.launch {
                if (page > 0) {
                    val response = repository.getCars(page)
                    _cars.value = response.value
                    Timber.d(("Data ${_cars.value}"))
                }
            }

        } catch (e: ApiException) {
            Timber.d("Exception ${e.message.toString()}")
        } catch (e: NoInternetException) {
            Timber.d("Exception ${e.message.toString()}")

        } catch (e: Exception) {
            Timber.d("Exception ${e.message.toString()}")
        }
    }

}
