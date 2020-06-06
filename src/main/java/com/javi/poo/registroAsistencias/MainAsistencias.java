package com.javi.poo.registroAsistencias;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;

public class MainAsistencias {

    public static void main(String[] args) {

        Alumno alumnoEma = new Alumno("Emanuel", "Soliz");
        Alumno alumnoJavi = new Alumno("Javier", "Soliz");
        Alumno alumnoAriel = new Alumno("Ariel", "Jarpa Soliz");
        Alumno alumnoAlfredo = new Alumno("Alfredo", "Villegas");

        Aula aulaPrimeroA = new Aula();

        aulaPrimeroA.listaAlumnos.add(alumnoEma);
        aulaPrimeroA.listaAlumnos.add(alumnoJavi);
        aulaPrimeroA.listaAlumnos.add(alumnoAriel);

        Asistencia asistencia = new Asistencia();

        Boolean presente = true;

        asistencia.asistencias.put(alumnoEma, presente);
        asistencia.asistencias.put(alumnoJavi, false);
        asistencia.asistencias.put(alumnoAriel, presente);
        asistencia.asistencias.put(alumnoAlfredo, false);


        // Una lista puede ser iterada sencillamente con un for
        for(Alumno alumno : aulaPrimeroA.listaAlumnos) {
            System.out.println("Un alumno de primero A es: " + alumno.nombre + " " + alumno.apellido);
        }

        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        for(Map.Entry<Alumno, Boolean> entry : asistencia.asistencias.entrySet()) {
            System.out.println("El alumno de primero A es: " + entry.getKey().nombre+ " " + entry.getKey().apellido + " Falto?? " + entry.getValue());
        }

    }
}
