package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import java.io.IOException;

import com.javi.poo.registroAsistencias.model.Clase;
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
    public void testProgramLectorDelFichero() throws JaviException, IOException {
        String archivo = "ClasesModel.data";
        Resource resource = new ClassPathResource(archivo);
        Map contenedor = fileUtilService.parsearFilePreceptorOrAlumnos(resource, archivo);
        List<Clase> claseList = (List) contenedor.get("ClaseA");
        for(Clase clase : claseList ){
            System.out.println("El siguiente alumno posee la siguiente informacion: ");
            System.out.println("Clase: " + clase.getNombreClase());
            System.out.println("Nombre: " + clase.getAlumno().getNombre());
            System.out.println("Apellido: " + clase.getAlumno().getApellido());
            System.out.println("Nacionalidad: " + clase.getAlumno().getNacionalidad());
            System.out.println("Edad: " + clase.getAlumno().getEdad());
            System.out.println("----------------------------------------------");
        }
    }
    @Test
    public void testProgramLectorDelFicheroDePreceptores() throws JaviException {
        String archivo = "PreceptorModel.data";
        Resource resource = new ClassPathResource(archivo);
        Map contenedor = fileUtilService.parsearFilePreceptorOrAlumnos(resource, archivo);
        Clase clase = (Clase) contenedor.get("ClaseD");
        System.out.println("Un preceptor posee la siguiente informacion: ");
        System.out.println("Clase: " + clase.getNombreClase());
        System.out.println("Nombre: " + clase.getPreceptor().getNombre());
        System.out.println("Apellido: " + clase.getPreceptor().getApellido());
        System.out.println("Nacionalidad: " + clase.getPreceptor().getNacionalidad());
        System.out.println("----------------------------------------------");
    }
}
