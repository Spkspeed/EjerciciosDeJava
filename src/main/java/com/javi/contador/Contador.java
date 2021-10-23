package com.javi.contador;

public class Contador {
    String[] letras = {"A","B","C","D","F","G","H","I","J"};
    String cadena = "ABCDEFGHIJKLMNÑOPQWTRSYXZ";
    int posicionActual = 0;
    int[] camino = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int variable = 13;
    int posicionAnterior = 0;
    int resultado = 0;

    public void contadorCaracteres (String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            posicionActual =posicionAnterior;
            for (int y = 0; y < cadena.length(); y++){
                if (palabra.charAt(i) == cadena.charAt(y)){
                    //confirmar si te da el indice exacto de cada letra
                    posicionActual = y;

                    if (posicionActual >12){
                        posicionActual = variable;
                    }
                    System.out.println(posicionActual);
                    System.out.println(posicionActual - posicionAnterior);
                    posicionAnterior = posicionActual;
                    break;
                }
                posicionActual++;
                if (posicionActual >12){
                    variable--;
                }
            }
        }
    }
}
