package nextdevs.esercizioPomeridiano.controller;

import nextdevs.esercizioPomeridiano.DTO.DipendenteDto;
import nextdevs.esercizioPomeridiano.DTO.DipendenteLoginDto;
import nextdevs.esercizioPomeridiano.exceptions.BadRequestException;
import nextdevs.esercizioPomeridiano.exceptions.DipendenteNonTrovatoException;
import nextdevs.esercizioPomeridiano.service.AuthService;
import nextdevs.esercizioPomeridiano.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;


    @PostMapping("/auth/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvaDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s +s2)));
        }

        return dipendenteService.saveDipendente(dipendenteDto);
    }


    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated DipendenteLoginDto dipendenteLoginDto, BindingResult bindingResult) throws DipendenteNonTrovatoException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2 ));
        }

        return authService.authenticateUserAndCreateToken(dipendenteLoginDto);
    }

}
