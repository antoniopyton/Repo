package it.epicode.esercizio2;

public class Main {

    public static void main(String[] args) {
        Dipendente dipendente1 = new DipendenteFullTime("IT01", 1300.0, Dipartimento.VENDITE);
        Dipendente dipendente2 = new DipendenteFullTime("IT02", 1800.0, Dipartimento.PRODUZIONE);
        Dipendente dipendente3 = new DipendenteFullTime("IT03", 2500.0, Dipartimento.AMMINISTRAZIONE);

        Dipendente[] dipendenti ={dipendente1, dipendente2, dipendente3};

        for(Dipendente dipendente: dipendenti) {
            System.out.println("Dipendente " + dipendente.getMatricola() + "  Stipendio " + dipendente.calculateSalary() + " Dipartimento " + dipendente.getDipartimento());
        }

    }
}
