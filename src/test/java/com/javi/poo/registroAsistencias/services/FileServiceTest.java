package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
public class FileServiceTest {

    //atributo constante, osea, no puede ser modificado.
    public static final String CLASE_A = "ClaseA";

    FileUtilService fileUtilService = new FileUtilService();

    @Test
    public void givenArchivoClasesWhenBeingReadThenShowStudents() throws JaviException {
        String archivo = "ClasesModel.data";
        Resource resource = new ClassPathResource(archivo);
        Map contenedor = fileUtilService.parsearFilePreceptorOrAlumnos(resource, archivo);

        Clase listaDeClase = (Clase) contenedor.get(CLASE_A);
        //assertThat(claseList.isEmpty(), equalTo("Error, el nombre del alumno supera los 10 caracteres permitidos"));

        for (Alumno itinerador : listaDeClase.getListaAlumnos()) {
            System.out.println("El siguiente alumno posee la siguiente informacion: ");
            System.out.println("Clase: " + listaDeClase.getNombreClase());
            System.out.println("Nombre: " + itinerador.getNombre());
            System.out.println("Apellido: " + itinerador.getApellido());
            System.out.println("Edad: " + itinerador.getEdad());
            System.out.println("Nacionalidad: " + itinerador.getNacionalidad());
            System.out.println("----------------------------------------------");
        }
    }

    @Test
    public void givenArchivoPreceptorWhenBeingReadThenShowPreceptor() throws JaviException {
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
