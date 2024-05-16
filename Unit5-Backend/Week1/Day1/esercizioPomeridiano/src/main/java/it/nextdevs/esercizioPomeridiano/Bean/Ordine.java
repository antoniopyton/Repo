package it.nextdevs.esercizioPomeridiano.Bean;

import it.nextdevs.esercizioPomeridiano.Enum.StatoOrdine;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Ordine {

     private int numeroOrdine;
     private StatoOrdine statoOrdine;
     private int numeroCoperti;
     private LocalDateTime dataAcquisizione;
     private Tavolo tavolo;

     private List<Bevanda> bevande;
     private List<Topping> toppings;
     private List<Pizza> pizze;

     public double prezzoTotale() {
         double totale = bevande.stream().mapToDouble(Bevanda::getPrezzo).sum();
         totale += toppings.stream().mapToDouble(Topping::getPrezzo).sum();
         totale += pizze.stream().mapToDouble(Pizza::getPrezzo).sum();
         totale += tavolo.getCoperto() * numeroCoperti;
         return totale;
     }

     public Ordine(int numeroCoperti, Tavolo tavolo) {
          if(numeroCoperti <= tavolo.getMaxCoperti()) {
               this.numeroCoperti = numeroCoperti;
          } else {
               throw new IllegalArgumentException("Il numero di coperti non è valido");
          }
     }

    public void stampaOrdine() {
    }
}
