package com.javi.poo.registroAsistencias;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.*;
import com.javi.poo.registroAsistencias.services.AlumnoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/*
    Está basada en varias técnicas del sexenio: herencia, cohesión, abstracción, polimorfismo, acoplamiento y encapsulamiento.

    Metodo return:
            Como se devuelve un valor: se puede establecer en un metodo y al llamarlo en otro, donde se tendra que extraer de cierta forma segun lo que se este extrayendo.

            Como hago para devolver varios valores: se los puede juntar en paquetes de informacion utilizando collections como el HashMap o ArrayList
 */
@RunWith(SpringRunner.class)
public class MainAsistenciasTest {

    AlumnoService alumnoService = new AlumnoService();

    private Map createDataModel() throws JaviException {
        Alumno alumno1 = new Alumno("Emanuel", "Soliz", "Argentino");
        Alumno alumno2 = new Alumno("Javier", "Soliz", "Argentino");
        Alumno alumno3 = new Alumno("Ariel", "Jarpa Soliz", "Argentino");
        Alumno alumno4 = new Alumno("Alfredo", "Villegas", "Argentino");
        Docente docente1 = new Docente("Raul", "Soliz", "Argentino");
        Preceptor preceptor1 = new Preceptor("Marcos", "Tineli", "argentino");

        Clase primeroA = new Clase();
        primeroA.setNombreClase("PrimeroA");
        primeroA.getListaAlumnos().add(alumno1);
        primeroA.getListaAlumnos().add(alumno2);
        primeroA.getListaAlumnos().add(alumno3);
        primeroA.getListaAlumnos().add(alumno4);
        primeroA.getListaDocente().add(docente1);
        primeroA.getListaPreceptor().add(preceptor1);

        Asistencia asistencia = new Asistencia(); //forma de llamar al map.

        asistencia.setNombreClase("PrimeroA");
        asistencia.getAsistenciasDocente().put(docente1, true);
        asistencia.getAsistencias().put(alumno1, true);
        asistencia.getAsistencias().put(alumno2, true);
        asistencia.getAsistencias().put(alumno3, true);
        asistencia.getAsistencias().put(alumno4, true);
        asistencia.getAsistenciasPreceptor().put(preceptor1, true);

        Alumno alumno5 = new Alumno("Alfonso", "Piedras", "Español");
        Alumno alumno6 = new Alumno("Santiago", "Mendez", "Argentino");
        Alumno alumno7 = new Alumno("Diego", "Mendez", "Argentino");
        Docente docente2 = new Docente("Martina", "Cruñez", "Argentino");
        Preceptor preceptor2 = new Preceptor("Patricio", "notengoidea", "Argentino");

        Clase primeroB = new Clase();
        primeroB.setNombreClase("PrimeroB");
        primeroB.getListaAlumnos().add(alumno5);
        primeroB.getListaAlumnos().add(alumno6);
        primeroB.getListaAlumnos().add(alumno7);
        primeroB.getListaDocente().add(docente2);
        primeroB.getListaPreceptor().add(preceptor2);

        Asistencia asistencia2 = new Asistencia(); //forma de llamar al map.

        asistencia2.setNombreClase("PrimeroB");
        asistencia2.getAsistenciasDocente().put(docente2, true);
        asistencia2.getAsistencias().put(alumno5, true);
        asistencia2.getAsistenciasPreceptor().put(preceptor2, true);

        Alumno alumno8 = new Alumno("Bruno", "Galeano", "Bolivia");
        Alumno alumno9 = new Alumno("Alcides", "Galvan", "Argentino");
        Alumno alumno10 = new Alumno("Mauricio", "Piedras", "Peru");
        Docente docente3 = new Docente("Analia", "Montes", "Argentino");
        Preceptor preceptor3 = new Preceptor("Natalia", "Jimenez", "Argentino");

        Clase primeroC = new Clase();
        primeroC.setNombreClase("PrimeroC");
        primeroC.getListaAlumnos().add(alumno8);
        primeroC.getListaAlumnos().add(alumno9);
        primeroC.getListaAlumnos().add(alumno10);
        primeroC.getListaDocente().add(docente3);
        primeroC.getListaPreceptor().add(preceptor3);

        Asistencia asistencia3 = new Asistencia(); //forma de llamar al map.

        asistencia3.setNombreClase("PrimeroC");
        asistencia3.getAsistenciasDocente().put(docente3, true);
        asistencia3.getAsistencias().put(alumno8, true);
        asistencia3.getAsistencias().put(alumno9, true);
        asistencia3.getAsistencias().put(alumno10, true);
        asistencia3.getAsistenciasPreceptor().put(preceptor3, true);

        Alumno alumno11 = new Alumno("Pablo", "Toledo", "Argentino");
        Alumno alumno12 = new Alumno("Martin", "Turina", "Venezuela");
        Alumno alumno13 = new Alumno("Manolo", "Galvan", "Español");
        Alumno alumno14 = new Alumno("Arturo", "Illia", "Argentino");
        Docente docente4 = new Docente("Catarina", "Claus", "Britanica");
        Preceptor preceptor4 = new Preceptor("Maria", "Antonieta", "Francesa");

        Clase primeroD = new Clase();
        primeroD.setNombreClase("PrimeroD");
        primeroD.getListaAlumnos().add(alumno11);
        primeroD.getListaAlumnos().add(alumno12);
        primeroD.getListaAlumnos().add(alumno13);
        primeroD.getListaAlumnos().add(alumno14);
        primeroD.getListaDocente().add(docente4);
        primeroD.getListaPreceptor().add(preceptor4);

        Asistencia asistencia4 = new Asistencia(); //forma de llamar al map.
        asistencia4.setNombreClase("PrimeroD");
        asistencia4.getAsistenciasDocente().put(docente4, true);
        asistencia4.getAsistencias().put(alumno11, true);
        asistencia4.getAsistencias().put(alumno12, true);
        asistencia4.getAsistencias().put(alumno13, true);
        asistencia4.getAsistencias().put(alumno14, true);
        asistencia4.getAsistenciasPreceptor().put(preceptor4, true);

        List contenedorAulas = new ArrayList();
        contenedorAulas.add(primeroA);
        contenedorAulas.add(primeroB);
        contenedorAulas.add(primeroC);
        contenedorAulas.add(primeroD);

        List contenedorAsistencias = new ArrayList();
        contenedorAsistencias.add(asistencia);
        contenedorAsistencias.add(asistencia2);
        contenedorAsistencias.add(asistencia3);
        contenedorAsistencias.add(asistencia4);

        Map contenedorDeModelo = new HashMap();
        contenedorDeModelo.put("aulas", contenedorAulas);
        contenedorDeModelo.put("asistencias", contenedorAsistencias);

        return contenedorDeModelo;
    }


