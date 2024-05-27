package nextdevs.esercizioPomeridiano.controller;

import nextdevs.esercizioPomeridiano.DTO.DispositivoDto;
import nextdevs.esercizioPomeridiano.exceptions.BadRequestException;
import nextdevs.esercizioPomeridiano.exceptions.DipendenteNonTrovatoException;
import nextdevs.esercizioPomeridiano.exceptions.DispositivoNonTrovatoException;
import nextdevs.esercizioPomeridiano.model.*;
import nextdevs.esercizioPomeridiano.service.DipendenteService;
import nextdevs.esercizioPomeridiano.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DispositivoController {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/computer")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaComputer(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws DipendenteNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dispositivoService.salvaComputer(dispositivoDto);
    }

    @PostMapping("/smartphone")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaSmartphone(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws DipendenteNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dispositivoService.salvaSmartphone(dispositivoDto);
    }

    @PostMapping("/tablet")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaTablet(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws DipendenteNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dispositivoService.salvaTablet(dispositivoDto);
    }

    @GetMapping("/dispositivi")
    public List<Dispositivo> getAllDispositivi() {
        return dispositivoService.getDispositivi();
    }

    @GetMapping("/computers")
    public List<Computer> getComputers() {
        return dispositivoService.getComputers();
    }

    @GetMapping("/smartphones")
    public List<Smartphone> getSmartphones() {
        return dispositivoService.getSmartphones();
    }

    @GetMapping("/tablets")
    public List<Tablet> getTablets() {
        return dispositivoService.getTablets();
    }

    @GetMapping("/dispositivi/{id}")
    public Dispositivo getDispositivoById(@PathVariable int id) throws DispositivoNonTrovatoException {
        Optional<Dispositivo> dispositivoOptional = dispositivoService.getDispositivoById(id);

        if (dispositivoOptional.isPresent()) {
            return dispositivoOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato con l'id: " + id);
        }
    }


    @PutMapping("/computer/{id}")
    public ResponseEntity<Object> updateComputer(@PathVariable int id, @RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws DispositivoNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, s2) -> s + s2));
        }

        Computer updatedComputer = dispositivoService.updateComputer(id, dispositivoDto);
        if (updatedComputer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedComputer);
    }

    @PutMapping("/smartphone/{id}")
    public ResponseEntity<Object> updateSmartphone(@PathVariable int id, @RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws DispositivoNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, s2) -> s + s2));
        }

        Smartphone updatedSmartphone = dispositivoService.updateSmartphone(id, dispositivoDto);
        if (updatedSmartphone == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedSmartphone);
    }

    @PutMapping("/tablet/{id}")
    public ResponseEntity<Object> updateTablet(@PathVariable int id, @RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) throws DispositivoNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, s2) -> s + s2));
        }

        Tablet updatedTablet = dispositivoService.updateTablet(id, dispositivoDto);
        if (updatedTablet == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTablet);
    }

    @DeleteMapping("/dispositivi/{id}")
    public void eliminaDispositivo(@PathVariable int id) throws DispositivoNonTrovatoException {
        dispositivoService.eliminaDispositivo(id);
    }


    @PostMapping("/dispositivi/{dispositivoId}/assegna/{dipendenteId}")
    public ResponseEntity<Dispositivo> assegnaDispositivo(@PathVariable int dispositivoId, @PathVariable int dipendenteId) throws DispositivoNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = dipendenteService.getDipendenteById(dipendenteId);
        if (!dipendenteOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Dipendente dipendente = dipendenteOpt.get();
        Dispositivo dispositivo = dispositivoService.assegnaDispositivo(dispositivoId, dipendente);
        if (dispositivo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dispositivo, HttpStatus.OK);
    }

}
