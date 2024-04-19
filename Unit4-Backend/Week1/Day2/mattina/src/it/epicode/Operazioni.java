package it.epicode;

import javax.swing.*;
import java.util.Scanner;

public class Operazioni {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ecco un esercizio");
//        System.out.println("Inserisci la tua età");
//
//        int x = scanner.nextInt();
//
//        System.out.println("Antonio ha " + x + " anni");


//        System.out.println("Qual è il numero più grande?");
//        int prezzo = 0;
//
//        if(prezzo>10) {
//        }

//        System.out.println("Scegli un opzione tra 1 e 4");
//        int scelta = scanner.nextInt();
//
//        double costoBiglietto;
//
//        if (scelta == 1) {
//            System.out.println("biglietto gratuito");
//            costoBiglietto = 0;
//        } else if (scelta == 2) {
//            System.out.println("costo biglietto 8€");
//            costoBiglietto = 8;
//        } else if (scelta == 3) {
//            System.out.println("costo biglietto 10€");
//            costoBiglietto = 10;
//        } else if (scelta == 4) {
//            System.out.println("costo biglietto 15€");
//            costoBiglietto = 15;
//        } else {
//            System.out.println("Scelta errata");
//            return;
//        }
//
//        System.out.println("Inserisci l'età");
//        int età = scanner.nextInt();
//
//        if (età <= 18) {
//            costoBiglietto = costoBiglietto * 50 / 100;
//            System.out.println("Con lo sconto applicato, il prezzo del biglietto sarà di " + costoBiglietto);
//        }

        System.out.println("Inserisci il numero del mese");
        int mese = scanner.nextInt();

        switch (mese) {
            case 9,10,11,12:
                System.out.println("Primo trimestre");
            case 1,2,3,4,5,6:
                System.out.println("Secondo pentamestre");
            case 7,8:
                    System.out.println("Stagioni estive");
            default:
                System.out.println("Non esiste questo mese");
        }

    }

}
