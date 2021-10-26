package com.javi.contador;

public class Contador {
    String abecedario = "ABCDEFGHIJKLMNÑOPQWTRSYXZ";
    int posicionActual = 0;
    int posicionAnterior = 0;


    public void contadorCaracteres (String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            for (int y = 0; y < abecedario.length(); y++){

                if (palabra.charAt(i) == abecedario.charAt(y)){
                    System.out.println("-------la posicion anterior es: " + posicionAnterior);
                    System.out.println("-------la posicion actual es: " + posicionActual);

                    int distanciaEntreVariables = posicionActual - posicionAnterior;

                    //si el resultado es negativo lo transformo a positivo
                    if (distanciaEntreVariables < 0){
                        distanciaEntreVariables = -distanciaEntreVariables;
                    }
                    if (distanciaEntreVariables > 12){
                        System.out.println("la distancia entre variables es mayor a 12, se debe tomar el otro camino.");
                        distanciaEntreVariables = 25 - distanciaEntreVariables;
                        System.out.println("distancia corregida: " + distanciaEntreVariables);

                    } else {
                        System.out.println("distancia: " + distanciaEntreVariables);
                    }
                    posicionAnterior = posicionActual;
                    posicionActual = 0;
                    break;
                } else{
                    posicionActual++;
                }
            }
        }
    }
}
