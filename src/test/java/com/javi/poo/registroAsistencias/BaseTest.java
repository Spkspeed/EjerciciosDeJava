package com.javi.poo.registroAsistencias;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseTest {

    protected Map createDataModel() throws JaviException {
        Alumno alumno1 = new Alumno("Emanuel", "Soliz", "Argentino");
        Alumno alumno2 = new Alumno("Javier", "Soliz", "Argentino");
        Alumno alumno3 = new Alumno("Ariel", "Jarpa Soliz", "Argentino");
        Alumno alumno4 = new Alumno("Alfredo", "Villegas", "Argentino");
        Docente docente1 = new Docente("Raul", "Soliz", "Argentino");
        Preceptor preceptor1 = new Preceptor("Marcos", "Tineli", "argentino");

        Clase primeroA = new Clase();
        primeroA.setNombreClase("PrimeroA");
        primeroA.getListaAlumnos().add(alumno1);
        primeroA.getListaAlumnos().add(alumno2);
        primeroA.getListaAlumnos().add(alumno3);
        primeroA.getListaAlumnos().add(alumno4);
        primeroA.getListaDocente().add(docente1);
        primeroA.getListaPreceptor().add(preceptor1);

        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.setNombreClase("PrimeroA");
        asistencia.getAsistenciasDocente().put(docente1, true);
        asistencia.getAsistencias().put(alumno1, true);
        asistencia.getAsistencias().put(alumno2, true);
        asistencia.getAsistencias().put(alumno3, true);
        asistencia.getAsistencias().put(alumno4, true);
        asistencia.getAsistenciasPreceptor().put(preceptor1, true);

        Alumno alumno5 = new Alumno("Alfonso", "Piedras", "Español");
        Alumno alumno6 = new Alumno("Santiago", "Mendez", "Argentino");
        Alumno alumno7 = new Alumno("Diego", "Mendez", "Argentino");
        Docente docente2 = new Docente("Martina", "Cruñez", "Argentino");
        Preceptor preceptor2 = new Preceptor("Patricio", "notengoidea", "Argentino");

        Clase primeroB = new Clase();
        primeroB.setNombreClase("PrimeroB");
        primeroB.getListaAlumnos().add(alumno5);
        primeroB.getListaAlumnos().add(alumno6);
        primeroB.getListaAlumnos().add(alumno7);
        primeroB.getListaDocente().add(docente2);
        primeroB.getListaPreceptor().add(preceptor2);

        Asistencia asistencia2 = new Asistencia(); //forma de llamar al map.

        asistencia2.setNombreClase("PrimeroB");
        asistencia2.getAsistenciasDocente().put(docente2, true);
        asistencia2.getAsistencias().put(alumno5, true);
        asistencia2.getAsistenciasPreceptor().put(preceptor2, true);

        Alumno alumno8 = new Alumno("Bruno", "Galeano", "Bolivia");
        Alumno alumno9 = new Alumno("Alcides", "Galvan", "Argentino");
        Alumno alumno10 = new Alumno("Mauricio", "Piedras", "Peru");
        Docente docente3 = new Docente("Analia", "Montes", "Argentino");
        Preceptor preceptor3 = new Preceptor("Natalia", "Jimenez", "Argentino");

        Clase primeroC = new Clase();
        primeroC.setNombreClase("PrimeroC");
        primeroC.getListaAlumnos().add(alumno8);
        primeroC.getListaAlumnos().add(alumno9);
        primeroC.getListaAlumnos().add(alumno10);
        primeroC.getListaDocente().add(docente3);
        primeroC.getListaPreceptor().add(preceptor3);

        Asistencia asistencia3 = new Asistencia(); //forma de llamar al map.

        asistencia3.setNombreClase("PrimeroC");
        asistencia3.getAsistenciasDocente().put(docente3, true);
        asistencia3.getAsistencias().put(alumno8, true);
        asistencia3.getAsistencias().put(alumno9, true);
        asistencia3.getAsistencias().put(alumno10, true);
        asistencia3.getAsistenciasPreceptor().put(preceptor3, true);

        Alumno alumno11 = new Alumno("Pablo", "Toledo", "Argentino");
        Alumno alumno12 = new Alumno("Martin", "Turina", "Venezuela");
        Alumno alumno13 = new Alumno("Manolo", "Galvan", "Español");
        Alumno alumno14 = new Alumno("Arturo", "Illia", "Argentino");
        Docente docente4 = new Docente("Catarina", "Claus", "Britanica");
        Preceptor preceptor4 = new Preceptor("Maria", "Antonieta", "Francesa");

        Clase primeroD = new Clase();
        primeroD.setNombreClase("PrimeroD");
        primeroD.getListaAlumnos().add(alumno11);
        primeroD.getListaAlumnos().add(alumno12);
        primeroD.getListaAlumnos().add(alumno13);
        primeroD.getListaAlumnos().add(alumno14);
        primeroD.getListaDocente().add(docente4);
        primeroD.getListaPreceptor().add(preceptor4);

        Asistencia asistencia4 = new Asistencia(); //forma de llamar al map.
        asistencia4.setNombreClase("PrimeroD");
        asistencia4.getAsistenciasDocente().put(docente4, true);
        asistencia4.getAsistencias().put(alumno11, true);
        asistencia4.getAsistencias().put(alumno12, true);
        asistencia4.getAsistencias().put(alumno13, true);
        asistencia4.getAsistencias().put(alumno14, true);
        asistencia4.getAsistenciasPreceptor().put(preceptor4, true);

        List contenedorAulas = new ArrayList();
        contenedorAulas.add(primeroA);
        contenedorAulas.add(primeroB);
        contenedorAulas.add(primeroC);
        contenedorAulas.add(primeroD);

        List contenedorAsistencias = new ArrayList();
        contenedorAsistencias.add(asistencia);
        contenedorAsistencias.add(asistencia2);
        contenedorAsistencias.add(asistencia3);
        contenedorAsistencias.add(asistencia4);

        Map contenedorDeModelo = new HashMap();
        contenedorDeModelo.put("aulas", contenedorAulas);
        contenedorDeModelo.put("asistencias", contenedorAsistencias);

        return contenedorDeModelo;
    }

}