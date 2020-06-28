package com.javi.poo.registroAsistencias;

public class JaviExcepcion extends Exception{

    public JaviExcepcion(String mensaje){
        super("Error el nombre del alumno o docente supera los 10 caracteres permitodos" + mensaje);

    }
}
