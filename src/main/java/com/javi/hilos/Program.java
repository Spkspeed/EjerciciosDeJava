package com.javi.hilos;

public class Program {
    public static void main(String args[]) throws InterruptedException {

        Hilo1 hilo1 = new Hilo1("Hilo 1");
        Hilo1 hilo2 = new Hilo1("Hilo 2");
        Hilo1 hilo3 = new Hilo1("Hilo 3");
        Hilo1 hilo4 = new Hilo1("Hilo 4");
        Espacio espacio = new Espacio();



        //hilo1 excepcion chequeada
        hilo1.start();
        try {
            hilo1.sleep(200);
        } catch (InterruptedException e) {

            System.out.println("Error en el hilo 1" + e);
        }

        //hilo2 excepcion chequeada
        hilo2.start();

        hilo2.sleep(240);

        //hilo3 excepcion chequeada
        hilo3.start();

        hilo3.sleep(260);

        //hilo4 excepcion chequeada
        hilo4.start();
        hilo4.sleep(280);

        espacio.start();

        hilo1.cathastrophe();

        hilo1.revolucion();

    }

}
