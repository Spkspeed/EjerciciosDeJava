package com.javi.poo.registroAsistencias;

public class Alumno extends Persona {

    protected Alumno(String nombre, String apellido) { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
    }

}
