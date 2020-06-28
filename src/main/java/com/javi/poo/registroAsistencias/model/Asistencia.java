package com.javi.poo.registroAsistencias;

import java.util.HashMap;
import java.util.Map;

/*
    ArrayList
    Hashmap
 */
public class Asistencia {

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
















}
