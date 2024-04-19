package it.epicode.esercizio3;

import java.util.Scanner;

public class esercizio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa");
        String string = scanner.nextLine();

        do {
            System.out.println("Inserisci un'altra stringa, Digita ':q' per uscire ");
            string = scanner.nextLine();
        }

        while (!string.equals(":q"));
        scanner.close();
        System.out.println("Applicazione chiusa");
    }

}
