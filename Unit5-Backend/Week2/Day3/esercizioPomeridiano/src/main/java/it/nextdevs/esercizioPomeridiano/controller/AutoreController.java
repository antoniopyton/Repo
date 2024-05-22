package it.nextdevs.esercizioPomeridiano.controller;

import it.nextdevs.esercizioPomeridiano.DTO.AutoreDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import it.nextdevs.esercizioPomeridiano.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaAutore(@RequestBody AutoreDto autoreDto) {
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/api/autori")
    public List<Autore> getAllAutore() {
        return autoreService.getAutori();
    }

    @GetMapping("/api/autori/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = autoreService.getAutoreById(id);

        if(autoreOpt.isPresent()) {
            return autoreOpt.get();
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id: " + id);
        }
    }

    @PutMapping("/api/autori/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody AutoreDto autoreDto) throws AutoreNonTrovatoException {
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        return autoreService.eliminaAutore(id);
    }

}
