package com.javi.poo.registroAsistencias;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

/*


 */

@RunWith(SpringRunner.class)
public class MainAsistenciasTest {

    @Test
    public void testAsistencias() throws JaviException {

        Alumno alumnoEma = new Alumno("Emanuel", "Soliz");
        Alumno alumnoJavi = new Alumno("Javier", "Soliz");
        Alumno alumnoAriel = new Alumno("Ariel", "Jarpa Soliz");
        Alumno alumnoAlfredo = new Alumno("Alfredo", "Villegas");
        Docente docenteRaul = new Docente("Raul", "Soliz");

        Aula aulaPrimeroA = new Aula();
        aulaPrimeroA.getListaDocente().add(docenteRaul);
        aulaPrimeroA.getListaAlumnos().add(alumnoEma);
        aulaPrimeroA.getListaAlumnos().add(alumnoJavi);
        aulaPrimeroA.getListaAlumnos().add(alumnoAriel);


        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.getAsistenciasDocente().put(docenteRaul, true);
        asistencia.getAsistencias().put(alumnoEma, true);
        asistencia.getAsistencias().put(alumnoJavi, true);
        asistencia.getAsistencias().put(alumnoAriel, true);
        asistencia.getAsistencias().put(alumnoAlfredo, true);


        // Una lista puede ser iterada sencillamente con un for
        for (Alumno alumno : aulaPrimeroA.getListaAlumnos()) {
            System.out.println("El docente de primero A es: " + docenteRaul.getNombre() + " " + alumno.getApellido());
            System.out.println("Un alumno de primero A es: " + alumno.getNombre() + " " + alumno.getApellido());
        }

        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        for (Map.Entry<Alumno, Boolean> entry : asistencia.getAsistencias().entrySet()) {
            System.out.println("El alumno de primero A es: " + entry.getKey().getNombre() + " " + entry.getKey().getApellido() + " Falto?? " + entry.getValue());
            // Assert que verifica que todos los alumnos hallan estado presentes o sea TRUE
            assertThat(entry.getValue().booleanValue(), equalTo(true));
        }

        // Assert que verifica que Aula tenga cuatro alumnos
        assertThat(aulaPrimeroA.getListaAlumnos().size(), equalTo(3));
        assertThat(aulaPrimeroA.getListaDocente().size(), equalTo(1));
        Docente docenteResult = aulaPrimeroA.getListaDocente().get(0);

        if (docenteRaul.equals(docenteResult)) {
            System.out.println("Docente raul y docente result son iguales!");
        }

        assertThat(docenteResult, equalTo(docenteRaul));
    }

    @Test
    public void recopiladorAsistencias() throws JaviException {
        Alumno alumnoEma = new Alumno("Raul ", "Soliz");

        Docente docenteRaul = new Docente("Raul", "Soliz");

        Aula aulaPrimeroA = new Aula();
        aulaPrimeroA.getListaDocente().add(docenteRaul);
        aulaPrimeroA.getListaAlumnos().add(alumnoEma);

        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.getAsistenciasDocente().put(docenteRaul, true);
        asistencia.getAsistencias().put(alumnoEma, true);

        // Una lista puede ser iterada sencillamente con un for
        for (Alumno alumno : aulaPrimeroA.getListaAlumnos()) {
            System.out.println("El docente de primero A es: " + docenteRaul.getNombre() + " " + alumno.getApellido());
            System.out.println("Un alumno de primero A es: " + alumno.getNombre() + " " + alumno.getApellido());
        }
        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        for (Map.Entry<Alumno, Boolean> entry : asistencia.getAsistencias().entrySet()) {
            System.out.println("El alumno de primero A es: " + entry.getKey().getNombre() + " " + entry.getKey().getApellido() + " Falto?? " + entry.getValue());
            // Assert que verifica que todos los alumnos hallan estado presentes o sea TRUE
            assertThat(entry.getValue().booleanValue(), equalTo(true));
        }
        // Assert que verifica que Aula tenga cuatro alumnos
        assertThat(aulaPrimeroA.getListaAlumnos().size(), equalTo(1));
        assertThat(aulaPrimeroA.getListaDocente().size(), equalTo(1));
        Docente docenteResult = aulaPrimeroA.getListaDocente().get(0);

        if (docenteRaul.equals(docenteResult)) {
            System.out.println("Docente raul y docente result son iguales!");
        }

        assertThat(docenteResult, equalTo(docenteRaul));

//        assertThat(Alumno, equalTo(throw.exception);


    }

    @Test
    public void test_exception_approach_1() throws Exception {
        try {
            Docente docente1 = new Docente("RaulRAURLAURAURLAUR", "ASDASDA");
        } catch (JaviException e) {
            assertThat(e.getMessage(), equalTo("Error, el nombre del docente supera los 10 caracteres permitidos"));
        }
    }

    @Test
    public void test_exception_approach_2()  throws Exception{
        try{
            Alumno alumno1 = new Alumno("RaulRAURLAURAURLAUR", "");
        } catch (JaviException e){
            assertThat(e.getMessage(), equalTo("Error, el nombre del alumno supera los 10 caracteres permitidos"));
        }
    }
    //Crear Alumno = "RaulErnestoCruzSoliz"
    //Crear Docente = "RaulErnestoCruzSoliz"
    // RecopiladorDeAsistencias
    // RecopiladorException -> "Error el nombre del alumno o docente supera los 10 caracteres permitods"
    // Test va a salir correcto porque espera que alumno y docente lancen
}