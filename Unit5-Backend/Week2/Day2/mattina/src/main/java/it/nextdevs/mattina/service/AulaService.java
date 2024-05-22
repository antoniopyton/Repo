package it.nextdevs.mattina.service;

import it.nextdevs.mattina.DTO.AulaDto;
import it.nextdevs.mattina.exceptions.AulaNonTrovataException;
import it.nextdevs.mattina.model.Aula;
import it.nextdevs.mattina.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public String saveAula(AulaDto aulaDto) {
        Aula aula = new Aula();
        aula.setNome(aulaDto.getNome());
        aula.setPiano(aulaDto.getPiano());
        aula.setPiano(aulaDto.getPiano());

        aulaRepository.save(aula);
        return "Aula salvata con successo con id: " + aula.getId();
    }

    public List<Aula> getAule() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> getAulaById(int id){
        return aulaRepository.findById(id);
    }

    public Aula updateAula(int id, AulaDto aulaDto){
        Optional<Aula> aulaOptional = getAulaById(id);

        if(aulaOptional.isPresent()) {
            Aula aula = aulaOptional.get();
            aula.setNome(aulaDto.getNome());
            aula.setPiano(aulaDto.getPiano());
            aula.setPiano(aulaDto.getPiano());
            return aulaRepository.save(aula);

        } else {
            throw new AulaNonTrovataException("Aula non trovata con id: " + id);
        }
    }

    public String deleteAula(int id) {
        Optional<Aula> aulaOptional = getAulaById(id);
        if(aulaOptional.isPresent()) {
            aulaRepository.delete(aulaOptional.get());
            return "Aula eliminata con successo con id: " + id;
        } else {
            throw new AulaNonTrovataException("Aula non trovata con id: " + id);
        }
    }

}
