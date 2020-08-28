package com.example.myapplication.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Autos  {

    @SerializedName("marca")
    @Expose
    public String marca;

    @SerializedName("modelo")
    @Expose
    public String modelo;

    @SerializedName("codigo")
    @Expose
    public String codigo;

    @SerializedName("precio")
    @Expose
    public String precio;

    @SerializedName("picture")
    public String picture;

    public Autos(String marca, String modelo, String codigo, String precio, String picture) {
        this.marca = marca;
        this.modelo = modelo;
        this.codigo = codigo;
        this.precio = precio;
        this.picture = picture;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String model) {
        this.modelo = model;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNrocompro(String nrocompro) {
        this.codigo = nrocompro;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
