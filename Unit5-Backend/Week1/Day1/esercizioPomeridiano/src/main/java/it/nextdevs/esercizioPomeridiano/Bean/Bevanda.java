package it.nextdevs.esercizioPomeridiano.Bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Bevanda extends CalorieEPrezzo{

    private String nome;

    private double litri;

}
