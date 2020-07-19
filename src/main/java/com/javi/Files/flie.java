package com.javi.Files;

import com.javi.poo.registroAsistencias.model.Alumno;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class flie {
    public static void main(String args[]) {
        leer_Fichero inicio = new leer_Fichero();
        inicio.leer();
    }
}

class leer_Fichero {
    public void leer() {
        int incrementador = 1;
        FileReader entrada = null;
        int A1 = 0, A2 = 0, A3, A4, B1, B2, B3, B4;
        int num_caracteres = 0;
        int aumentar = 0;
        String confirmacion = "";
        
        try {
            entrada = new FileReader("C:\\Users\\recruz\\IdeaProjects\\EjerciciosDeJava\\src\\test\\resources\\ClasesModel.data");
            int c = 0;

            while (c != -1) {
                String acumulacion = "";
                while (A2 == 0) {
                    c = entrada.read();
                    char variable = (char) c;
                    acumulacion += variable;
                    
                    if (variable == '.') {
                        A2 = 1;
                    }
                }
                char palabra[] = new char[acumulacion.length()];
                for(int i = 0; i <= (acumulacion.length() - 1); i++){
                    palabra [aumentar] = acumulacion.charAt(i);
                    if(acumulacion.charAt(i) == ','){
                        confirmacion = acumulacion.substring((i - aumentar), i);
                        System.out.println(confirmacion);
                    }
                    aumentar++;
                }
                A2 = 0;
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
}
