package it.epicode.esercizio4;

import java.util.Scanner;

public class esercizio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero intero:");
        int i;

        for (i = scanner.nextInt(); i >= 0; i--) {
            System.out.println(i);
        }

        scanner.close();
    }

}
