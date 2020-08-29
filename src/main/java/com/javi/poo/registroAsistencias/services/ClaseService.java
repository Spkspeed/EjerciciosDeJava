package com.javi.poo.registroAsistencias.services;


import com.javi.poo.registroAsistencias.model.Clase;
import com.javi.poo.registroAsistencias.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaseService {

    @Autowired
    ClaseRepository claseRepository;

    public Clase obtenerNombresDeLosAlumnosDeUnaClaseSegunElNombreClase(String nombreClase){
        Clase clase = claseRepository.findByNombreClase(nombreClase);
        return clase;
    }
}