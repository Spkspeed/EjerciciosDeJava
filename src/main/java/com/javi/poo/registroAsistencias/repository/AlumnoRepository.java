package com.javi.poo.registroAsistencias.repository;

import com.javi.poo.registroAsistencias.model.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Clase que lleva a cabo la importacio de informacion solicitada para alojarla de la forma que deseemos
//debe ser establecida como una interfaz ya que no se llevan a cabo procesos con codigo y tambien es utilizada como marca para el Spring
//se extiende de un reopositorio interno y exige que de que clase sacar la informacion y de que tipo de atributo es el ID
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

    //decidimos en como alojar la informacion
    //decidimos en base a que buscar la informacion
    List<Alumno> findByNombre(String nombre);

    //decidimos cuantos en base a cuantos valores traer la informacion y definimos de que tipo son
    //el intger edad proviene de "alumno" que lo saca de "persona"
    List<Alumno> findByNombreAndEdad(String nombre, Integer edad);

    //otra forma de buscar la informacion
    Alumno findById(int id);
}