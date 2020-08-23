package com.javi.poo.registroAsistencias.model;

import javax.persistence.*;

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