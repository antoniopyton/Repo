package it.nextdevs.GestionePrenotazioni.beans;

import it.nextdevs.GestionePrenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
public class Postazione {

    @Id
    @GeneratedValue
    private int id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int numeroOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

}
