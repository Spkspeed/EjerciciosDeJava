package com.javi.poo.registroAsistencias.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombreClase;

    @Transient
    private Preceptor preceptor;

    @OneToMany(mappedBy = "clase")
    private List<Alumno> listaAlumnosExcelentes;

    @Transient
    private List<Alumno> listaAlumnos;

    @Transient
    private List<Docente> listaDocente;

    // Cuando creamos un constructor customizado desactivamos el constructor default asi que debemos declararlo explicitemente
    public Clase(String nombreClase){
        this.nombreClase = nombreClase;
    }

    // el codigo ya existe de antemano sin verse pero al crear el constructor es necesaria instanciarla de nuevo.
    public Clase() {}

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setListaDocente(List<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }

    public List<Alumno> getListaAlumnosExcelentes() {
        return listaAlumnosExcelentes;
    }

    public void setListaAlumnosExcelentes(List<Alumno> listaAlumnosExcelentes) {
        this.listaAlumnosExcelentes = listaAlumnosExcelentes;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
}