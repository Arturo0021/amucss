package com.amucss.mx.amucss.entities;

/**
 * Created by Arturo Sg on 24/04/2018.
 */

public class Registro {

    public Integer Id;
    public String Nombre;
    public String Apat;
    public String Amat;
    public Integer Sexo;
    public String Telefono;
    public Integer Edad;
    public String Email;
    public Integer Socio;
    public String Clave;

    public Registro() {

    }

    public Registro(Integer id, String nombre, String apat, String amat, Integer sexo, String telefono, Integer edad, String email, Integer socio, String clave) {
        Id = id;
        Nombre = nombre;
        Apat = apat;
        Amat = amat;
        Sexo = sexo;
        Telefono = telefono;
        Edad = edad;
        Email = email;
        Socio = socio;
        Clave = clave;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApat() {
        return Apat;
    }

    public void setApat(String apat) {
        Apat = apat;
    }

    public String getAmat() {
        return Amat;
    }

    public void setAmat(String amat) {
        Amat = amat;
    }

    public Integer getSexo() {
        return Sexo;
    }

    public void setSexo(Integer sexo) {
        Sexo = sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getSocio() {
        return Socio;
    }

    public void setSocio(Integer socio) {
        Socio = socio;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}
