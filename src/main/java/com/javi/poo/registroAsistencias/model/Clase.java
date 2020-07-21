package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {

    private String nombreClase;

    private List<Alumno> listaAlumnos = new ArrayList();
    private List<Docente> listaDocente = new ArrayList();
    private List<Preceptor> listaPreceptor = new ArrayList<>();

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public List<Preceptor> getListaPreceptor() {
        return listaPreceptor;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
    
    
}
