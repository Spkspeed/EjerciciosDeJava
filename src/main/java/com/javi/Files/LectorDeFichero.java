package com.javi.Files;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeFichero {
    public void Leer(String fileUbication) throws JaviException {

        FileReader entrada = null;
        int A2 = 0;
        int aumentar = 0;
        String confirmacion = "";
        int contador = 0;

        try {
            entrada = new FileReader(fileUbication);
            int currentCharacter = 0;
            Alumno alumno = new Alumno();
            Clase clase = new Clase();

            while (currentCharacter != -1) {
                String acumulacion = "";
                while (A2 == 0) {
                    currentCharacter = entrada.read();
                    char variable = (char) currentCharacter;
                    acumulacion += variable;
                    if(currentCharacter == -1){
                        A2 = 1;
                    }
                }
                char palabra[] = new char[acumulacion.length()];

                for(int i = 0; i <= (acumulacion.length() - 1); i++){
                    palabra [aumentar] = acumulacion.charAt(i);

                    if(acumulacion.charAt(i) == ',' || acumulacion.charAt(i) == '.'){
                        confirmacion = acumulacion.substring((i - aumentar), (i));
                        contador++;
                        if(contador == 1){
                            clase.setNombreClase(confirmacion);
                        }else if(contador == 2){
                            alumno.setNombre(confirmacion);
                        } else if(contador == 3){
                            alumno.setApellido(confirmacion);
                        } else if(contador == 4){
                            alumno.setEdad(Integer.parseInt(confirmacion));
                        } else if (contador == 5){
                            alumno.setNacionalidad(confirmacion);
                        }
                        aumentar = -1;
                    }
                    if(acumulacion.charAt(i) == '.'){
                        contador = 0;
                        System.out.println(" ");
                        alumno.imprimirAlumno(clase.getNombreClase());
                    }
                    aumentar++;
                }
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
    
}
