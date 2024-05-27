package nextdevs.esercizioPomeridiano.service;

import nextdevs.esercizioPomeridiano.DTO.DipendenteLoginDto;
import nextdevs.esercizioPomeridiano.exceptions.DipendenteNonTrovatoException;
import nextdevs.esercizioPomeridiano.exceptions.UnauthorizedException;
import nextdevs.esercizioPomeridiano.model.Dipendente;
import nextdevs.esercizioPomeridiano.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateUserAndCreateToken(DipendenteLoginDto dipendenteLoginDto) throws DipendenteNonTrovatoException {
        Dipendente dipendente = dipendenteService.getDipendenteByEmail(dipendenteLoginDto.getEmail());

        if (dipendente.getPassword().equals(dipendenteLoginDto.getPassword())) {
            return jwtTool.createToken(dipendente);
        } else {
            throw new UnauthorizedException("Error in authorization, re-login!");
        }
    }

}
