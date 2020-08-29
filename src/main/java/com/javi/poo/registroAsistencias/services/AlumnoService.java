package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import com.javi.poo.registroAsistencias.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    /*
        1.- Cuando manejamos un map con multiples contadores, debemos buscar una iniciativa de incrementadores que se ajusten a un numero N de nacionalidades
        2.- for(x;x;x) {} == for(item;Lista(item)):
        3.- ++ anteposicion y postposicion diferencias:
            ++incrementador: al incrementar un valor que al mismo tiempo se le ordena enviarse o devolverse asi mismo, podemos priorizar la realizacion de su incremento colocando los signos del lado izquierdo
            incrementador++: realiza la accion de aumentar el valor de un entero en 1
        4.- El value de un map puede ser usado como contador: cada key dentro de un map tiene su propio value, el cual, podemos modificar utilzando la key correcta y un incrementador.
     */

    public void nacionalidadesAlumno(Map contenedorLiberador) throws JaviException {
        List<Clase> listaClases = (List) contenedorLiberador.get("aulas");
        String nacionalidad;
        Map nacionalidades = new HashMap();
        int opcion = 1;
        for (Clase clase : listaClases) {
            System.out.println("Comenzando metodo de nacionalidades:" + opcion);
            opcion++;

            for (Alumno alumno : clase.getListaAlumnos()) {
                nacionalidad = alumno.getNacionalidad();
                Integer cantidadAlumnos = (Integer) nacionalidades.get(nacionalidad);
                if (cantidadAlumnos == null) {
                    System.out.println("La nacionalidad " + nacionalidad + " no existe, agregandolo...");
                    nacionalidades.put(nacionalidad, 1);
                } else {
                    System.out.println("La nacionalidad " + nacionalidad + " si existe, incrementado cantidad de alumnos...");
                    nacionalidades.put(nacionalidad, ++cantidadAlumnos);
                }
            }
        }
        System.out.println("La cantidad de alumnas entre las distintas nacionalidades es la siguiente: " + nacionalidades);
    }

    public void getNacionalidadesDistintas(Map contenedorLiberador) throws JaviException {
        // Set -> HashSet() no permite valores duplicados.
        Set<String> cantidad = new HashSet();
        List<Clase> listaClases = (List) contenedorLiberador.get("aulas");

        for (Clase clase : listaClases) {
            for (Alumno alumno : clase.getListaAlumnos()) {
                cantidad.add(alumno.getNacionalidad());
            }
        }
        System.out.println(cantidad);
    }

    public List busquedaDeAlumnoMedianteNombre(String nombre){
        //utilizamos el metodo que establecimos en el repositorio
        List<Alumno> result = alumnoRepository.findByNombre(nombre);
        return result;
    }
}