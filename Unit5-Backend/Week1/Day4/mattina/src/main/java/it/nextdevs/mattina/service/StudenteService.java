package it.nextdevs.mattina.service;

import it.nextdevs.mattina.Bean.Studente;
import it.nextdevs.mattina.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public void inserisciStudente(Studente studente) {
        studenteRepository.save(studente);
    }

    public Studente getStudente(int matricola) {
        return studenteRepository.findById(matricola).get();
    }

    public List<Studente> getStudenti() {
        return studenteRepository.findAll();
    }

    public void eliminaStudente(int matricola) {
        studenteRepository.deleteById(matricola);
    }

    public List<Studente> getStudentiByNome(String nome){
        return studenteRepository.findByNome(nome);
    }

    public List<Studente> getStudentiByCognome(String cognome){
        return studenteRepository.findByCognome(cognome);
    }

    public List<Studente> getStudentiByNomeLike(String nome){
        return studenteRepository.findByNomeLike(nome);
    }

}
