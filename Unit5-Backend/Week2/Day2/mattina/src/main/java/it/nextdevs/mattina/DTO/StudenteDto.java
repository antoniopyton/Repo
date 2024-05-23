package it.nextdevs.mattina.DTO;

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



}
