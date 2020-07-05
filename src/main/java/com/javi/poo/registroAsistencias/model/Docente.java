package com.javi.poo.registroAsistencias.model;

import com.javi.poo.registroAsistencias.exception.JaviException;

public class Docente extends Persona {

    public Docente(String nombre, String apellido, String nacionalidad) throws JaviException { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);


        if (nombre.length() >= 10) {
                throw new JaviException("el nombre del docente supera los 10 caracteres permitidos");
        }

    }
}
