package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.Autobots;
import com.example.myapplication.model.Autos;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static android.content.ContentValues.TAG;

public class RetrofitCarsAdapter extends RecyclerView.Adapter<RetrofitCarsAdapter.CarsHolder> {
    Context context;
    ArrayList<Autos> cars;

    public RetrofitCarsAdapter(Context context, ArrayList<Autos> cars) {
        this.context = context;
        this.cars = cars;
    }
    @SerializedName("Cars")
    @Expose
    private JsonElement results;
    public void setDataCars(ArrayList<Autos> cars){
        this.cars=cars;
        notifyDataSetChanged();

    }
    public JsonElement getResults() {
        return results;
    }

    @NonNull
    @Override
    public CarsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.items_cars,parent,false);

        return new CarsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsHolder holder, int position) {
        Autos autosList= cars.get(position);
        Log.e("CHILD2", String.valueOf(autosList));
        String codigo=autosList.getCodigo();
        String marca=autosList.getMarca();
        String modelo=autosList.getModelo();
        String picture=autosList.getPicture();
        int precio =0;
        String price=autosList.getPrecio();
        Log.e("CHILD2", price);
        precio=Integer.parseInt(price);

      //  int precio =Integer.getInteger(String.valueOf(autosList.getPrecio()));
        holder.txtCodiart.setText(codigo);
        holder.txtMarca.setText(marca);
        holder.txtModelo.setText(modelo);
       holder.txtPrecio.setText("$"+precio);
        if (picture.equals("")){
            holder.imageView.setImageResource(R.drawable.no_camera);
        }else{
            Glide.with(context).load(picture).apply(RequestOptions.circleCropTransform()).into(holder.imageView);
        }

      //  holder.txtPrecio.setText(precio);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: clicked on: " + cars.get(position).getMarca());
               // Toast.makeText(context,   cars.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class CarsHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtMarca;
        public TextView txtModelo;
        public TextView txtPrecio;
        public TextView txtCodiart;
        RelativeLayout parentLayout;

        public CarsHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout=itemView.findViewById(R.id.relative);
            imageView=itemView.findViewById(R.id.image_cars);
            txtMarca=itemView.findViewById(R.id.txtMarca);
            txtModelo=itemView.findViewById(R.id.txtModelo);
            txtPrecio=itemView.findViewById(R.id.txtPrecio);
            txtCodiart=itemView.findViewById(R.id.txtCodiart);
        }
    }
}
