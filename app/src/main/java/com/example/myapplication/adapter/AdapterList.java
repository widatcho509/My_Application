package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Lista;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.Holder> {
    List<Lista> list=new ArrayList<>();
    Context context;

    public AdapterList(Context context, ArrayList<Lista> arrayList) {
        this.context=context;
        this.list=arrayList;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new Holder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
    Lista hold= list.get(position);
    holder.title.setText(hold.getTitle());
    holder.cantidad.setText(hold.getCantidad());
    holder.descrip.setText(hold.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setLista(List<Lista> listas){
    this.list=listas;
    notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView cantidad;
        public TextView descrip;

        public Holder(@NonNull View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.txtTitle);
            cantidad=(TextView) itemView.findViewById(R.id.txtCantidad);
            descrip=(TextView) itemView.findViewById(R.id.txtDescription);
        }
    }
}
