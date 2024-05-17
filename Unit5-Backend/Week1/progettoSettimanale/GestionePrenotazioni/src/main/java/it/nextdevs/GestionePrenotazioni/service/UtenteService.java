package it.nextdevs.GestionePrenotazioni.service;

import it.nextdevs.GestionePrenotazioni.beans.Utente;
import it.nextdevs.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UtenteService {


    @Autowired
    private UtenteRepository utenteRepository;

    public void inserisciUtente(Utente utente){
        utenteRepository.save(utente);
    }

    public List<Utente> getUtenti(){
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(String id){
        return utenteRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Utente non trovato"));
    }

    public void eliminaUtente(Utente utente){
        utenteRepository.delete(utente);
    }
}
