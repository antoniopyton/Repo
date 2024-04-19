package it.epicode.esercizio1;

public class UsaRettangolo {

    public static void main(String[] args) {

        Rettangolo r1 = new Rettangolo(12, 8);
        Rettangolo r2 = new Rettangolo(5, 10);

        System.out.println("Il perimetro ottenuto per r1 è: " + r1.perimetro());

        System.out.println("L'area del rettangolo per r1 è: " + r1.area());

        System.out.println("Il perimetro ottenuto per r2 è: " + r2.perimetro());

        System.out.println("L'area del rettangolo per r2 è: " + r2.area());

        System.out.println("La somma dell'area e del perimetro sarà di: " + r1.sommaAreaePerimetro());

        System.out.println("La somma dell'area e del perimetro sarà di: " + r2.sommaAreaePerimetro());

    }
}
