package com.javi.poo.registroAsistencias.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Preceptor extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public Preceptor(){
    }

    public Preceptor(String nombre, String apellido, String nacionalidad){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);
    }

    public Integer getId(){
        return id;
    }

    public void getId(Integer id){
        this.id = id;
    }

}