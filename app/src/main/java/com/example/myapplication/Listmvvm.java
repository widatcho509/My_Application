package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.AdapterList;
import com.example.myapplication.model.Lista;

import java.util.ArrayList;

public class Listmvvm extends AppCompatActivity {
    ArrayList<Lista> arrayList=new ArrayList<>();
    AdapterList adapter;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmvvm);
        recyclerView=(RecyclerView) findViewById(R.id.list_recycle);
        getInformation();
    }

    private void getInformation() {
        arrayList.add(new Lista("Primero","1","Esto es la primera descripcion de mi listas"));
        arrayList.add(new Lista("Segundo","5","This is my second description in my list"));
        arrayList.add(new Lista("Tercero","6","Now , im going to try to rotating the screen "));
        arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));
        arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));
        arrayList.add(new Lista("Tercero","6","Now , im going to try to rotating the screen "));
        arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));
        arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));
        arrayList.add(new Lista("Tercero","6","Now , im going to try to rotating the screen "));
        arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));
        arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));arrayList.add(new Lista("Cuarto","3","je n'ai plus rien a dire jajajs"));


        adapter=new AdapterList(getApplicationContext(),arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}