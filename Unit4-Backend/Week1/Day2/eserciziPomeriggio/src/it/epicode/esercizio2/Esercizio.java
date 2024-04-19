package it.epicode.esercizio2;

import java.util.Scanner;

public class Esercizio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero intero");
        int n = scanner.nextInt();

        switch (n) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("due");
                break;
            case 3:
                System.out.println("tre");
                break;
            default:
                System.out.println("numero non accettato");
        }
    }





}
