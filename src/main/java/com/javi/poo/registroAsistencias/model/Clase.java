package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {

    private Preceptor preceptor;
    private String nombreClase;
    private List<Alumno> listaAlumnos = new ArrayList();
    private List<Docente> listaDocente = new ArrayList();

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public Preceptor getPreceptor() {
        return preceptor;
    }

    public void setPreceptor(Preceptor preceptor) {
        this.preceptor = preceptor;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
}