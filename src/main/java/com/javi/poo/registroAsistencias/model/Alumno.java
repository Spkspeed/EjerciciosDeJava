package com.javi.poo.registroAsistencias.model;

import com.javi.poo.registroAsistencias.exception.JaviException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//Entity: marca utilizada para establecer una conexion con la interfaz del repositorio
@Entity
public class Alumno extends Persona {
    //comandos necesarios para establecer la conexion de la clase con la informacion del archivo en Recursos
    //en el archivo de Recursos ya esta establecida que la informacion declarada alli  utilizara al constructor alumno como base
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public Alumno() {
    }

    // Los constructores siempre deben ser publicos
    // Salvo que quieras implementar un patron de diseño que seria un SINGLETON
    public Alumno(String clase, String nombre, String apellido, String nacionalidad, Integer edad) throws JaviException { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);
        this.setEdad(edad);

        if (nombre.length() >= 10) {
            throw new JaviException("el nombre del alumno supera los 10 caracteres permitidos");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}