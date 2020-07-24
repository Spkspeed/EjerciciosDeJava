package com.javi.Files;

import com.javi.poo.registroAsistencias.exception.JaviException;
import file.AlumnoInformation;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorDeFichero {
    protected List Leer() throws JaviException {

        FileReader entrada = null;
        int paseUno = 0;
        int aumentar = 0;
        String confirmacion = "";
        int contador = 0;
        List contenedorAlumnos = new ArrayList();
       
        String nombre = "", apellido = "", nacionalidad = "", clase = "", preceptor = "";
        int edad = 0;

        try {
            entrada = new FileReader("C:\\Users\\ADMIN\\Documents\\javaimport3\\EjerciciosDeJava\\src\\test\\resources\\ClasesModel.data");
            int currentCharacter = 0;
            
            while (currentCharacter != -1) {
                String acumulacion = "";
                while (paseUno == 0) {
                    currentCharacter = entrada.read();
                    char variable = (char) currentCharacter;
                    acumulacion += variable;
                    if(currentCharacter == -1){
                        paseUno = 1;
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
                                clase = confirmacion;
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
                            case 6:
                                preceptor = confirmacion;
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
                        
                        AlumnoInformation alumno = new AlumnoInformation(nombre, apellido, edad, nacionalidad);
                        
                        alumno.setNombre(nombre);
                        alumno.setApellido(apellido);
                        alumno.setEdad(edad);
                        alumno.setNacionalidad(nacionalidad);
                        
                        contenedorAlumnos.add(alumno);
                           
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