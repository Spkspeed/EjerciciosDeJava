package com.javi.poo.registroAsistencias.repository;

import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClaseRepository extends CrudRepository<Clase, Integer>  {

    //List<Alumno> findByListaAlumnos(List listaAlumnos);

    Clase findById(int id);
}