package com.example.myapplication.model;

public class Lista {
    public String title;
    public String cantidad;
    public String description;

    public Lista(String title, String cantidad, String description) {
        this.title = title;
        this.cantidad = cantidad;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
