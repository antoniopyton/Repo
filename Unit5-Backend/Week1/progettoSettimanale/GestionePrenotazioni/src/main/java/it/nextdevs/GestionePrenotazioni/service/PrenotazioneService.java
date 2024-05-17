package it.nextdevs.GestionePrenotazioni.service;

import it.nextdevs.GestionePrenotazioni.beans.Postazione;
import it.nextdevs.GestionePrenotazioni.beans.Prenotazione;
import it.nextdevs.GestionePrenotazioni.beans.Utente;
import it.nextdevs.GestionePrenotazioni.repository.PostazioneRepository;
import it.nextdevs.GestionePrenotazioni.repository.PrenotazioneRepository;
import it.nextdevs.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

//    public void inserisciPrenotazione(Prenotazione prenotazione) {
//        prenotazioneRepository.save(prenotazione);
//    }
//
//    public List<Prenotazione> getPrenotazioni() {
//        return prenotazioneRepository.findAll();
//    }
//
//    public Prenotazione getPrenotazione(int id) {
//        return prenotazioneRepository.findById(id).orElse(null);
//    }
//
//    public void cancellaPrenotazione(Prenotazione prenotazione) {
//        prenotazioneRepository.delete(prenotazione);
//    }

    public Prenotazione prenotaPostazione(String username, Integer postazioneId, LocalDate data) throws Exception {
        Utente utente = utenteRepository.findById(username).orElseThrow(() -> new Exception("Utente non trovato"));
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new Exception("Postazione non trovata"));

        if (!prenotazioneRepository.findByPostazioneAndData(postazione, data).isEmpty()) {
            throw new Exception("Postazione già prenotata per questa data");
        }

        if (!prenotazioneRepository.findByUtenteAndData(utente, data).isEmpty()) {
            throw new Exception("Utente ha già una prenotazione per questa data");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setData(data);

        return prenotazioneRepository.save(prenotazione);

    }
}
