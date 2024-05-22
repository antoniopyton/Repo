package it.nextdevs.esercizioPomeridiano.service;

import it.nextdevs.esercizioPomeridiano.DTO.AutoreDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import it.nextdevs.esercizioPomeridiano.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setDataNascita(autoreDto.getDataNascita());
        autore.setEmail(autoreDto.getEmail());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autoreDto.getNome() + "+" + autoreDto.getCognome());

       autoreRepository.save(autore);
       return "Autore salvato con successo con id: " + autore.getId();
    }

    public List<Autore> getAutori() {
        return autoreRepository.findAll();
    }

    public Optional<Autore> getAutoreById(int id) {
        return autoreRepository.findById(id);
    }

    public Autore updateAutore(int id, AutoreDto autoreDto) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setDataNascita(autoreDto.getDataNascita());
            return autoreRepository.save(autore);
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id: " + id);
        }
    }

    public String eliminaAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            return "Autore eliminato con successo con id: " + id;
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id: " + id);
        }
    }

}
