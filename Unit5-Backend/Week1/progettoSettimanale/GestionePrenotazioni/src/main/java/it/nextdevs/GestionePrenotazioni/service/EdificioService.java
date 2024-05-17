package it.nextdevs.GestionePrenotazioni.service;

import it.nextdevs.GestionePrenotazioni.beans.Edificio;
import it.nextdevs.GestionePrenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void inserisciEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public List<Edificio> getEdifici() {
        return edificioRepository.findAll();
    }

    public Edificio getEdificio(int id) {
        return edificioRepository.findById(id).orElse(null);
    }

    public void eliminaEdificio(Edificio edificio) {
        edificioRepository.delete(edificio);
    }

}
