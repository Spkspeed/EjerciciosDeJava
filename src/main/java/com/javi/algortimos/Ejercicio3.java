package com.javi.algortimos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
1. si utilizamos doble comilla ("") nos referimos a que estamos manejando un objeto de tipo String y al
    usar comillas ('') es para tipo char por ejemplo char a == ' '

2. Se utilizo split para resolver el problema aunque logramos una solucion ineficiente

3. Se empiezan a usar List, el mas recomendable es usar ArrayList

 */
public class Ejercicio3 {

    public static void main(String args[]) {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        String oracion = "";
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba los caracteres que desee ingresar: ");
        oracion = entrada.nextLine();
        List result = ejercicio3.splitSentence(oracion);
        System.out.println(result);

    }

    public List splitSentence(String oracion) {
        List palabrasCapturadas;

        palabrasCapturadas = Arrays.asList(oracion.split(" "));
        return palabrasCapturadas;
    }
}