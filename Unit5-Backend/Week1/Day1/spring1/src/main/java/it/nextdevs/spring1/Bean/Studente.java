package it.nextdevs.spring1.Bean;

import lombok.Data;

import java.util.List;

@Data
public class Studente {

    private String nome;

    private String cognome;

    private String indirizzo;

    private List<Dispositivo> dispositivi;


}
