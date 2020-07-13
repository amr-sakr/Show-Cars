package com.example.showcars.ui;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {


    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class CarsViewHolder extends RecyclerView.ViewHolder{

        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
