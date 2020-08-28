package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Services.JsonservicesApi;
import com.example.myapplication.adapter.RetrofitAdapter;
import com.example.myapplication.binding.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Provider extends AppCompatActivity {
    RecyclerView txtresultado;
    RetrofitAdapter retrofitAdapter;
    List<Productos> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        txtresultado = (RecyclerView) findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        txtresultado.setLayoutManager(layoutManager);
        retrofitAdapter = new RetrofitAdapter(getApplicationContext(), productos);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://weedy-android.000webhostapp.com/ips/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonservicesApi jsonservicesApi = retrofit.create(JsonservicesApi.class);
        Call<List<Productos>> call = jsonservicesApi.getProdustos();
        call.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                if (!response.isSuccessful()) {
                    //  txtresultado.setText("code " + response.code());
                    return;
                }
                List<Productos> lista = response.body();
                Log.e("RESULT", String.valueOf(lista));
                retrofitAdapter.setListProducts(lista);
                txtresultado.setAdapter(retrofitAdapter);

            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {
                //txtresultado.setText(t.getMessage());
            }
        });
        // getResponse();
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