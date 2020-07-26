package com.javi.Files;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
public class FileService extends LectorDeFichero {
    @Test
    public void testProgramLectorDelFichero() throws JaviException{

        Map contenedor = parseFileAlumnos();
        List <Alumno> listaAlumnos = (List) contenedor.get("ClaseA");

        for(Alumno alumno : listaAlumnos){
            System.out.println("El siguiente alumno posee la siguiente informacion: ");
            System.out.println("Clase: " + alumno.getNombreClase());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Nacionalidad: " + alumno.getNacionalidad());
            System.out.println("Edad: " + alumno.getEdad());
            System.out.println("----------------------------------------------");
        }
    }
}