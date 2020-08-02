package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {

    private Preceptor preceptor;
    private String nombreClase;

    // Cuando creamos un constructor customizado desactivamos el constructor default asi que debemos declararlo explicitemente
    public Clase(Preceptor preceptor, String nombreClase){
        this.preceptor = preceptor;
        this.nombreClase = nombreClase;
    }

    public Clase() {}

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