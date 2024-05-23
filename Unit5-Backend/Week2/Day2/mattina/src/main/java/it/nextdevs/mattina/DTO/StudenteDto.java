package it.nextdevs.mattina.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {

    @NotNull
    @Size(max = 30)
    private String nome;

    @NotNull
    @Size(max = 30)
    private String cognome;
    private LocalDate dataNascita;

    @NotNull
    private int aulaId;

    @Email(regexp = "\"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$\"")
    @NotNull
    private String email;



}
