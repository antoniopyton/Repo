package it.nextdevs.mattina.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Studente {

    @Id
    @GeneratedValue
    private int matricola;

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;


//    public Studente(String nome, String cognome, LocalDate dataNascita) {
//        this.nome = nome;
//        this.cognome = cognome;
//        this.dataNascita = dataNascita;
//    }

}
