package com.javi.Files;
import com.javi.poo.registroAsistencias.exception.JaviException;
import file.AlumnoInformation;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class flie extends LectorDeFichero {
    @Test
    public void testProgramLectorDelFichero() throws JaviException{        
        List <AlumnoInformation> archivaAlumnos = Leer();
        for(AlumnoInformation alumno : archivaAlumnos){
            System.out.println("El siguiente alumno posee la siguiente informacion: ");
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Edad: " + alumno.getEdad());
            System.out.println("Nacionalidad: " + alumno.getNacionalidad());
            System.out.println("----------------------------------------------");
        }
    }
}