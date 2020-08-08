package com.javi.poo.registroAsistencias.model;

public class Preceptor extends Persona {
    public Preceptor(String nombre, String apellido, String nacionalidad) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);
    }

    public Preceptor(String clase, String nombre, String apellido, String nacionalidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
