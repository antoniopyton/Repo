package it.epicode.esercizio2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ExceptionPer0{
        Scanner scanner = new Scanner(System.in);
        double kmFatti;
        double carburanteConsumato;
        double kmLitro;

            try {
                System.out.println("Inserisci i km percorsi");
                kmFatti = scanner.nextInt();

                System.out.println("Inserisci i litri di carburante consumati");
                carburanteConsumato = scanner.nextInt();

                if (carburanteConsumato == 0) {
                    throw new ExceptionPer0("Non puoi aver consumato 0 litri");
                }
                kmLitro = kmFatti / carburanteConsumato;

                System.out.println("i km/litro sono " + kmLitro);

            }catch (ExceptionPer0 e){
            System.out.println(e.getMessage());
        }
    }

}
