package it.nextdevs.mattina.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.nextdevs.mattina.entity.User;
import it.nextdevs.mattina.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class JwtTool {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.duration}")
    private long duration;

    //Crea il token impostando data di inizio, fine, id utente e firma del token attraverso la chiave segreta
    public String createToken(User user) {
        return Jwts.builder().issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + duration))
                .subject(String.valueOf(user.getId())).signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    //Effettua la verifica del token ricevuto. Verifica la veridicità del tokene  la sua scadenza
    public void verifyToken(String token) {
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build().parse(token);
        } catch (Exception e) {
            throw new UnauthorizedException("Error in authorization, re-login!");
        }

    }

}
