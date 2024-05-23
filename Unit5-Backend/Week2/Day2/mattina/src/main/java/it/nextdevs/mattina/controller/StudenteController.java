package it.nextdevs.mattina.controller;

import it.nextdevs.mattina.DTO.StudenteDto;
import it.nextdevs.mattina.exceptions.BadRequestException;
import it.nextdevs.mattina.exceptions.StudenteNonTrovatoException;
import it.nextdevs.mattina.model.Studente;
import it.nextdevs.mattina.service.StudenteService;
import it.nextdevs.mattina.service.StudenteServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudente(@RequestBody @Validated StudenteDto studenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

        return studenteService.saveStudente(studenteDto);
//        return "Studente salvato con successo con matricola: " + studenteDto.getMatricola();
    }

    @GetMapping("/api/studenti")
    public Page<Studente> getAllStudenti(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(defaultValue = "matricola") String sortBy) {
        return studenteService.getAllStudenti(page, size, sortBy);
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
    public Studente updateStudente(@PathVariable int matricola, @RequestBody @Validated StudenteDto studenteDto, BindingResult bindingResult) throws StudenteNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

        return studenteService.updateStudente(matricola, studenteDto);
    }

    @DeleteMapping("/api/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola) throws StudenteNonTrovatoException {
        studenteService.deleteStudente(matricola);
        return "Studente eliminato con successo con matricola: " + matricola;
    }


    @PatchMapping("/api/studente/{matricola}")
    public String patchFotoStudente(@RequestBody MultipartFile foto, @PathVariable int matricola) throws StudenteNonTrovatoException, IOException {
        return studenteService.patchFotoStudente(matricola, foto);
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
