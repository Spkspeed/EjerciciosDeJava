package com.javi.poo.registroAsistencias.services;


import com.javi.poo.registroAsistencias.model.Preceptor;
import com.javi.poo.registroAsistencias.repository.PreceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreceptorService {

    @Autowired
    PreceptorRepository preceptorRepository;

    public List busquedaDePreceptorMedianteNombreYApellido(String nombre, String apellido) {
        List<Preceptor> preceptores = preceptorRepository.findByNombreAndApellido(nombre,apellido);
        return  preceptores;
    }
}
