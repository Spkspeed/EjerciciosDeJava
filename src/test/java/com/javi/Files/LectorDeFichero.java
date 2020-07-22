package com.javi.Files;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorDeFichero {
    protected List Leer() throws JaviException {

        FileReader entrada = null;
        int A2 = 0;
        int aumentar = 0;
        String confirmacion = "";
        int contador = 0;
        
        List contenedorAlumnos = new ArrayList();
        Clase clase1 = new Clase();
        
        int incrementador = 0;
        String nombre = "", apellido = "", nacionalidad = "";
        int edad = 0;

        try {
            entrada = new FileReader("C:\\Users\\ADMIN\\Documents\\javaimport3\\EjerciciosDeJava\\src\\test\\resources\\ClasesModel.data");
            int currentCharacter = 0;
            Alumno alumno = new Alumno();

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
                        switch (contador) {
                            case 1:
                                String clase = confirmacion;
                                break;
                            case 2:
                                nombre = confirmacion;
                                break;
                            case 3:
                                apellido = confirmacion;
                                break;
                            case 4:
                                edad = Integer.parseInt(confirmacion);
                                break;
                            case 5:
                                nacionalidad = confirmacion;
                                break;
                            default:
                                break;
                        }
                        aumentar = -1;
                    }
                    if(acumulacion.charAt(i) == '.'){
                        contador = 0;
                        i++;
                        i++;
                        
                        alumno.setNombre(nombre);
                        alumno.setApellido(apellido);
                        alumno.setNacionalidad(nacionalidad);
                        
                        Alumno alumno1 = new Alumno(nombre, apellido, nacionalidad);
                        contenedorAlumnos.add(alumno1);
                    }
                    aumentar++;
                }
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return contenedorAlumnos;
    }
}