    @Test
    public void testAsistenciasHasAlumnosAndDocentesObjects() throws JaviException {

        Map contenedorLiberador = createDataModel();

        List<Clase> listaClases = (List) contenedorLiberador.get("aulas");
        List<Asistencia> listaAsistencias = (List) contenedorLiberador.get("asistencias");

        for (Clase clase : listaClases) {
            mostrarClaseDetails(clase, clase.getNombreClase());
        }

        for (Asistencia asistencia : listaAsistencias) {
            mostrarDatosDeAsistencias(asistencia, asistencia.getNombreClase());
        }

        Clase clase = new Clase();

        for (Clase contador : listaClases) {
            if (contador.getNombreClase().equals("PrimeroA")) {
                clase = contador;
                System.out.println("------------------------------------------");
                System.out.println("Primero A esta compuesta por los alumnos: ");
                for (Alumno alumno : clase.getListaAlumnos()) {
                    getInformationAlumno(alumno);
                }
                System.out.println(" ");
                System.out.println("Con el docente: ");
                for (Docente docente : clase.getListaDocente()) {
                    getInformationDocente(docente);
                }
                System.out.println(" ");
                System.out.println("Y el preceptor: ");
                for (Preceptor preceptor : clase.getListaPreceptor()) {
                    getInformationPreceptor(preceptor);
                }
            } else if (contador.getNombreClase().equals("PrimeroB")) {
                System.out.println("------------------------------------------");
                System.out.println("Primero B esta compuesto por los alumnos: ");
                for (Alumno alumno : clase.getListaAlumnos()) {
                    getInformationAlumno(alumno);
                }
                System.out.println(" ");
                System.out.println("Con el docente: ");
                for (Docente docente : clase.getListaDocente()) {
                    getInformationDocente(docente);
                }
                System.out.println(" ");
                System.out.println("Y el preceptor: ");
                for (Preceptor preceptor : clase.getListaPreceptor()) {
                    getInformationPreceptor(preceptor);
                }
            } else {
                System.out.println("------------------------------------------");
                System.out.println("Faltaron las clases: " + contador.getNombreClase());
            }


        }

        System.out.println("--------------------------------------------------");
        alumnoService.nacionalidadesAlumno(1, createDataModel());
        System.out.println(" ");
        
        System.out.println("--------------------getNacionalidadesDistintas ----------------------");
        alumnoService.getNacionalidadesDistintas(createDataModel());

        //obtenerClasePrimeroA;
        // Assert que verifica que primeroA tenga cuatro alumnos
        assertThat(clase.getListaAlumnos().size(), equalTo(4));
        System.out.println(" ");
        assertThat(clase.getListaDocente().size(), equalTo(1));
        System.out.println(" ");
    }

