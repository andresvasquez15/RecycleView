package com.example.nacin.prueba;

import java.security.PublicKey;

/**
 * Created by NACIÓN on 13/06/2017.
 */

public class Datos {

    String Datos_imagen, Datos_id;

    public Datos(){

    }

    public Datos(String datos_imagen, String datos_id) {
        Datos_imagen = datos_imagen;
        Datos_id = datos_id;
    }

    public String getDatos_imagen() {
        return Datos_imagen;
    }

    public void setDatos_imagen(String datos_imagen) {
        Datos_imagen = datos_imagen;
    }

    public String getDatos_id() {
        return Datos_id;
    }

    public void setDatos_id(String datos_id) {
        Datos_id = datos_id;
    }
}
