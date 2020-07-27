package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtilService {

    /*
    Accedes al archivo
    1.- El metodo ideal para leer un archivo es secuencialmente no leerlo completo de una vez
    2.- A medida que obtenemos una secuencia, la procesamos y luego pasamos a la siguiente secuencia
    3.- Una vez leidas todas las secuencias se procede a cerrar el archivo.
    4.- Y lees todo el contenido y creas una lista de alumnos
    5.- Obtener lista de alumnos
    6.- Crear un metodo que obtenga todos los alumnos por Clase
 */
    protected Alumno parsearArchivoAlumnos(String sentenceBuffer) throws JaviException {
        String oracion = sentenceBuffer;
        int contador = 0;
        int valor = 0;
        Integer edad = 0;
        String nombre = "", apellido = "", nacionalidad = "", clase = "", preceptor = "";
        char irrelevante[] = new char[oracion.length()];
        for (int i = 0; i <= (oracion.length() - 1); i++) {
            irrelevante[contador] = oracion.charAt(i);
            if (oracion.charAt(i) == ',' || oracion.charAt(i) == '.') {
                String palabra = "";

                palabra = oracion.substring((i - contador), (i));
                valor++;
                contador = 0;
                i++;
                switch (valor) {
                    case 1:
                        clase = palabra;
                        break;
                    case 2:
                        nombre = palabra;
                        break;
                    case 3:
                        apellido = palabra;
                        break;
                    case 4:
                        edad = Integer.parseInt(palabra);
                        break;
                    case 5:
                        nacionalidad = palabra;
                        break;
                    case 6:
                        preceptor = palabra;
                        break;
                    default:
                        break;
                }
            }
            contador++;
        }
        Alumno alumno = new Alumno(clase, nombre, apellido, nacionalidad, edad);
        alumno.setNombreClase(clase);
        return alumno;
    }

    /*
        String - no apto para concatenacion "a" + "d" = "ad" INEFICIENTE
        StringBuilder - apto para concatenar letras EFICIENTE
        StringBuffer - apto para concatenar letras EFICIENTE pero es synchronized
     */
    protected Map parseFileAlumnos() throws JaviException {
        String sentenceBuffer;
        FileReader entrada;
        Map listaClases = new HashMap();
        try {
            entrada = new FileReader("C:\\Users\\recruz\\IdeaProjects\\EjerciciosDeJava\\src\\test\\resources\\ClasesModel.data");
            BufferedReader br = new BufferedReader(entrada);
            while ((sentenceBuffer = br.readLine()) != null) {
                Alumno alumno = parsearArchivoAlumnos(sentenceBuffer);
                if (listaClases.get(alumno.getNombreClase()) != null) {
                    List alumnosList = (ArrayList)listaClases.get(alumno.getNombreClase());
                    alumnosList.add(alumno);
                } else {
                    List listaAlumnos = new ArrayList();
                    listaAlumnos.add(alumno);
                    listaClases.put(alumno.getNombreClase(), listaAlumnos);
                }
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return listaClases;
    }
}