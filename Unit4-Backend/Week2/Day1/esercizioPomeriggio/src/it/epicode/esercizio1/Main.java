package it.epicode.esercizio1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[5];
        Random random = new Random();
        Scanner scanner= new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1,10);
            System.out.println(array[i]);
        }

        int numero = 0;
        int posizione;

        do {
            try {
                System.out.println("insrisci un numero da 1 a 10 oppure inserire 0 per uscire dal programma");
                numero = scanner.nextInt();
                if (numero != 0) {
                    System.out.println("in quale posizione vuoi inserire il numero? (1-5)");
                    posizione = scanner.nextInt();

                    if (posizione >= 1 && posizione <= 5) {
                        array[posizione - 1] = numero;
                        System.out.println("Numero inserito correttamente nella posizione " + posizione);
                        System.out.println(Arrays.toString(array));
                    } else {
                        System.out.println("posizione non valida");
                    }
                }
            } catch (Exception e){
                System.out.println("numero inserito non valido");
                scanner.next();
            }

            } while (numero!=0); {

        }

    }
}