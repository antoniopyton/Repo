package it.nextdevs.esercizioPomeridiano.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDto {

    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;

}
