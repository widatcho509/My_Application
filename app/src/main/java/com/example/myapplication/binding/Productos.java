package com.example.myapplication.binding;

public class Productos {
    public String nrocompro;
    public String codigo;
    public String fecha;
    public float pendiente;

    public Productos(String rnocompro, String codigo, String fecha, float pendiente) {
        this.nrocompro = rnocompro;
        this.codigo = codigo;
        this.fecha = fecha;
        this.pendiente = pendiente;
    }

    public String getNrocompro() {
        return nrocompro;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public float getPendiente() {
        return pendiente;
    }
}
