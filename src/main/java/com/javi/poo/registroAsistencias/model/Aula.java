package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;

public class Aula {

    private List<Alumno> listaAlumnos = new ArrayList();
    private List<Docente> listaDocente = new ArrayList();


    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public List<Docente> getListaDocente() {
        return listaDocente;
    }
}
