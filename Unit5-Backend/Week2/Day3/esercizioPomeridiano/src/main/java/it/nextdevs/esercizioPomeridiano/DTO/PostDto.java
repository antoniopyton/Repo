package it.nextdevs.esercizioPomeridiano.DTO;

import lombok.Data;

@Data
public class PostDto {

    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;



}
