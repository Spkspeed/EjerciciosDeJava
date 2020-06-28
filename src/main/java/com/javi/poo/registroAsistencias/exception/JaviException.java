package com.javi.poo.registroAsistencias.exception;

public class JaviException extends Exception{

    public JaviException(String mensaje){
        super("Error, " + mensaje);
    }
}
