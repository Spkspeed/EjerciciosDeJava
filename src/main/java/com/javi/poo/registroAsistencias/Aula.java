package com.javi.poo.registroAsistencias;

import java.util.ArrayList;
import java.util.List;

public class  Aula {

    private List<Alumno> listaAlumnos = new ArrayList();

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
}
