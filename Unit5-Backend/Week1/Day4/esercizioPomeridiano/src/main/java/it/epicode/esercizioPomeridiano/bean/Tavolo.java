package it.epicode.esercizioPomeridiano.bean;

import it.epicode.esercizioPomeridiano.enumeration.Stato;
import lombok.Data;

@Data
public class Tavolo {
    private int numero;
    private int maxCoperti;
    private Stato stato;
    private double coperto;

}
