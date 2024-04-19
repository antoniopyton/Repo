package it.epicode.esercizio2;

public class Dirigente extends  Dipendente {
    public Dirigente(String matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return this.getStipendio();
    }
}
