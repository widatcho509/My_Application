package com.example.myapplication.model;

import com.example.myapplication.Cars;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Autobots {

@SerializedName("Cars")
@Expose
    private ArrayList<Autos> cars;

    public ArrayList<Autos> getAutitos() {
        return cars;
    }



    public Autobots(ArrayList<Autos> autitos) {
        this.cars = autitos;
    }

    @Override
    public String toString() {
        return "Autobots{" +
                "autitos=" + cars +
                '}';
    }
}
