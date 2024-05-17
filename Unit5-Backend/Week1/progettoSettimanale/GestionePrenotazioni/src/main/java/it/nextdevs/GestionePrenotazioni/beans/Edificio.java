package it.nextdevs.GestionePrenotazioni.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
public class Edificio {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    @Override
    public String toString() {
        return "Edificio{" +
                "citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
