package com.example.showcars.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.showcars.data.CarsRepository
import com.example.showcars.databinding.ActivityMainBinding
import com.example.showcars.networking.NetworkConnectionInterceptor
import com.example.showcars.networking.WebService
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: CarsViewModel
    private lateinit var carsListAdapter: CarsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val webService = WebService.invoke(networkConnectionInterceptor)
        val repository = CarsRepository(webService)
        val factory = CarsViewModelFactory(repository)
        bindView()
        viewModel = ViewModelProvider(this, factory).get(CarsViewModel::class.java)
        viewModel.setPage(1)
        observeCars()


    }


    private fun observeCars() {
        viewModel.cars.observe(this, Observer {
            if (it != null) {
                Timber.d("List = ${it.toString()}")
                carsListAdapter.submitList(it)
            } else {
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun bindView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            carsListAdapter = CarsListAdapter()
            adapter = carsListAdapter
        }
    }


}