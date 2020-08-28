package com.example.myapplication.Services;

import com.example.myapplication.model.Autobots;
import com.example.myapplication.model.Autos;
import com.example.myapplication.binding.Productos;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonservicesApi {
    @GET("kilombo.php")
    Call<List<Productos>> getProdustos();

    @SerializedName("Cars")
    @GET("cars.php")
    Call<Autobots> getCars();

}

