package it.nextdevs.esercizioPomeridiano.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String cognome;

    @Email
    @NotBlank
    private String email;
    private LocalDate dataNascita;

}
