package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.model.Preceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest //comando para llevar a cabo pruebas que contienen contexto de Spring
public class PreceptorServiceTest {

    // "Autowired" comando para poder instanciar a la clase del repositorio
    @Autowired
    PreceptorService preceptorService;

    @Test
    public void testSearchPreceptor(){
        List<Preceptor> listaNombreDePreceptor = preceptorService.busquedaDePreceptorMedianteNombreYApellido("Robin","Hood");
        System.out.println("-----------------------------------------------------");
        System.out.println("Resultados de la busqueda del preceptor con nombre y apellido: ");

        for (Preceptor preceptor : listaNombreDePreceptor) {
            System.out.println(preceptor.getNombre() + " " + preceptor.getApellido());
        }
        System.out.println("-----------------------------------------------------");
    }
}
