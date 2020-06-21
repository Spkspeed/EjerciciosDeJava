package com.javi.poo.registroAsistencias;

public class Docente extends Persona {

    public Docente(String nombre, String apellido) { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
    }
}
