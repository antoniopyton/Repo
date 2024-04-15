package it.epicode;

import java.util.Arrays;
import java.util.Scanner;

public class Operatori {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il primo numero per la tua moltiplicazione");
        int num1 = scan.nextInt();
        System.out.println("Inserisci il secondo numero per la tua moltiplicazione");
        int num2 = scan.nextInt();
        int risultato = moltiplica(num1, num2);
        System.out.println("Il risultato è " + risultato);

        scan.nextLine();

        System.out.println("Scrivi una frase: ");
        String stringa = scan.nextLine();
        System.out.println("Scrivi un numero intero: ");
        int num4 = scan.nextInt();
        String risultato2 = Concatena(stringa, num4);
        System.out.println("Risultato: " + risultato2);

        String[] nuovoArray = inserisciInArray(new String[]{"ciao1", "ciao2", "ciao3", "ciao4", "ciao5"}, "stringa 3");
        System.out.println(Arrays.toString(nuovoArray));
    }

    public static int moltiplica (int num1, int num) {
        int num3 = num1 * num;
        return (num3);
    }

    public static String Concatena (String stringa, int num) {
        return stringa+num;
    }

    public static String[] inserisciInArray(String[] array, String stringa) {
        String[] arrayNew = new String[]{array[0], array[1], stringa, array[2], array[3], array[4]};
        return arrayNew;
    }

}
