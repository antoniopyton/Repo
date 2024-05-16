package it.nextdevs.mattina.Bean;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo {

        @Id
        @GeneratedValue
        private int id;

        private String nome;
        private String marca;

        @ManyToOne
        @JoinColumn(name = "studente_id")
        private Studente studente;

}
