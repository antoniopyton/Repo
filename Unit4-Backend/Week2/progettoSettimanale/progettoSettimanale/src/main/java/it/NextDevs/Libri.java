package it.NextDevs;


import java.time.LocalDate;
import java.util.HashSet;

public class Libri extends Catalogo {
    private String Autore;
    private String Genere;

    public Libri(String codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        Autore = autore;
        Genere = genere;
    }

    public String getAutore() {
        return Autore;
    }

    public String getGenere() {
        return Genere;
    }

    public void setAutore(String autore) {
        Autore = autore;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }
}

