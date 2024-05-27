package nextdevs.esercizioPomeridiano.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteDto {


    private String nome;

    private String cognome;

    private String password;

    @NotBlank
    private String username;

    @Email(message = "L'email non può essere vuota o mancante o composta da soli spazi")
    private String email;

}
