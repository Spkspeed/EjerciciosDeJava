
import java.util.Scanner;
/*
1. El final del proceso debe terminar sin ningun error.
2. Pueden existir diferentes formas de ralizar la misma accion y presentar los mismos errores pero con diferente solucion.
3. Al no conocer una forma de llevar a cabo un proceso, realizar una busqueda de la clase de herramienta que hace falta.
 */
public class Ejercicio4{
    public static void main(String args[]){

        String oracion = "";
        int num_caracteres = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escriba los caracteres que desee ingresar: ");
        oracion = entrada.nextLine();

        num_caracteres = oracion.length();

        for(int i = (num_caracteres - 1); i >= 0; i--){
            System.out.println(oracion.charAt(i));
        }
    }
}

/*
 i = 0
 i == 0
 */