package nextdevs.esercizioPomeridiano.controller;

import nextdevs.esercizioPomeridiano.DTO.DipendenteDto;
import nextdevs.esercizioPomeridiano.exceptions.BadRequestException;
import nextdevs.esercizioPomeridiano.exceptions.DipendenteNonTrovatoException;
import nextdevs.esercizioPomeridiano.model.Dipendente;
import nextdevs.esercizioPomeridiano.service.DipendenteService;
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
@RequestMapping("/api")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping("/dipendenti")
    public List<Dipendente> getDipendenti() {
        return dipendenteService.getDipendenti();
    }

    @GetMapping("/dipendenti/{id}")
    public Dipendente getDipendenteById(@PathVariable int id) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = dipendenteService.getDipendenteById(id);

        if (dipendenteOpt.isPresent()) {
            return dipendenteOpt.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato con id: " + id);
        }
    }

    @PutMapping("/dipendenti/{id}")
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) throws DipendenteNonTrovatoException{
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

        return  dipendenteService.updateDipendente(id, dipendenteDto);

    }

    @PatchMapping("/dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String patchImmagineDipendente(@RequestBody MultipartFile foto, @PathVariable int id) throws IOException, DipendenteNonTrovatoException {
        return dipendenteService.patchImmagineDipendente(id, foto);
    }

    @DeleteMapping("/dipendenti/{id}")
    public String deleteAutore(@PathVariable int id) throws DipendenteNonTrovatoException {
        return dipendenteService.eliminaDipendente(id);
    }




}
