package it.nextdevs.GestionePrenotazioni.repository;

import it.nextdevs.GestionePrenotazioni.beans.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}
