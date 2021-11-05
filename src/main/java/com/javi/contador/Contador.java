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

                    //Obtiene la distancia que existe entre la letra actual y la anterior
                    int distanciaEntreVariables = posicionActual - posicionAnterior; //si no se ejecutan alguno de los siguientes "if", este sera el resultado final que se muestre como distancia.

                    //if para cambiar el resultado negativo a positivo porque el valor de la posicion anterior puede ser aveces mayor que el valor del actual
                    if (distanciaEntreVariables < 0){
                        distanciaEntreVariables = -distanciaEntreVariables;
                    }
                    //para conocer el camino mas corto que se debe tomar para llegar de una letra a otra utilizamos este metodo
                    if (distanciaEntreVariables > 12){
                        System.out.println("la distancia entre variables es mayor a 12, se debe tomar el otro camino.");

                        //formula utilizada para obtener la cantidad de pasos necesarios para llegar a la letra actual.
                        distanciaEntreVariables = 25 - distanciaEntreVariables;
                        System.out.println("distancia corregida: " + distanciaEntreVariables);
                    } else {
                        System.out.println("distancia: " + distanciaEntreVariables);
                    }

                    posicionAnterior = posicionActual;

                    //para volverla a colocar en la posicion inicial
                    posicionActual = 0; //tal vez sea innecesaria y solo tengo que utilizar la variable "y"
                    //break para evitar que continue analizando las letras restantes del abcdario
                    break;
                } else{
                    posicionActual++;
                }
            }
        }
    }
}
