package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
public class FileServiceTest {

    FileUtilService fileUtilService = new FileUtilService();

    @Test
    public void testProgramLectorDelFichero() throws JaviException, IOException{

        Map contenedor = fileUtilService.parseFileAlumnos(FileofTestResource());
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

    public Resource FileofTestResource(){
        Resource resource = new ClassPathResource("ClasesModel.data");
        return resource;
    }
}