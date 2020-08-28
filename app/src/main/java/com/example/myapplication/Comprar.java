package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.adapter.AdapterArticulos;
import com.example.myapplication.model.Products;

import java.util.ArrayList;

public class Comprar extends AppCompatActivity {
    ImageView imgCompra;
    RecyclerView myrecycleView;
    AdapterArticulos adapterArticulos;
    ArrayList<Products> list;
    private int [] images={R.drawable.mayo,R.drawable.tshirt,R.drawable.corsaj,R.drawable.tshirt,R.drawable.corsaj,R.drawable.mayo,R.drawable.tshirt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        myrecycleView=(RecyclerView) findViewById(R.id.recycleView_Lista);
       // imgCompra=(ImageView) findViewById(R.id.imgBuying);
        /*imgCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Comprar.this,CustomPopup.class);
                startActivity(intent);
            }
        });*/
        getResults();
    }

    private void getResults() {
        list=new ArrayList<>();
        list.add(new Products("Remera Negra Universal","$254.65","Male"));
        list.add(new Products("Remera Azul polyesther","$154.85","Male"));
        list.add(new Products("Remera Blanca Mujer","$224.65","Male"));
        list.add(new Products("Remera Azul polyesther","$154.85","Male"));
        list.add(new Products("Remera Blanca Mujer","$224.65","Male"));
        list.add(new Products("Remera Negra Universal","$254.65","Male"));
        list.add(new Products("Remera Azul polyesther","$154.85","Male"));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        myrecycleView.setLayoutManager(linearLayoutManager);
        adapterArticulos= new AdapterArticulos(this,list,images);
        myrecycleView.setAdapter(adapterArticulos);
        adapterArticulos.setOnItemClickListener(new AdapterArticulos.OnItemClickListener() {
            @Override
            public void onItemClcick(int position) {
                String nombre =list.get(position).getDescart();
                if (nombre.equals("Remera Negra Universal")){
                    Intent intent =new Intent(Comprar.this,CustomPopup.class);
                    startActivity(intent);
                }
                //Toast.makeText(Comprar.this, "you clicked"+list.get(position).getDescart(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}