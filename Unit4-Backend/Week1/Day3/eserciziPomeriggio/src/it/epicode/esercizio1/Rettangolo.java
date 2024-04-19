package it.epicode.esercizio1;

public class Rettangolo {

    private double altezza;
    private double larghezza;

    public Rettangolo(double altezza, double larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public double area() {
        return altezza * larghezza;
    }

    public double perimetro() {
        return 2 * (altezza + larghezza);
    }

    public double getAltezza() {
        return altezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public double sommaAreaePerimetro() {
        return(area()+ perimetro());
    }
}

