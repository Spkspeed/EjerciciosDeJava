package com.javi.poo.registroAsistencias;

public class Docente extends Persona {

    public Docente() {
        super();
    }

    public Docente(String nombre, String apellido) throws JaviException { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);

        if (nombre.length() >= 10) {
                throw new JaviException("el nombre del docente supera los 10 caracteres permitidos");
        }

    }
}
