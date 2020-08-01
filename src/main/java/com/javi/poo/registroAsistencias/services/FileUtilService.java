package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileUtilService {

    /*
    Accedes al archivo
    1.- El metodo ideal para leer un archivo es secuencialmente, no leerlo completo de una vez
    2.- A medida que obtenemos una secuencia, la procesamos y luego pasamos a la siguiente secuencia
    3.- Una vez leidas todas las secuencias se procede a cerrar el archivo.
    4.- Y lees todo el contenido y creas una lista de alumnos
    5.- Obtener lista de alumnos
    6.- Crear un metodo que obtenga todos los alumnos por Clase
    */
    protected Map parseFileAlumnos(Resource resource) throws JaviException, IOException {
        String sentenceBuffer;
        //tipo de atributo utilizado para llevar a cabo el FileReader

        Map listaClases = new HashMap();
        //try-cath necesario para atrapar la exception del FileReader
        try {
            InputStream input = resource.getInputStream();
            InputStreamReader isReader = new InputStreamReader(input, "UTF-8");
            //Tipo de objeto utilizado para leer texto una linea a la vez
            BufferedReader br = new BufferedReader(isReader);

            //Condicion de que la oracion obtenida existe
            while ((sentenceBuffer = br.readLine()) != null) {
                //enviamos la oracion a un metodo, la cual, la procesa y termnina devolviendo un objeto Alumno
                Alumno alumno = parsearArchivoAlumnos(sentenceBuffer);
                
                //un if que confirma si existe un mapa cuya clave es el String del nombre de la clase que se 
                if (listaClases.get(alumno.getNombreClase()) != null) {
                    //Si existe, se crea una lista
                    //Se agarra el valor de la clase obtenida para ponerlo en la lista
                    List alumnosList = (ArrayList)listaClases.get(alumno.getNombreClase());
                    //modificamos el valor agregando el objeto alumno
                    alumnosList.add(alumno);
                } else {
                    //si no existe, se crea una lista
                    List listaAlumnos = new ArrayList();
                    //se agrega al objeto alumno creado a la lista
                    listaAlumnos.add(alumno);
                    //Se establece un mapa
                    //Usando como clave el nombre de la clase actualmente registrada en alumno
                    //Colocando como valor a la lista de alumnos
                    listaClases.put(alumno.getNombreClase(), listaAlumnos);
                }
            }
            //necesario para dejar de utilizar los archivos llamados en todo el proceso
            br.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return listaClases;
    }
     /*
        String - no apto para concatenacion "a" + "d" = "ad" INEFICIENTE
        StringBuilder - apto para concatenar letras EFICIENTE
        StringBuffer - apto para concatenar letras EFICIENTE pero es synchronized
     */ 
    protected Alumno parsearArchivoAlumnos(String sentenceBuffer) throws JaviException {
        String oracion = sentenceBuffer;
        int contador = 0;
        int valor = 0;
        Integer edad = 0;
        String nombre = "", apellido = "", nacionalidad = "", clase = "", preceptor = "";
        
        //for utilizado para recorrer toda la oracion
        for (int i = 0; i <= (oracion.length() - 1); i++) {
            //si el valor obtenido es igual a una coma o a un punto
            if (oracion.charAt(i) == ',' || oracion.charAt(i) == '.') {
                //se crea un String vacio cada vez que se repite este caso
                String palabra = "";
                //substring que logra capturar la palabra anterior a la coma o punto con la ayuda del atributo contador
                palabra = oracion.substring((i - contador), (i));
                //una vez obtenida la palabra el contador regresa al valor cero para que vuelva a contar los siguientes valores
                contador = 0;
                //incremento utilizado para decidir el caso del switch
                valor++;
                //incremento cuya funcion es evitar guardar la coma o el punto, pero su ausencia podria desatar errores
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
            //incremento utilizado para contar la cantidad de caracteres que tuvo la palabra anterior a la coma o punto
            contador++;
        }
        //se crea un objeto Alumno y se le aplica sus caracteristicas
        Alumno alumno = new Alumno(clase, nombre, apellido, nacionalidad, edad);
        alumno.setNombreClase(clase);
        Clase nombreClase = new Clase();
        nombreClase.setNombreClase(nombre);
        return alumno;
    }
}