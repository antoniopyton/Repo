package it.nextdevs.mattina.service;

import it.nextdevs.mattina.DTO.StudenteDto;
import it.nextdevs.mattina.exceptions.AulaNonTrovataException;
import it.nextdevs.mattina.exceptions.StudenteNonTrovatoException;
import it.nextdevs.mattina.model.Aula;
import it.nextdevs.mattina.model.Studente;
import it.nextdevs.mattina.repository.AulaRepository;
import it.nextdevs.mattina.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private StudenteRepository studenteRepository;

    public String saveStudente(StudenteDto studenteDto) {
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());

        Optional<Aula> aulaOptional = aulaRepository.findById(studenteDto.getAulaId());

        if (aulaOptional.isPresent()) {
            Aula aula = aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
            return "Studente salvato con successo con matricola: " + studente.getMatricola();

        } else {
            throw new AulaNonTrovataException("Aula non trovata con id: " + studenteDto.getAulaId());
        }

//        aulaRepository.findById(studenteDto.getAulaId()).ifPresent(aula -> studente.setAula(aula));
//        studenteRepository.save(studente);
//        return "Studente salvato con successo con matricola: " + studente.getMatricola();
    }

    public Page<Studente> getAllStudenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studenteRepository.findAll(pageable);
    }

    public Optional<Studente> getStudenteByMatricola(int matricola) {
        return studenteRepository.findById(matricola);
    }

    public Studente updateStudente(int matricola, StudenteDto studenteDto){
        Optional<Studente> studenteOptional = getStudenteByMatricola(matricola);

        if(studenteOptional.isPresent()){
            Studente studente = studenteOptional.get();

            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataNascita(studenteDto.getDataNascita());

            Optional<Aula> aulaOptional=aulaRepository.findById(studenteDto.getAulaId());

            if(aulaOptional.isPresent()){
                Aula aula = aulaOptional.get();
                studente.setAula(aula);
                studenteRepository.save(studente);
                return studente;
            }
            else{
                throw new AulaNonTrovataException("Aula con id=" + studenteDto.getAulaId() + " non trovata");
            }
        }
        else{
            throw new StudenteNonTrovatoException("Studente con matricola=" + matricola + " non trovato");
        }
    }

    public String deleteStudente(int matricola)  {
        Optional<Studente> studenteOptional = studenteRepository.findById(matricola);

        if (studenteOptional.isPresent()) {
            studenteRepository.delete(studenteOptional.get());
            return "Studente eliminato con successo con matricola: " + matricola;
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato con matricola: " + matricola);
        }
    }

}
