package NextDevs.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "catalogo")
public abstract class Catalogo {


    @Id
    private String CodiceISBN;


    private String Titolo;

    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "numero_pagine")
    private Integer numeroPagine;

    public Catalogo(String codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine) {
        CodiceISBN = codiceISBN;
        Titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Catalogo() {

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
