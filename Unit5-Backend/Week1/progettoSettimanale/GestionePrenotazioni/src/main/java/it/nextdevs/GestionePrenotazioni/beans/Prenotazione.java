package it.nextdevs.GestionePrenotazioni.beans;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Entity
@Component
public class Prenotazione {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate data;

}
