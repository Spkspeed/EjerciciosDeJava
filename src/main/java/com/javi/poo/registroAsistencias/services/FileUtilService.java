package com.javi.poo.registroAsistencias.services;

import com.javi.poo.registroAsistencias.exception.JaviException;
import com.javi.poo.registroAsistencias.model.Alumno;
import com.javi.poo.registroAsistencias.model.Clase;
import com.javi.poo.registroAsistencias.model.Preceptor;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    protected Map parsearFilePreceptorOrAlumnos(Resource resource, String nombreArchivo) throws JaviException {
        Map mapaDeClases = new HashMap();
        String sentenceBuffer;
        //try-cath necesario para atrapar la exception del FileReader
        try {
            InputStream input = resource.getInputStream();
            InputStreamReader isReader = new InputStreamReader(input, "UTF-8");
            //Tipo de objeto utilizado para leer texto una linea a la vez
            BufferedReader br = new BufferedReader(isReader);
            if (nombreArchivo.equals("PreceptorModel.data")) {
                //Condicion de que la oracion obtenida existe
                while ((sentenceBuffer = br.readLine()) != null) {
                    //enviamos la oracion a un metodo, la cual, la procesa y termnina devolviendo un objeto Alumno
                    Clase clase = parsearArchivoAlumnosOrPreceptores(sentenceBuffer, nombreArchivo);
                    mapaDeClases.put(clase.getNombreClase(), clase);
                }
            } else if (nombreArchivo.equals("ClasesModel.data")) {
                while ((sentenceBuffer = br.readLine()) != null) {
                    //enviamos la oracion a un metodo, la cual, la procesa y termnina devolviendo un objeto Alumno
                    Clase claseResult = parsearArchivoAlumnosOrPreceptores(sentenceBuffer, nombreArchivo);
                    //un if que confirma si existe un mapa cuya clave es el String del nombre de la clase que se 
                    if (mapaDeClases.get(claseResult.getNombreClase()) != null){
                        //llamamos al mapa establecido  en el caso de que la clase no existiera
                        Clase claseConAlumno = (Clase) mapaDeClases.get(claseResult.getNombreClase());
                        //creamos una lista donde guardaremos el siguiente resultado
                        List<Alumno> newList =
                                //utilizamos la herramienta Stream con el objetivo de juntar el contenido de dos listas
                                Stream.concat(claseConAlumno.getListaAlumnos().stream(),
                                        //luego de colocar la otra lista, usamos la herramienta collect para finalizar el objetivo
                                        //tambien se destaca que en el ultimo parentesis establecemos en que tipo de resultado terminara
                                        claseResult.getListaAlumnos().stream()).collect(Collectors.toList());
                        //agregamos la lista que creamos para guardar la fusion de listas a la lista de Clase usando el objeto clase
                        claseConAlumno.setListaAlumnos(newList);
                        //sobreponemos el mapa existente con el objeto enlzado a la nueva lista de alumnos.
                        mapaDeClases.put(claseResult.getNombreClase(), claseConAlumno);
                    } else {
                        //creamos un objeto clase con el cual metemos a la misma lista de alumnos de Clase al alumno actual
                        Clase claseConAlumnos = new Clase(claseResult.getNombreClase());
                        //este mismo objeto esta enlazado con la lista de alumnos que por ahora solo guarda 1 alumno 
                        claseConAlumnos.setListaAlumnos(claseResult.getListaAlumnos());
                        //como contraseña del mapa usamos el nombre del a clase, el cual obtenemos utilizando el objeto clase que trajimos
                        mapaDeClases.put(claseResult.getNombreClase(), claseConAlumnos);
                    }
                }
            }
            //necesario para dejar de utilizar los archivos llamados en todo el proceso
            br.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return mapaDeClases;
    }

    /*
       String - no apto para concatenacion "a" + "d" = "ad" INEFICIENTE
       StringBuilder - apto para concatenar letras EFICIENTE
       StringBuffer - apto para concatenar letras EFICIENTE pero es synchronized
     */
    protected Clase parsearArchivoAlumnosOrPreceptores(String sentenceBuffer, String nombreArchivo) throws JaviException {
        String oracion = sentenceBuffer;
        int contador = 0;
        int valor = 0;
        Integer edad = 0;
        String nombre = "", apellido = "", nacionalidad = "", nombreClase = "", preceptor = "";
        Clase clase = new Clase();
        //for utilizado para recorrer toda la oracion
        for (int i = 0; i <= (oracion.length() - 1); i++) {
            //si el valor obtenido es igual a una coma o a un punto
            if (oracion.charAt(i) == ',' || oracion.charAt(i) == '.') {
                //se crea un String vacio cada vez que se repite este caso
                String palabra;
                //substring que logra capturar la palabra anterior a la coma o punto con la ayuda del atributo contador
                palabra = oracion.substring((i - contador), (i));
                //una vez obtenida la palabra el contador regresa al valor cero para que vuelva a contar los siguientes valores
                contador = 0;
                //incremento utilizado para decidir el caso del switch
                valor++;
                //incremento cuya funcion es evitar guardar la coma o el punto, pero su ausencia podria desatar errores
                i++;
                if (nombreArchivo.equals("ClasesModel.data")) {
                    switch (valor) {
                        case 1:
                            nombreClase = palabra;
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
                } else if (nombreArchivo.equals("PreceptorModel.data")) {
                    switch (valor) {
                        case 1:
                            nombreClase = palabra;
                            break;
                        case 2:
                            nombre = palabra;
                            break;
                        case 3:
                            apellido = palabra;
                            break;
                        case 4:
                            nacionalidad = palabra;
                            break;
                        default:
                            break;
                    }
                }
            }
            contador++;
        }
        if (nombreArchivo.equals("ClasesModel.data")) {
            Alumno datosDelAlumno = new Alumno(nombreClase, nombre, apellido, nacionalidad, edad);
            Clase informacionDelAlumnoContenida = new Clase(nombreClase);
            informacionDelAlumnoContenida.setListaAlumnos(new ArrayList<>());
            //utilizamos el objeto clase para llamar a la lista de alumnos existente en Clase
            //luego le agregamos el alumno en este mismo momento
            informacionDelAlumnoContenida.getListaAlumnos().add(datosDelAlumno);
            clase = informacionDelAlumnoContenida;
        } else if (nombreArchivo.equals("PreceptorModel.data")) {
            Preceptor datosDelPreceptor = new Preceptor(nombre, apellido, nacionalidad);
            Clase claseConPreceptor = new Clase(nombreClase);
            claseConPreceptor.setPreceptor(datosDelPreceptor);
            clase = claseConPreceptor;
        }
        return clase;
    }
}