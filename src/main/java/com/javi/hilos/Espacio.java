package com.javi.hilos;

public class Espacio extends Thread{

        @Override
        public void run(){
            for(int i = 0; i <= 5; i++){
                System.out.println(" ");

                try {
                    Espacio.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("Error en el hilo espacio " + e);

                }
            }

        }
}
