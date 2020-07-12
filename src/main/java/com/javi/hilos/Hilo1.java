package com.javi.hilos;

/*
    El metodo holaMundo al ser un metodo normal, se obtiene una copia por cada instancia creada
    static: Hace que un metodo no pueda ser copiado en una instancia nueva y obliga a ser usado por todos los hilos
            Cuando un metodo no es estatico y su clase es instanciada
    hilo1
    hilo2 Todos tiene una copia propia del metodo holaMundo
    hilo3
    hilo4

        Cuando u metodo es estatico y su clase es instanciada
    hilo1
    hilo2 Todas las instancias apuntan al metodo estatico HolaMundo, por lo tanto comparten un mismo recurso
    hilo3
    hilo4

    Hilo1 con todos sus metodos
        Pero cuando creas una instancia

   Excepciones:
        Exception -> Que es del tipo chequeado
 */
public class Hilo1 extends Thread {

    public Hilo1(String nombreHilo) {
        super(nombreHilo);
    }

    @Override
    public void run() {
        holaMundo(this.getName());
    }

    /*
        Synchronized: se lo utiliza para aquellos procesos que requieren un manejo controlado de hilos entrando por cola
        como consecuencia esto reduce la eficiencia del proceso

     */
    private static synchronized void holaMundo(String nroThread) {
        System.out.println("Hola soy el hilo " + nroThread);
        // throw new Exception("Error se pudrio todo");
        // Exception chequeada

        //throw new RuntimeException("Error se pudrio todo");
    }

    // exception no chequeada no requiere solucion inmediata
    public void cathastrophe() {
        System.out.println("magnifico");
        throw new RuntimeException("Desgracias inevitables");
    }

    // exception chequeada te obliga a llevar a cabo una solucion (try-catch, throws)
    public void revolucion() {
        System.out.println("evidentemente");
        try {
            throw new Exception("Intentalo y atrapalo");
        } catch (Exception e) {
            System.out.println(e + "atrapado");
        }
    }
}