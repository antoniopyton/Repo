package it.epicode.esercizio1;

public class Main {

    public static void main(String[] args) {
        Dipendente[] dipendenti = new Dipendente[3];
        Dipendente dipendente1 = new Dipendente("IT01", 1300.0, Dipartimento.VENDITE);
        dipendenti[0] = dipendente1;


        Dipendente dipendente2 = new Dipendente("IT02", 1700.0, Dipartimento.AMMINISTRAZIONE);
        dipendenti[1] = dipendente2;


        Dipendente dipendente3 = new Dipendente("IT03", 1500.0, Dipartimento.PRODUZIONE);
        dipendenti[2] = dipendente3;

        for (Dipendente dipendente:dipendenti) {
            System.out.println("Dipendente " + dipendente.getMatricola());
//            System.out.println("Dipendente " + dipendente.getStipendio());
//            System.out.println("Dipendente " + dipendente.getDipartimento());
        }
    }
}
