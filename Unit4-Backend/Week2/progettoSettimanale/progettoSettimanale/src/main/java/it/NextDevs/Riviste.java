package it.NextDevs;

import java.time.LocalDate;
import java.util.HashSet;

public class Riviste extends Catalogo {

    private Periodicita periodicita;

    public Riviste(String codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }
}
