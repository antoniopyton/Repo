package it.nextdevs.esercizioPomeridiano.Bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)

public class Topping extends CalorieEPrezzo{

        private String nome;

}
