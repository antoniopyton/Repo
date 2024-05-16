package it.nextdevs.mattina.Bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricola;

    private String nome;

    private String cognome;

    private String indirizzo;

    @OneToMany(mappedBy = "studente")
    private List<Dispositivo> dispositivi = new ArrayList<>();


}
