package com.javi.poo.registroAsistencias.model;

import com.javi.poo.registroAsistencias.exception.JaviException;

public class Alumno extends Persona {

    private String nombreClase;
    public Alumno() {}

    // Los constructores siempre deben ser publicos
    // Salvo que quieras implementar un patron de diseño que seria un SINGLETON
    public Alumno(String clase, String nombre, String apellido, String nacionalidad, Integer edad) throws JaviException { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);
        this.setEdad(edad);

        if (nombre.length() >= 10){
                throw new JaviException("el nombre del alumno supera los 10 caracteres permitidos");
        }
    }

    public void setNombreClase(String nombreClase){ this.nombreClase = nombreClase;}
    public String getNombreClase(){ return nombreClase;}
}