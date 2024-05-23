package it.nextdevs.esercizioPomeridiano.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDto {

    private String categoria;

    @NotBlank
    private String titolo;

    private String contenuto;

    private int tempoDiLettura;

    private int autoreId;



}
