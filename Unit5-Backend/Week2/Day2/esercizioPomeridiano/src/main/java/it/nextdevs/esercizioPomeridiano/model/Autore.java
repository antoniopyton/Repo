package it.nextdevs.esercizioPomeridiano.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Autore {

    private int id;

    private static int cont;

    private String nome;

    private String cognome;

    private String email;

    private LocalDate dataNascita;

    private String avatar;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
        cont++;
        id = cont;
    }
}
