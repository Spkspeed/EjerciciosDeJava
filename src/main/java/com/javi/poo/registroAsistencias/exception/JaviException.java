package com.javi.poo.registroAsistencias;

public class JaviException extends Exception{

    public JaviException(String mensaje){
        super("Error, " + mensaje);
    }
}
