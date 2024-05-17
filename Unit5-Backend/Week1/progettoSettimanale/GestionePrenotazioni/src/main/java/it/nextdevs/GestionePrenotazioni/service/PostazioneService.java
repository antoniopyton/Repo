package it.nextdevs.GestionePrenotazioni.service;

import it.nextdevs.GestionePrenotazioni.beans.Postazione;
import it.nextdevs.GestionePrenotazioni.enums.TipoPostazione;
import it.nextdevs.GestionePrenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void inserisciPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public List<Postazione> getPostazioni(Postazione postazione) {
        return postazioneRepository.findAll();
    }

    public Postazione getPostazione(Postazione postazione) {
        return postazioneRepository.findById(postazione.getId()).orElse(null);
    }

    public List<Postazione> trovaPostazioniPerTipoEdificio(TipoPostazione tipoPostazione, String citta) {
        return postazioneRepository.findByTipoEdificio_Citta(tipoPostazione, citta);
    }

    public void eliminaPostazione(Postazione postazione) {
        postazioneRepository.delete(postazione);
    }

}
