package com.javi.poo.registroAsistencias;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Asistencia;
import com.javi.poo.registroAsistencias.model.Aula;
import com.javi.poo.registroAsistencias.model.Docente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
public class MainAsistenciasTest {

    @Test
    public void testAsistenciasHasAlumnosAndDocentesObjects() throws JaviException {
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
        aulaPrimeroA.getListaAlumnos().add(alumnoAlfredo);

        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.getAsistenciasDocente().put(docenteRaul, true);
        asistencia.getAsistencias().put(alumnoEma, true);
        asistencia.getAsistencias().put(alumnoJavi, true);
        asistencia.getAsistencias().put(alumnoAriel, true);
        asistencia.getAsistencias().put(alumnoAlfredo, true);

        mostrarAlumnoAndDocenteDetails(aulaPrimeroA, docenteRaul);
        mostrarDatosDeAsistencias(asistencia);

        // Assert que verifica que Aula tenga cuatro alumnos
        assertThat(aulaPrimeroA.getListaAlumnos().size(), equalTo(4));
        assertThat(aulaPrimeroA.getListaDocente().size(), equalTo(1));
        Docente docenteResult = aulaPrimeroA.getListaDocente().get(0);

        assertThat(docenteResult, equalTo(docenteRaul));
    }

    @Test
    public void testAsistenciasHasAlumnosAndDocentesObjectsOnlyOne() throws JaviException {
        Alumno alumnoEma = new Alumno("Emanuel", "Soliz");
        Docente docenteRaul = new Docente("Raul", "Soliz");

        Aula aulaPrimeroA = new Aula();
        aulaPrimeroA.getListaDocente().add(docenteRaul);
        aulaPrimeroA.getListaAlumnos().add(alumnoEma);

        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.getAsistenciasDocente().put(docenteRaul, true);
        asistencia.getAsistencias().put(alumnoEma, true);

        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        mostrarAlumnoAndDocenteDetails(aulaPrimeroA, docenteRaul);
        mostrarDatosDeAsistencias(asistencia);

        // Assert que verifica que Aula tenga cuatro alumnos
        assertThat(aulaPrimeroA.getListaAlumnos().size(), equalTo(1));
        assertThat(aulaPrimeroA.getListaDocente().size(), equalTo(1));
        Docente docenteResult = aulaPrimeroA.getListaDocente().get(0);

        assertThat(docenteResult, equalTo(docenteRaul));
    }

    @Test
    public void testDocenteNameOnlyAllowsTenCharacters() throws Exception {
        try {
            new Docente("RCADSCSDRAURLAURAURLAUR", "ASDASDA");
        } catch (JaviException e) {
            assertThat(e.getMessage(), equalTo("Error, el nombre del docente supera los 10 caracteres permitidos"));
        }
    }

    @Test
    public void testAlumnoNameOnlyAllowsTenCharacters() throws Exception {
        try {
            new Alumno("DSDSAURLAURAURLAUR", "");
        } catch (JaviException e) {
            assertThat(e.getMessage(), equalTo("Error, el nombre del alumno supera los 10 caracteres permitidos"));
        }
    }

    private void mostrarAlumnoAndDocenteDetails(Aula aula, Docente docente) {
        // Una lista puede ser iterada sencillamente con un for
        for (Alumno alumno : aula.getListaAlumnos()) {
            System.out.println("El docente de primero A es: " + docente.getNombre() + " " + alumno.getApellido());
            System.out.println("Un alumno de primero A es: " + alumno.getNombre() + " " + alumno.getApellido());
        }

    }

    private void mostrarDatosDeAsistencias(Asistencia asistencia) {
        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        for (Map.Entry<Alumno, Boolean> entry : asistencia.getAsistencias().entrySet()) {
            System.out.println("El alumno de primero A es: " + entry.getKey().getNombre() + " " + entry.getKey().getApellido() + " Falto?? " + entry.getValue());
            // Assert que verifica que todos los alumnos hallan estado presentes o sea TRUE
            assertThat(entry.getValue().booleanValue(), equalTo(true));
        }
    }
}