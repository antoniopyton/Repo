package it.nextdevs.esercizioPomeridiano.Bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Menu {

    @Autowired
    private List<Pizza> pizze;

    @Autowired
    private List<Bevanda> bevande;

    @Autowired
    private List<Topping> toppings;

    public void stampaMenu() {
//        System.out.println("menu");
//        System.out.println("bevande");
//        bevande.forEach(b -> System.out.println(bevande.getNome() + " " + bevande.getPrezzo()));
    }
}
