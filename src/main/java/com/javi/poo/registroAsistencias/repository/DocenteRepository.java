package com.javi.poo.registroAsistencias.repository;


import com.javi.poo.registroAsistencias.model.Docente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface DocenteRepository extends CrudRepository<Docente, Integer> {

    List<Docente> findByNombre(String nombre);

    Docente findById(int id);
}