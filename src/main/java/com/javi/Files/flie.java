package com.javi.Files;
/*
clase abstracta, mezcla, archivos con fliereader.
 */
import com.javi.poo.registroAsistencias.exception.JaviException;
public class flie {
    public static void main(String args[]) throws JaviException{
        LectorDeFichero inicio = new LectorDeFichero();
        inicio.Leer("C:\\Users\\ADMIN\\Documents\\javaimport3\\EjerciciosDeJava\\src\\test\\resources\\ClasesModel.data");
    }
}