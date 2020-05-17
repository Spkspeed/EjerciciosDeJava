public class Ciclos{
    public static void main(String args []){
        System.out.println("HOLA MUNDO");

        int i = 1;
        int j = 99;

        System.out.println("");

        System.out.println("Se realizaran las siguiente0 secuencia de numeros: 1,99,2,98,3,97,4,96,5,95 utilizando diferentes metodos.");
        System.out.println(" ");
        System.out.println("Serie con for: ");

        for(i = 1; i <= 5; i++){
            if(i < 5){
                System.out.print(i + ",");
                System.out.print(j + ",");
                j--;
            } else {
                System.out.print(i + ",");
                System.out.print(j);
            }
        }

        i = 1;
        j = 99;

        System.out.println("");
        System.out.println("Serie con While: ");

        while(i <= 5){
            if(i < 5) {
                System.out.print(i + ",");
                System.out.print(j + ",");
            } else {
                System.out.print(i + ",");
                System.out.print(j);
            }
            i++;
            j--;
        }
        i = 1;
        j = 99;

        System.out.println("");
        System.out.println("Serie con do-while: ");

        do{
            if(i < 5){
                System.out.print(i + ",");
                System.out.print(j + ",");
            } else {
                System.out.print(i + ",");
                System.out.print(j);
            }
            i++;
            j--;
        }while(i <= 5);
    }
}