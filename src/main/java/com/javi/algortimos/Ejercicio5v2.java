package com.javi.algortimos;

public class Ejercicio5v2 {


    public boolean esPalindromo(String palabra) {
        int incrementador = 0;

        char palabraInversa[] = new char[palabra.length()];

        for (int i = (palabra.length() - 1); i >= 0; i--) {
            palabraInversa[incrementador] = palabra.charAt(i);
            incrementador++;
        }

        String resultado = new String(palabraInversa);
        System.out.println("El resultado es : " + resultado);

        if (palabra.equals(resultado)) {
            System.out.println("La palabra es palindromo.");
            return true;
        } else {
            System.out.println("La palabra no es palindromo.");
            return false;
        }

    }
}