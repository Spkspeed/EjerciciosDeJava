package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest //comando para llevar a cabo pruebas que contienen contexto de Spring
public class ClaseServiceTest {

    @Autowired
    ClaseService claseService;

    //el Transactional nos ayuda a llevar a cabo este particular test que no podria funcionar normalmente debido a sus caracteristicas
    @Transactional
    @Test
    public void testSearchListNamesStudentsOfTheClass(){
        Clase listaDeAlumnos = claseService.obtenerNombresDeLosAlumnosDeUnaClaseSegunElNombreClase("ClaseA");
        //el objeto anterior mantiene guardado el nombreClase gracias al Transactional que mantiene viva el proceso
        System.out.println("---------------------------------------");
        System.out.println("Los nombres de los alumnos de la " + listaDeAlumnos.getNombreClase() + " son:");

        //tambien por el Transactional ahora podemos ir a la lista de alumnos que se agrego automaticamente gracias a la conexion establecida en las columnas por medio de sus clases correspondientes
        for (Alumno iterar : listaDeAlumnos.getListaAlumnos()){
            System.out.println(iterar.getNombre());
        }
        System.out.println("---------------------------------------");

    }
}
