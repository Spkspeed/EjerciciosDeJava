/*
para comparar caracteres hay que tener en cuenta que son de tipo char y no se tienen que utilizar doble comillas (""), lo correcto es ('')
 */

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String args[]){
        String oracion = "", palabra = "";
        int num_caracteres = 0, incrementador = 0, b = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escriba una oracion: ");
        oracion = entrada.nextLine();

        num_caracteres = oracion.length();

            char palabraInversa[] = new char[oracion.length()];

            for (int i = 0; i <= (num_caracteres - 1); i++) {
                palabraInversa[incrementador] = oracion.charAt(i);
                if (oracion.charAt(i) == ' ') {
                    i++;

                }
                incrementador++;
            }
    }
}