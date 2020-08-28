package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.binding.Productos;

import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.ProductosHolder> {
    Context context;
    List<Productos> lista;

    public  void setListProducts(List<Productos> lista){
    this.lista=lista;
    notifyDataSetChanged();
    }
    public RetrofitAdapter(Context context, List<Productos> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ProductosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);

        return new ProductosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosHolder holder, int position) {
       Productos productos=lista.get(position);
       String id= productos.getNrocompro();
        String codigo =productos.getCodigo();
        String fecha= productos.getFecha();
        holder.txtId.setText(id);
        holder.txtCodigo.setText(codigo);
        holder.txtFecha.setText(fecha);
    }

    @Override
    public int getItemCount() {
        if (lista!=null){
            return lista.size();
        }
        return 0;
    }

    public class ProductosHolder extends RecyclerView.ViewHolder {
        TextView txtId;
        TextView txtCodigo;
        TextView txtFecha;
        public ProductosHolder(@NonNull View itemView) {
            super(itemView);
            txtId=itemView.findViewById(R.id.txtid);
            txtCodigo=itemView.findViewById(R.id.txtcodigo);
            txtFecha=itemView.findViewById(R.id.txtfecha);

        }
    }
}
