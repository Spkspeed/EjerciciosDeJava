package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.BaseTest;
import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.*;
import com.javi.poo.registroAsistencias.repository.AlumnoRepository;
import com.javi.poo.registroAsistencias.repository.ClaseRepository;
import com.javi.poo.registroAsistencias.repository.DocenteRepository;
import com.javi.poo.registroAsistencias.repository.PreceptorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
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
//comando para llevar a cabo pruebas que contienen contexto de Spring
@SpringBootTest
public class AlumnosServiceTest extends BaseTest {

    //comando para poder instansiar a la clase del repositorio
    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    PreceptorRepository preceptorRepository;

    @Autowired
    ClaseRepository claseRepository;

    @Autowired
    DocenteRepository docenteRepository;

    AlumnoService alumnoService = new AlumnoService();
    AlumnoRepositoryService alumnoTest = new AlumnoRepositoryService();
    
    @Test
    public void AlumnoRepositoryServiceTest(){
    }
    @Test
    //utilizamos el repositorio
    public void testAlumnoRepository() {
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("AlumnoRepository");
         //utilizamos el metodo que establecimos en el repositorio
        List<Alumno> result = alumnoRepository.findByNombre("Carlos");
        for(Alumno alumno : result){
            System.out.println(alumno.getNombre());
        }
        //assert que verifica que los valores que llegaron a la lista anterior sean solo dos.
        assertThat(result.size(), equalTo(4));
    }
    @Test
    public void testPreceptorRepository(){
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("PreceptorRepository");

        List<Preceptor> preceptores = preceptorRepository.findByNombreAndApellido("Robin","Hood");

        for(Preceptor preceptor : preceptores){
            System.out.println(preceptor.getNombre() + " " + preceptor.getApellido());
        }

        assertThat(preceptores.size(), equalTo(1));
    }

    //el Transactional nos ayuda a llevar a cabo este particular test que no podria funcionar normalmente debido a sus caracteristicas
    @Test
    //el punto crucial para usar esto es en mantener el objeto Clase
    @Transactional
    public void testClaseRepository(){
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("ClaseRepository");

        //buscamos el nombre ClaseA y se guarda en el nombre_clase con el objeto Clase creado
        //esto ocurre gracias al metodo establecido en claseRepository
        Clase clase = claseRepository.findByNombreClase("ClaseA");
        //el objeto anterior mantiene guardado el nombreClase gracias al Transactional que mantiene viva el proceso
        System.out.println(clase.getNombreClase());

        //tambien por el Transactional ahora podemos ir a la lista de alumnos que se agrego automaticamente gracias a la conexion establecida en las columnas por medio de sus clases correspondientes
        for (Alumno iterar : clase.getListaAlumnos()){
            System.out.println(iterar.getNombre());
        }
        System.out.println(clase.getListaDocente().get(0).getNombre());

        //y por ultimo podemos acceder a la lista de alumnos y realizar un assertThat
        assertThat(clase.getListaAlumnos().size(), equalTo(7));
    }

    @Test
    public void testDocenteRepository(){
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("DocenteRepository");
        List<Docente> docentes = docenteRepository.findByNombre("Carto");
        for(Docente docente : docentes){
            System.out.println(docente.getNombre());
        }
        assertThat(docentes.size(), equalTo(1));
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
                System.out.println("Y el preceptor: " + clase.getPreceptor().getNombre() + " " + clase.getPreceptor().getApellido());
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
                System.out.println("Y el preceptor: " + clase.getPreceptor().getNombre());
            } else {
                System.out.println("------------------------------------------");
                System.out.println("Faltaron las clases: " + contador.getNombreClase());
            }
        }

        System.out.println("--------------------------------------------------");
        alumnoService.nacionalidadesAlumno(createDataModel());
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
            new Alumno("Clase1","DSDSAURLAURAURLAUR", "Soliz", "Argentino",22);
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
        System.out.println("El preceptor de " + primero + " es: " + clase.getPreceptor().getNombre() + " " + clase.getPreceptor().getApellido());
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
