package it.nextdevs.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero di elementi da inserire");

        Set elementi = new HashSet();
        Integer elementiN = 0;
        boolean continua = true;
        do {
            try {
                elementiN = scanner.nextInt();
                if (elementiN <= 0) {
                    throw new Exception();
                }
                continua = true;
            } catch (Exception e) {
                System.out.println("Devi inserire numeri interi e maggiori di 0");
                continua = false;
            }
        } while (!continua);
        scanner.nextLine();

        for (int i = 0; i < elementiN; i++) {
            System.out.println("Scrivi la parola chiave da aggiungere - slot " + (i+1));
            String parola = scanner.nextLine();
            if (elementi.add(parola)){
                System.out.println(parola);
            } else {
                System.out.println("Errore! Parola già esistente");
                i--;
            }

            System.out.println("Risultato " + elementi);

        }

    }

}
