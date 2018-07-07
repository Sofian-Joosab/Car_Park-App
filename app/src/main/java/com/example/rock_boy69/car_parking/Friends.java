package com.example.rock_boy69.car_parking;

/**
 * Created by Rock_boy69 on 15-Nov-17.
 */

public class Friends {
    public String id;
    public String hora;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String local;
    public String lugar;

    public Friends(){

    }

    public Friends(String id, String hora, String local, String lugar) {
        this.id = id;
        this.hora = hora;
        this.local = local;
        this.lugar = lugar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

