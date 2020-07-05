package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {

    private String nombreClase;

    private List<Alumno> listaAlumnos = new ArrayList();
    private List<Docente> listaDocente = new ArrayList();
    private List<Preceptor> listPreceptor = new ArrayList<>();

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public List<Preceptor> getListPreceptor() {
        return listPreceptor;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
}
