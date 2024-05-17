package it.nextdevs.GestionePrenotazioni.repository;

import it.nextdevs.GestionePrenotazioni.beans.Postazione;
import it.nextdevs.GestionePrenotazioni.beans.Prenotazione;
import it.nextdevs.GestionePrenotazioni.beans.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);

}
