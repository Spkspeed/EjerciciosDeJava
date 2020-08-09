package com.javi.poo.registroAsistencias.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

    protected String nombre;
    protected String apellido;
    private Integer edad;
    protected String nacionalidad;
    private String genero;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNacionalidad(String nacionalidad){ this.nacionalidad = nacionalidad; }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

}