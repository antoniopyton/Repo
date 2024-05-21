package it.nextdevs.mattina.controller;

import it.nextdevs.mattina.exceptions.StudenteNonTrovatoException;
import it.nextdevs.mattina.model.Studente;
import it.nextdevs.mattina.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudente(@RequestBody Studente studente) {
        studenteService.saveStudente(studente);
        return "Studente salvato con successo con matricola: " + studente.getMatricola();
    }

    @GetMapping("/api/studenti")
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    @GetMapping("/api/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola) throws StudenteNonTrovatoException {
        Optional<Studente> studenteOpt = studenteService.getStudenteByMatricola(matricola);

        if(studenteOpt.isPresent()) {
            return studenteOpt.get();
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato con la matricola: " + matricola);
        }

    }


    @PutMapping("/api/studenti/{matricola}")
    @ResponseStatus(HttpStatus.OK)
    public Studente updateStudente(@PathVariable int matricola, @RequestBody Studente studente) throws StudenteNonTrovatoException {
        return studenteService.updateStudente(matricola, studente);
    }

    @DeleteMapping("/api/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola) throws StudenteNonTrovatoException {
        studenteService.deleteStudente(matricola);
        return "Studente eliminato con successo con matricola: " + matricola;
    }

//    @GetMapping("/api")
//    public String benvenuto() {
//        return "Benvenuto";
//    }
//
//    @GetMapping("/api/nome_cognome")
//    public String benvenuto2(@RequestParam String nome, String cognome) {
//        return "Benvenuto " + nome + " " + cognome;
//    }
//
//    @GetMapping("/api/{nome}/{cognome}")
//    public String benvenuto3(@PathVariable String nome, @PathVariable String cognome) {
//        return "Benvenuto " + nome + " " + cognome;
//    }
//
//    @GetMapping("/api/body") //@RequestBody fa capire a spring che i dati deve recuperarli dal body della richiesta
//    public String benvenuto4(@RequestBody String nomeCognome) {
//        return "Benvenuto " + nomeCognome;
//    }

}
