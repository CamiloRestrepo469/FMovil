package com.example.fmovil.models;

import com.example.fmovil.EditarActivity;

import java.io.Serializable;

public class MovilModels implements Serializable {
    private String id;
    private String consecutivo;
    private String concepto;
    private String marca;
    private String imagenes;
    private String firebaseid;
    private boolean active;

    public MovilModels(String id, String consecutivo, String concepto, String marca, String imagenes, String firebaseid, boolean active) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.concepto = concepto;
        this.marca = marca;
        this.imagenes = imagenes;
        this.firebaseid = firebaseid;
        this.active = active;
    }

    public MovilModels() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getFirebaseid() {
        return firebaseid;
    }

    public void setFirebaseid(String firebaseid) {
        this.firebaseid = firebaseid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "MovilModels{" +
                "id='" + id + '\'' +
                ", consecutivo='" + consecutivo + '\'' +
                ", concepto='" + concepto + '\'' +
                ", marca='" + marca + '\'' +
                ", imagenes='" + imagenes + '\'' +
                ", firebaseid='" + firebaseid + '\'' +
                ", active=" + active +
                '}';
    }



}
