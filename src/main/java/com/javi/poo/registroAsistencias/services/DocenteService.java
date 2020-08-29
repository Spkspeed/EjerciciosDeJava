package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.model.Docente;
import com.javi.poo.registroAsistencias.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//injeccion necesaria para la ejecucion de los servicios conectados a un repositorio (mas Spring)
@Service
public class DocenteService {

    @Autowired
    DocenteRepository docenteRepository;

    public List busquedaDeDocenteMedianteNombre(String nombre){
        List<Docente> docentes = docenteRepository.findByNombre(nombre);
        return docentes;
    }
}
