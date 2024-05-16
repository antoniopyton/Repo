package it.nextdevs.esercizioPomeridiano.Bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)

public class Pizza extends CalorieEPrezzo{

    private String nome;

    private boolean mozzarella;

    private List<Topping> toppings;

}
