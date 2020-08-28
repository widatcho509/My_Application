package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import  com.example.myapplication.model.Products;


import java.util.ArrayList;
import java.util.List;

public class AdapterArticulos extends RecyclerView.Adapter<AdapterArticulos.Holder>{
    Context context;
    List< Products> myList= new ArrayList<>();
    private int [] imgid;
    private OnItemClickListener myListener;
    public interface OnItemClickListener{
         void onItemClcick (int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        myListener=itemClickListener;
    }
    public AdapterArticulos(Context context, ArrayList<Products> myList,int [] imgid) {
        this.context = context;
        this.myList = myList;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list,parent,false);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = String.valueOf(myList.get(viewType));
                Toast.makeText(context, "you clicked :" +data, Toast.LENGTH_SHORT).show();
            }
        });
        return new Holder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Products hold=myList.get(position);
        holder.txtdescart.setText(hold.getDescart());
        holder.txtprecio.setText(hold.getPrecio());
        holder.img_prod.setImageResource(imgid[position]);



    }


    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView txtdescart;
        private TextView txtprecio;
       // private ImageView img_;
        private ImageView img_prod;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txtdescart=itemView.findViewById(R.id.txt_descart);
            txtprecio=itemView.findViewById(R.id.txt_precio);
            img_prod=itemView.findViewById(R.id.imgDescrip);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (myListener!=null){
                        int position=getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            myListener.onItemClcick(position);
                        }
                    }
                }
            });

        }
    }
}
