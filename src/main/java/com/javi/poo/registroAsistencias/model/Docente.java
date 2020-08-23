package com.javi.poo.registroAsistencias.model;

import com.javi.poo.registroAsistencias.exception.JaviException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Docente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    
    @ManyToOne
    @JoinColumn(name = "clase_id")
    public Clase clase;

    public Docente(){
    }

    public Docente(String nombre, String apellido, String nacionalidad) throws JaviException { // obliga a que ingrese un nombre y appellido.
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNacionalidad(nacionalidad);
        
        if (nombre.length() >= 10) {
                throw new JaviException("el nombre del docente supera los 10 caracteres permitidos");
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
