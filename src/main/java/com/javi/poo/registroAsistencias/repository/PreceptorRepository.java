package com.javi.poo.registroAsistencias.repository;

import com.javi.poo.registroAsistencias.model.Preceptor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PreceptorRepository extends CrudRepository<Preceptor, Integer> {

    List<Preceptor> findByNombre(String nombre);

    List<Preceptor> findByNombreAndApellido(String nombre, String apellido);

    Preceptor findById(int id);
}