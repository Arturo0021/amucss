package com.amucss.mx.amucss.entities;

/**
 * Created by Arturo Sg on 25/04/2018.
 */

public class Tiempos {

    public Integer Id;
    public String Clave;
    public String Fecha;
    public String Pantalla;

    public Tiempos() {

    }

    public Tiempos(Integer id, String clave, String fecha, String pantalla) {
        Id = id;
        Clave = clave;
        Fecha = fecha;
        Pantalla = pantalla;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getPantalla() {
        return Pantalla;
    }

    public void setPantalla(String pantalla) {
        Pantalla = pantalla;
    }
}
