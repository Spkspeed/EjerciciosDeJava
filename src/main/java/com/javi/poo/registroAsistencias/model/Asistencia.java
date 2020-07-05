package com.javi.poo.registroAsistencias.model;

import java.util.HashMap;
import java.util.Map;

public class Asistencia {

    private String nombreClase;

    // detalle de ingresar el codigo y valor desde la formacion del map.
    private Map<Alumno, Boolean> asistencias = new HashMap(); // Cada asistencia debe tener Alumno - Asistencia

    public Map<Alumno, Boolean> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Map<Alumno, Boolean> asistencias) {
        this.asistencias = asistencias;
    }

    private Map<Docente, Boolean> asistenciasDocente = new HashMap();

    public Map<Docente, Boolean> getAsistenciasDocente() {
        return asistenciasDocente;
    }

    public void setAsistenciasDocente(Map<Alumno, Boolean> asistencias) {
        this.asistencias = asistencias;
    }

    private Map<Preceptor, Boolean> asistenciasPreceptor = new HashMap();

    public Map<Preceptor, Boolean> getAsistenciasPreceptor() { return asistenciasPreceptor; }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
}
