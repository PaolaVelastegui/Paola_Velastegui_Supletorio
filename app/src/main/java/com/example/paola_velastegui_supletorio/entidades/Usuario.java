package com.example.paola_velastegui_supletorio.entidades;

public class Usuario {
    private int id;
    private String cedula;
    private String clave;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() { return cedula;  }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String email) {
        this.clave = clave;
    }
}
