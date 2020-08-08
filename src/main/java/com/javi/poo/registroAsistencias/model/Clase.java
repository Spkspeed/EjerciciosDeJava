package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {

    private Preceptor preceptor;

    private String nombreClase;

    // Cuando creamos un constructor customizado desactivamos el constructor default asi que debemos declararlo explicitemente
    public Clase(String nombreClase){
        this.nombreClase = nombreClase;
    }
    // el codigo ya existe de antemano sin verse pero al crear el constructor es necesaria instanciarla de nuevo.
    public Clase() {}

    private List<Alumno> listaAlumnos = new ArrayList();
    private List<Docente> listaDocente = new ArrayList();

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
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