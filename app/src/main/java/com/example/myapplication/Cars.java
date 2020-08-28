package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.myapplication.Services.JsonservicesApi;
import com.example.myapplication.adapter.RetrofitCarsAdapter;
import com.example.myapplication.model.Autobots;
import com.example.myapplication.model.Autos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cars extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Autos> autitos;
    RetrofitCarsAdapter carsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView_cars);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://weedy-android.000webhostapp.com/ACH/prueba/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonservicesApi jsonservicesApi = retrofit.create(JsonservicesApi.class);

        Call<Autobots> call = jsonservicesApi.getCars();

        call.enqueue(new Callback<Autobots>() {
            @Override
            public void onResponse(Call<Autobots> call, Response<Autobots> response) {
                Log.e("CHILD", String.valueOf(response.body().getAutitos()));
                getResultados(response.body().getAutitos());

            }

            @Override
            public void onFailure(Call<Autobots> call, Throwable t) {
                Log.e("CHILD4", t.getMessage());
            }
        });
        //getResultados();
    }

    private void getResultados(ArrayList<Autos> autitos) {
        carsAdapter = new RetrofitCarsAdapter(getApplicationContext(), autitos);
        //  Log.e("CHILD", String.valueOf(response.body()));
        for (int i = 0; i < autitos.size(); i++) {
            Log.e("CHILD3", String.valueOf(autitos.get(i).getMarca()));
            carsAdapter.setDataCars(autitos);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(carsAdapter);

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }


    }
}