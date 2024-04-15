package it.epicode;

import java.util.Scanner;

public class Esercizio2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        String stringa = scan.nextLine();
        System.out.println("Inserisci una stringa");
        String stringa2 = scan.nextLine();
        System.out.println("Inserisci una stringa");
        String stringa3 = scan.nextLine();
        String esercizio2 = concatena(stringa, stringa2 , stringa3 );
        System.out.println("La concatenazione che ne viene è: " + esercizio2);
        //
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Inserisci una stringa");
//        String stringa = scan.nextLine();
//        System.out.println("Inserisci una stringa");
//        String stringa2 = scan.nextLine();
//        System.out.println("Inserisci una stringa");
//        String stringa3 = scan.nextLine();
//        String esercizio2 = concatena(stringa, stringa2 , stringa3 );
//        System.out.println("La concatenazione che ne viene è: " + esercizio2);

    }

    public static String concatena(String stringa, String stringa2, String stringa3) {
        return stringa + stringa2 + stringa3;
    }
}
