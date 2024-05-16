package it.nextdevs.spring1.Bean;

import lombok.Data;

import java.util.List;

@Data
public class Aula {

    private String nome;

    private List<Studente> studenti;
}
