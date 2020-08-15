package com.javi.poo.registroAsistencias.model;
import com.javi.poo.registroAsistencias.exception.JaviException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Alumno extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public Alumno() {
    }
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