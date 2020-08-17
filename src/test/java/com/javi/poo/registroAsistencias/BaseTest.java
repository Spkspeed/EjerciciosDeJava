package com.javi.poo.registroAsistencias;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseTest {

    protected Map createDataModel() throws JaviException {
        List<Alumno> listaAlumnos = new ArrayList<>();
        List<Docente> listaDocentes = new ArrayList<>();

        Alumno alumno1 = new Alumno("Clase1","Emanuel", "Soliz", "Argentino", 22);
        Alumno alumno2 = new Alumno("Clase1","Javier", "Soliz", "Argentino", 21);
        Alumno alumno3 = new Alumno("Clase1","Ariel", "Jarpa Soliz", "Argentino", 22);
        Alumno alumno4 = new Alumno("Clase1","Alfredo", "Villegas", "Argentino",32);
        Docente docente1 = new Docente("Raul", "Soliz", "Argentino");
        Preceptor preceptor1 = new Preceptor("Marcos", "Tineli", "argentino");

        Clase primeroA = new Clase();
        primeroA.setNombreClase("PrimeroA");
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaDocentes.add(docente1);
        primeroA.setPreceptor(preceptor1);
        primeroA.setListaAlumnos(new ArrayList(listaAlumnos));
        primeroA.setListaDocente(new ArrayList(listaDocentes));
        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.setNombreClase("PrimeroA");
        asistencia.getAsistenciasDocente().put(docente1, true);
        asistencia.getAsistencias().put(alumno1, true);
        asistencia.getAsistencias().put(alumno2, true);
        asistencia.getAsistencias().put(alumno3, true);
        asistencia.getAsistencias().put(alumno4, true);
        asistencia.getAsistenciasPreceptor().put(preceptor1, true);

        Alumno alumno5 = new Alumno("Clase2","Alfonso", "Piedras", "Español",18);
        Alumno alumno6 = new Alumno("Clase2","Santiago", "Mendez", "Argentino", 39);
        Alumno alumno7 = new Alumno("Clase2","Diego", "Mendez", "Argentino",27);
        Docente docente2 = new Docente("Martina", "Cruñez", "Argentino");
        Preceptor preceptor2 = new Preceptor("Patricio", "notengoidea", "Argentino");

        listaAlumnos = new ArrayList<>();
        listaDocentes = new ArrayList<>();

        Clase primeroB = new Clase();
        primeroB.setNombreClase("PrimeroB");
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);
        listaAlumnos.add(alumno7);
        listaDocentes.add(docente2);
        primeroB.setPreceptor(preceptor2);
        primeroB.setListaAlumnos(listaAlumnos);
        primeroB.setListaDocente(listaDocentes);
        Asistencia asistencia2 = new Asistencia(); //forma de llamar al map.

        asistencia2.setNombreClase("PrimeroB");
        asistencia2.getAsistenciasDocente().put(docente2, true);
        asistencia2.getAsistencias().put(alumno5, true);
        asistencia2.getAsistenciasPreceptor().put(preceptor2, true);

        Alumno alumno8 = new Alumno("Clase3","Bruno", "Galeano", "Bolivia",20);
        Alumno alumno9 = new Alumno("Clase3","Alcides", "Galvan", "Argentino",19);
        Alumno alumno10 = new Alumno("Clase3","Mauricio", "Piedras", "Peru",45);
        Docente docente3 = new Docente("Analia", "Montes", "Argentino");
        Preceptor preceptor3 = new Preceptor("Natalia", "Jimenez", "Argentino");

        Clase primeroC = new Clase();
        primeroC.setNombreClase("PrimeroC");
        listaAlumnos.add(alumno8);
        listaAlumnos.add(alumno9);
        listaAlumnos.add(alumno10);
        listaDocentes.add(docente3);
        primeroC.setPreceptor(preceptor3);
        primeroC.setListaAlumnos(listaAlumnos);
        primeroC.setListaDocente(listaDocentes);

        Asistencia asistencia3 = new Asistencia(); //forma de llamar al map.
        asistencia3.setNombreClase("PrimeroC");
        asistencia3.getAsistenciasDocente().put(docente3, true);
        asistencia3.getAsistencias().put(alumno8, true);
        asistencia3.getAsistencias().put(alumno9, true);
        asistencia3.getAsistencias().put(alumno10, true);
        asistencia3.getAsistenciasPreceptor().put(preceptor3, true);

        Alumno alumno11 = new Alumno("Clase4","Pablo", "Toledo", "Argentino",43);
        Alumno alumno12 = new Alumno("Clase4","Martin", "Turina", "Venezuela",42);
        Alumno alumno13 = new Alumno("Clase4","Manolo", "Galvan", "Español",25);
        Alumno alumno14 = new Alumno("Clase4","Arturo", "Illia", "Argentino",33);
        Docente docente4 = new Docente("Catarina", "Claus", "Britanica");
        Preceptor preceptor4 = new Preceptor("Maria", "Antonieta", "Francesa");

        Clase primeroD = new Clase();
        primeroD.setNombreClase("PrimeroD");
        listaAlumnos.add(alumno11);
        listaAlumnos.add(alumno12);
        listaAlumnos.add(alumno13);
        listaAlumnos.add(alumno14);
        listaDocentes.add(docente4);
        primeroD.setPreceptor(preceptor4);
        primeroD.setListaAlumnos(listaAlumnos);
        primeroD.setListaDocente(listaDocentes);

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
