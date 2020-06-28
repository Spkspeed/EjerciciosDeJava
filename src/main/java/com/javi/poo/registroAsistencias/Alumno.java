package com.javi.poo.registroAsistencias;

public class Alumno extends Persona {

    // Los constructores siempre deben ser publicos
    // Salvo que quieras implementar un patron de diseño que seria un SINGLETON
    public Alumno(String nombre, String apellido) throws JaviExcepcion { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);


        if (nombre.length() >= 10){
            try {
                throw new JaviExcepcion("Error en el nombre del alumno o docente supera los 10 caracteres permitodos");
            }catch (Exception e){
                System.out.println("Error en el nombre " + e);
            }
        }
    }

}
