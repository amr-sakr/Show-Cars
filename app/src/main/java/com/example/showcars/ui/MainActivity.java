package com.example.showcars.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.showcars.CarsRepository;
import com.example.showcars.databinding.ActivityMainBinding;
import com.example.showcars.util.NetworkHelper;

public class MainActivity extends AppCompatActivity implements ApiStatus {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        CarsRepository repository = new CarsRepository();
        MainViewModelFactory factory = new MainViewModelFactory(repository, this);
        viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        observeCars(1);
    }


    private void observeCars(int page) {
        if (NetworkHelper.hasNetworkAccess(this)) {

            viewModel.getCars(page).observe(this, cars -> {
                if (cars != null) {
                    Log.d("MainActivity", "Getting List " + cars.toString());
                    Toast.makeText(this, "ss" + cars.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void isLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void success() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void failed(String message) {
        binding.progressBar.setVisibility(View.GONE);
        Toast.makeText(this,message , Toast.LENGTH_SHORT).show();
    }
}