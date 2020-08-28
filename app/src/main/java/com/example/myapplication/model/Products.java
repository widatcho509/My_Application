package com.example.myapplication.model;

public class Products {
    public String descart;
    public String precio;
    public String image;
    public String gender;

    public Products(String descart, String precio,String gender) {
        this.descart = descart;
        this.precio = precio;
        this.image = image;
        this.gender = gender;
    }

    public String getDescart() {
        return descart;
    }

    public void setDescart(String descart) {
        this.descart = descart;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
