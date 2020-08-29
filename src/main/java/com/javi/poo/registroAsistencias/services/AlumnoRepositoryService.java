package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.repository.AlumnoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AlumnoRepositoryService {
    @Autowired
    AlumnoRepository alumnoRepository;
    public void BusquedaDeAlumnoMedianteNombre(String nombre){
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("AlumnoRepository");
         //utilizamos el metodo que establecimos en el repositorio
        List<Alumno> result = alumnoRepository.findByNombre(nombre);
        for(Alumno alumno : result){
            System.out.println(alumno.getNombre());
        }
    }
}
