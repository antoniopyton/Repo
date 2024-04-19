package it.epicode.esercizio1;

import java.util.Scanner;

public class Esercizio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        String stringa = scanner.nextLine();
        System.out.println("il numero di caratteri è " + pariDispari(stringa));
    }

    public static String pariDispari (String stringa) {
        if (stringa.length() % 2 == 0) {
            return "pari";
        } else {
            return "dispari";
            }
        }
    }

//    public static boolean annnoBisestile(int Anno) {
//    if(anno%4000=0 || )
//    }