    /*
        tengo que buscar una forma en la que tome obtenga cada tipo de nacionalidad
        y guardarlas por separado sin se vuelvan a repetir.
        */
    @Test
    public void testDocenteNameOnlyAllowsTenCharacters() throws Exception {
        try {
            new Docente("RCADSCSDRAURLAURAURLAUR", "Soliz", "Argentino");
        } catch (JaviException e) {
            assertThat(e.getMessage(), equalTo("Error, el nombre del docente supera los 10 caracteres permitidos"));
        }
    }

    @Test
    public void testAlumnoNameOnlyAllowsTenCharacters() throws Exception {
        try {
            new Alumno("DSDSAURLAURAURLAUR", "Soliz", "Argentino");
        } catch (JaviException e) {
            assertThat(e.getMessage(), equalTo("Error, el nombre del alumno supera los 10 caracteres permitidos"));
        }
    }
    private void getInformationPreceptor(Preceptor preceptor){
        System.out.println(" ");
                    System.out.print(preceptor.getNombre());
                    System.out.print(" ");
                    System.out.print(preceptor.getApellido());
                    System.out.print(" ");
                    System.out.print(preceptor.getNacionalidad());
                    System.out.println(" ");
    }
    private void getInformationDocente(Docente docente){
        System.out.println(" ");
                    System.out.print(docente.getNombre());
                    System.out.print(" ");
                    System.out.print(docente.getApellido());
                    System.out.print(" ");
                    System.out.print(docente.getNacionalidad());
                    System.out.println(" ");
    }
    private void getInformationAlumno(Alumno alumno){
        System.out.println(" ");
                    System.out.print(alumno.getNombre());
                    System.out.print(" ");
                    System.out.print(alumno.getApellido());
                    System.out.print(" ");
                    System.out.print(alumno.getNacionalidad());
                    System.out.println(" ");
    }
    private void mostrarClaseDetails(Clase clase, String primero) {
        // Una lista puede ser iterada sencillamente con un for
        for (Alumno alumno : clase.getListaAlumnos()) {
            //System.out.println("El docente de primero A es: " + docente.getNombre() + " " + alumno.getApellido());
            System.out.println("Un alumno de " + primero + " es: " + alumno.getNombre() + " " + alumno.getApellido() + " " + alumno.getNacionalidad());
        }

        for (Docente docente : clase.getListaDocente()) {
            System.out.println("El docente de " + primero + " es: " + docente.getNombre() + " " + docente.getApellido() + " " + docente.getNacionalidad());
        }

        for (Preceptor preceptor : clase.getListaPreceptor()) {
            System.out.println("El preceptor de " + primero + " es: " + preceptor.getNombre() + " " + preceptor.getApellido() + " " + preceptor.getNacionalidad());
        }

    }

    private void mostrarDatosDeAsistencias(Asistencia asistencia, String primero) {
        // Un mapa primero debe obtenerse un iterador y luego se lo podra leer
        for (Map.Entry<Alumno, Boolean> entry : asistencia.getAsistencias().entrySet()) {
            System.out.println("El alumno de " + primero + " es: " + entry.getKey().getNombre() + " " + entry.getKey().getApellido() + " Falto?? " + entry.getValue());
            // Assert que verifica que todos los alumnos hallan estado presentes o sea TRUE
            assertThat(entry.getValue().booleanValue(), equalTo(true));
        }
    }
}
