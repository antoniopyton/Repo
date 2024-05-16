package it.nextdevs.esercizioPomeridiano.Bean;

import it.nextdevs.esercizioPomeridiano.Enum.StatoTavolo;
import lombok.Data;

@Data
public class  Tavolo {

    private int numero;
    private int maxCoperti;
    private StatoTavolo statoTavolo;
    private double coperto;

}
