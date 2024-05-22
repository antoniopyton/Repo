package it.nextdevs.mattina.controller;

import it.nextdevs.mattina.DTO.AulaDto;
import it.nextdevs.mattina.exceptions.AulaNonTrovataException;
import it.nextdevs.mattina.model.Aula;
import it.nextdevs.mattina.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api") Aggiungendo questa annotazione permette di rimuovere "/api/" dal path singolo
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping("/api/aule")
    public String saveAula(@RequestBody AulaDto aulaDto) {
        return aulaService.saveAula(aulaDto);
    }

    @GetMapping("/api/aule")
    public List<Aula> getAule() {
        return aulaService.getAule();
    }

    @GetMapping("/api/aule/{id}")
    public Aula getAulaById(@PathVariable int id) {
        Optional<Aula> aulaOptional = aulaService.getAulaById(id);

        if(aulaOptional.isPresent()) {
            return aulaOptional.get();
        } else {
            throw new AulaNonTrovataException("Aula non trovata con id: " + id);
        }
    }

    @PutMapping("/api/aule/{id}")
    public Aula updateAula(@PathVariable int id,@RequestBody AulaDto aulaDto){
        return aulaService.updateAula(id, aulaDto);
    }

    @DeleteMapping("/api/aule/{id}")
    public String deleteAula(@PathVariable int id){
        return aulaService.deleteAula(id);
    }



}
