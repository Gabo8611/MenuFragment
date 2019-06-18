package org.courcera.reciclerview.pojo;

import android.content.Intent;

/**
 * Created by Usuario on 04/06/2016.
 */
public class Mascota {
    private int id;
    private String nombre;
    private int puntuacion;
    private int foto;

    public Mascota(){}


    public Mascota( String nombre, int puntuacion, int foto){

        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.foto = foto;
    }

    public Mascota(int id, String nombre, int puntuacion, int foto){
        this.id = id;
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
