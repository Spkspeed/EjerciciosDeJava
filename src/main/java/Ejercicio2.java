import java.util.Scanner;

/*
1.- Una clase nunca debe pisar el nombre de un objeto existente por ejemploe si usas Scanner no llames a tu clase Scanner
2. javac registrar java en el path de las variables de windows.
3. siempre pensar en un programa con el menor codigo posible y probarlo por partes (TDD).
4. Los metodos comprimen codigos para volver a utilizar de forma mas rapida.
5. utilizar mas metodos para evitar usar mas de 100 lineas en un metodo.
 */
public class Ejercicio2 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String nombre = "";
        int numUno = 0, numDos = 0, resultado = 0, operacion = 0;

        System.out.println("¿Cual es tu nombre?");
        nombre = in.nextLine();

        System.out.println("Hola " + nombre + ", ingrese el codigo de la operacion que desea realizar");
        operacion = in.nextInt();

        System.out.println("Deme el primer valor para su operacion");
        numUno = in.nextInt();

        System.out.println("Deme el segundo valor para su operacion");
        numDos = in.nextInt();

        if (operacion == 1) {
            resultado = suma(numUno, numDos);
            System.out.println("Hola " + nombre + ", el resultado de tu operacion es: " + resultado);
        } else if (operacion == 2) {
            resultado = resta(numUno, numDos);
            System.out.println("Hola " + nombre + ", el resultado de tu operacion es: " + resultado);
        } else if (operacion == 3) {
            resultado = multiplicacion(numUno, numDos);
            System.out.println("Hola " + nombre + ", el resultado de tu operacion es: " + resultado);
        } else if (operacion == 4) {
            resultado = (int) division(numUno, numDos);
            System.out.println("Hola " + nombre + ", el resultado de tu operacion es: " + resultado);
        } else {
            System.out.println("Error, " + nombre + ", los codigos para realizar alguna operacion solo pueden ser: 1, 2, 3 y 4.");
        }

    }

    public static int suma(int numero1, int numero2) {
        int resultado = numero1 + numero2;
        return resultado;
    }

    public static int resta(int numero1, int numero2) {
        int resultado = numero1 - numero2;
        return resultado;
    }

    public static int multiplicacion(int numero1, int numero2) {
        int resultado = numero1 * numero2;
        return resultado;
    }

    public static double division(double numero1, double numero2) {
        return numero1 / numero2;
    }
}
