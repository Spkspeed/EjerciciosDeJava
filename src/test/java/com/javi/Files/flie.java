package com.javi.Files;
import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class flie extends LectorDeFichero {
    @Test
    public void main() throws JaviException{
        LectorDeFichero inicio = new LectorDeFichero();
        
        List <Alumno> archivaAlumnos = Leer();
        for(Alumno alumno : archivaAlumnos){
            System.out.print(alumno.getNombre());
            System.out.print(" ");
            System.out.print(alumno.getApellido());
            System.out.print(" ");
            System.out.print(alumno.getNacionalidad());
            System.out.println(" ");
        }
    }
}