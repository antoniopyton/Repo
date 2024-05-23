package it.nextdevs.esercizioPomeridiano.controller;

import it.nextdevs.esercizioPomeridiano.DTO.AutoreDto;
import it.nextdevs.esercizioPomeridiano.exceptions.AutoreNonTrovatoException;
import it.nextdevs.esercizioPomeridiano.exceptions.BadRequestException;
import it.nextdevs.esercizioPomeridiano.model.Autore;
import it.nextdevs.esercizioPomeridiano.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/api/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

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
    public Autore updateAutore(@PathVariable int id, @RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) throws AutoreNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

        return autoreService.updateAutore(id, autoreDto);
    }

    @PatchMapping ("/api/autori/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String patchAvatarAutore(@RequestBody MultipartFile foto, @PathVariable int id) throws IOException, AutoreNonTrovatoException {
        return autoreService.patchAvatarAutore(id, foto);

    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException {
        return autoreService.eliminaAutore(id);
    }

}
