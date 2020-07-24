package com.javi.poo.registroAsistencias.model;

import com.javi.poo.registroAsistencias.exception.JaviException;
import java.util.List;

public class Alumno extends Persona {

    public Alumno() {}

    // Los constructores siempre deben ser publicos
    // Salvo que quieras implementar un patron de diseño que seria un SINGLETON
    public Alumno(String nombre, String apellido, String nacionalidad) throws JaviException { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);


        if (nombre.length() >= 10){
                throw new JaviException("el nombre del alumno supera los 10 caracteres permitidos");
        }
    }
}