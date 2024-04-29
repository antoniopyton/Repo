package it.NextDevs;

import java.time.LocalDate;
import java.util.HashSet;

public class Catalogo {

    private String CodiceISBN;
    private String Titolo;
    private LocalDate annoPubblicazione;
    private Integer numeroPagine;

    public Catalogo(String codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine) {
        CodiceISBN = codiceISBN;
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodiceISBN() {
        return CodiceISBN;
    }

    public String getTitolo() {
        return Titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "CodiceISBN='" + CodiceISBN + '\'' +
                ", Titolo='" + Titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
