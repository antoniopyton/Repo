package it.epicode.esercizioPomeridiano.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bevanda extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;

    private int ml;
    private String nome;
    private int gradoAlcohol;
}

