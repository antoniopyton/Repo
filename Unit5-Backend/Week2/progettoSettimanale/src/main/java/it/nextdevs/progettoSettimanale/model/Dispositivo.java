package it.nextdevs.progettoSettimanale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.nextdevs.progettoSettimanale.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
    @JsonIgnore
    private Dipendente dipendente;

}
