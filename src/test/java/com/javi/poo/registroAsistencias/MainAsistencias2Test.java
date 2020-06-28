package com.javi.poo.registroAsistencias;

import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;



@RunWith(SpringRunner.class)
public class MainAsistencias2Test extends Exception{


    @Test
    public void recopiladorDeAsistencias() {

        Alumno alumnoEma = new Alumno("RaulErnestoCruzSoliz", "");


        Docente docenteRaul = new Docente("RaulErnestoCruzSoliz","" );

        Aula aulaPrimeroA = new Aula();
        aulaPrimeroA.getListaDocente().add(docenteRaul);
        aulaPrimeroA.getListaAlumnos().add(alumnoEma);


        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.getAsistenciasDocente().put(docenteRaul, true);
        asistencia.getAsistencias().put(alumnoEma, true);


        // Una lista puede ser iterada sencillamente con un for
        for(Alumno alumno : aulaPrimeroA.getListaAlumnos()) {
            System.out.println("El docente de primero A es: " + docenteRaul.getNombre() + " " + alumno.getApellido());
            System.out.println("Un alumno de primero A es: " + alumno.getNombre() + " " + alumno.getApellido());
        }

        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        for(Map.Entry<Alumno, Boolean> entry : asistencia.getAsistencias().entrySet()) {
            System.out.println("El alumno de primero A es: " + entry.getKey().getNombre() + " " + entry.getKey().getApellido() + " Falto?? " + entry.getValue());
            // Assert que verifica que todos los alumnos hallan estado presentes o sea TRUE
            assertThat(entry.getValue().booleanValue(), equalTo(true));
        }

        // Assert que verifica que Aula tenga cuatro alumnos
        assertThat(aulaPrimeroA.getListaAlumnos().size(), equalTo(1));
        assertThat(aulaPrimeroA.getListaDocente().size(), equalTo(1));
        Docente docenteResult = aulaPrimeroA.getListaDocente().get(0);

        if(docenteRaul.equals(docenteResult)) {
            System.out.println("Docente raul y docente result son iguales!");
        }

        assertThat(docenteResult, equalTo(docenteRaul));
    }

    //Crear Alumno = "RaulErnestoCruzSoliz"
    //Crear Docente = "RaulErnestoCruzSoliz"
    // RecopiladorDeAsistencias
    // RecopiladorException -> "Error el nombre del alumno o docente supera los 10 caracteres permitods"
    // Test va a salir correcto porque espera que alumno y docente lancen
}