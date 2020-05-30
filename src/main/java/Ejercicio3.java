import java.util.Scanner;

/*
1. si utilizamos doble comilla ("") nos referimos a que estamos manejando un objeto de tipo String y al
    usar comillas ('') es para tipo char por ejemplo char a == ' '
2.
3.

 */
public class Ejercicio3 {
    public static void main(String args[]) {
        String oracion = "";
        int num_caracteres = 0;
        Scanner entrada = new Scanner(System.in);
        int incrementador = 0;

        System.out.println("Escriba los caracteres que desee ingresar: ");
        oracion = entrada.nextLine();

        num_caracteres = oracion.length();

        char palabraInversa[] = new char[oracion.length()];

        for (int i = 0; i <= (num_caracteres - 1); i++) {
            palabraInversa[incrementador] = oracion.charAt(i);
            if (oracion.charAt(i) == ' ') {
                i++;
                System.out.println(' ');

            }
            System.out.print(oracion.charAt(i));
        }
    }
}