package it.nextdevs.progettoSettimanale.model;

import it.nextdevs.progettoSettimanale.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Dispositivo {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private String marca;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo statoDispositivo;

    @ManyToOne
    @JoinColumn(name="dipendente_id")
    private Dipendente dipendente;

}
