package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.model.Docente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //comando para llevar a cabo pruebas que contienen contexto de Spring
public class DocenteServiceTest {

    @Autowired
    DocenteService docenteService;

    @Test
    public void testSearchOfDocente(){
        List<Docente> listaDocente = docenteService.busquedaDeDocenteMedianteNombre("Carto");
        System.out.println("---------------------------------------");
        System.out.println("Resultado de la busqueda del docente con nombre Carto:");

        for(Docente docente : listaDocente){
            System.out.println(docente.getNombre());
        }

        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
    }
}
