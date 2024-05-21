package it.nextdevs.esercizioPomeridiano.service;

import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private List<Autore> autori = new ArrayList<>();

    public Optional<Autore> getAutoreById(int id) {
        return autori.stream().filter(autore -> autore.getId() == id).findFirst();
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public String saveAutore(Autore autore) {
        autori.add(autore);
        return "Autore salvato con successo con matricola: " + autore.getId();
    }

    public Autore updateAutore(int id, Autore autoreUpdate) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreUpdate.getNome());
            autore.setCognome(autoreUpdate.getCognome());
            autore.setDataNascita(autoreUpdate.getDataNascita());
            return autore;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    public String eliminaAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autori.remove(autoreOpt.get());
            return "Autore eliminato con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

}
