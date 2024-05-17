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
public class Utente {

    @Id
//    @GeneratedValue
    private String username;
    private String nomeCompleto;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;


    @Override
    public String toString() {
        return "Utente{" +
                "email='" + email + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
