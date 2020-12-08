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


    //    public MovilModels() {
//
//    }


//    public String getFbid() {
//        return fbid;
//    }
//
//    public void setFbid(String fbid) {
//        this.fbid = fbid;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getSerial() {
//        return serial;
//    }
//
//    public void setSerial(String serial) {
//        this.serial = serial;
//    }
//
//    public String getDescripcion() {
//        return this.descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }



//    public MovilModels(String id, String serial, String descripcion, String brand, String imageUrl, String fbid, boolean active) {
//        this.id = id;
//        this.serial = serial;
//        this.descripcion = descripcion;
//        this.brand = brand;
//        this.imageUrl = imageUrl;
//        this.fbid = fbid;
//        this.active = active;
//    }
//
//    @Override
//    public String toString() {
//        return "MovilModels{" +
//                "id='" + id + '\'' +
//                ", serial='" + serial + '\'' +
//                ", descripcion='" + descripcion + '\'' +
//                ", brand='" + brand + '\'' +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", fbid='" + fbid + '\'' +
//                ", active=" + active +
//                '}';
//    }
}
