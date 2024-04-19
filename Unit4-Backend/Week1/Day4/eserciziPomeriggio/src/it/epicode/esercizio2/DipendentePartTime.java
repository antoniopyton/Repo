package it.epicode.esercizio2;

public class DipendentePartTime extends Dipendente {
    private int oreLavorative;


    public DipendentePartTime(String matricola, double stipendio, Dipartimento dipartimento, int oreLavorative) {
        super(matricola, stipendio, dipartimento);
        this.oreLavorative = oreLavorative;
    }



    @Override
    public double calculateSalary() {
        return this.getStipendio() * this.oreLavorative;
    }
}
