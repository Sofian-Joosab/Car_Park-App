package com.example.rock_boy69.car_parking;

/**
 * Created by Rock_boy69 on 08-Nov-17.
 */

public class Users {

    public String id;
    public String hora;

    public Users(){

    }

    public Users(String id, String hora) {
        this.id = id;
        this.hora = hora;
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
