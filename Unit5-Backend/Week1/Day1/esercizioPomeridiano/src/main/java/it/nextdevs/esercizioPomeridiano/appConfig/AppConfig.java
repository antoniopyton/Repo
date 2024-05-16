package it.nextdevs.esercizioPomeridiano.appConfig;

import it.nextdevs.esercizioPomeridiano.Bean.*;
import it.nextdevs.esercizioPomeridiano.Enum.StatoTavolo;
import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean("wurstel")
    public Topping getTopping() {
        Topping topping = new Topping();
        topping.setNome("Wurstel");
        topping.setPrezzo(1.00);
        topping.setCalorie(100);
        return topping;
    }
    @Bean("sugo")
    public Topping getTopping2() {
        Topping topping = new Topping();
        topping.setPrezzo(0.50);
        topping.setCalorie(100);
        topping.setNome("Sugo");
        return topping;
    }

    @Bean("patatine_fritte")
    public Topping getTopping3() {
        Topping topping = new Topping();
        topping.setPrezzo(1.50);
        topping.setCalorie(100);
        topping.setNome("Patatine fritte");
        return topping;
    }

    @Bean("salame_piccante")
    public Topping getTopping4() {
        Topping topping = new Topping();
        topping.setPrezzo(1.50);
        topping.setCalorie(100);
        topping.setNome("Salame piccante");
        return topping;
    }

    @Bean("salsiccia")
    public Topping getTopping5() {
        Topping topping = new Topping();
        topping.setPrezzo(1.50);
        topping.setCalorie(100);
        topping.setNome("Salsiccia");
        return topping;
    }

    @Bean("friarielli")
    public Topping getTopping6() {
        Topping topping = new Topping();
        topping.setPrezzo(1.50);
        topping.setCalorie(100);
        topping.setNome("Friarielli");
        return topping;
    }

    @Bean("margherita")
    public Pizza getPizza() {
        Pizza pizza = new Pizza();
        pizza.setNome("Margherita");
        pizza.setPrezzo(4.00);
        pizza.setCalorie(1000);
        pizza.setMozzarella(true);
        pizza.setToppings(List.of(getTopping2()));
        return pizza;
    }

    @Bean("wurstel_e_patatine")
    public Pizza getPizza2() {
        Pizza pizza = new Pizza();
        pizza.setNome("Wurstel e patatine");
        pizza.setCalorie(1300);
        pizza.setPrezzo(5.00);
        pizza.setMozzarella(true);
        pizza.setToppings(List.of(getTopping(), getTopping3()));
        return pizza;
    }

    @Bean("diavola")
    public Pizza getPizza3() {
        Pizza pizza = new Pizza();
        pizza.setNome("Diavola");
        pizza.setCalorie(1100);
        pizza.setPrezzo(5.00);
        pizza.setMozzarella(true);
        pizza.setToppings(List.of(getTopping2(), getTopping4()));
        return pizza;
    }

    @Bean("sasiccefriariell")
    public Pizza getPizza4() {
        Pizza pizza = new Pizza();
        pizza.setNome("Sasicc e friariell");
        pizza.setCalorie(1300);
        pizza.setPrezzo(6.00);
        pizza.setMozzarella(true);
        pizza.setToppings(List.of(getTopping5(), getTopping6()));
        return pizza;
    }


    @Bean("cocacola_33")
    public Bevanda getBevanda(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Coca-Cola");
        bevanda.setPrezzo(2.00);
        bevanda.setLitri(0.33);
        return bevanda;
    }

    @Bean("cocacola_66")
    public Bevanda getBevanda2(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Coca-Cola");
        bevanda.setPrezzo(3.50);
        bevanda.setLitri(0.66);
        return bevanda;
    }

    @Bean("heineken_33")
    public Bevanda getBevanda3(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Heineken");
        bevanda.setPrezzo(1.50);
        bevanda.setLitri(0.33);
        return bevanda;
    }

    @Bean("heineken_66")
    public Bevanda getBevanda4(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Heineken");
        bevanda.setPrezzo(3.00);
        bevanda.setLitri(0.66);
        return bevanda;
    }

    @Bean("heineken_33")
    public Bevanda getBevanda7(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Tennent's");
        bevanda.setPrezzo(3.00);
        bevanda.setLitri(0.33);
        return bevanda;
    }

    @Bean("heineken_66")
    public Bevanda getBevanda8(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Tennent's");
        bevanda.setPrezzo(4.50);
        bevanda.setLitri(0.66);
        return bevanda;
    }


    @Bean("fanta_33")
    public Bevanda getBevanda6(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Fanta");
        bevanda.setPrezzo(2.00);
        bevanda.setLitri(0.33);
        return bevanda;
    }

    @Bean("fanta_66")
    public Bevanda getBevanda5(){
        Bevanda bevanda = new Bevanda();
        bevanda.setNome("Fanta");
        bevanda.setPrezzo(3.50);
        bevanda.setLitri(0.66);
        return bevanda;
    }

    @Bean("menu")
    public Menu getMenu() {
        Menu menu = new Menu();
        menu.setToppings(List.of(getTopping(), getTopping2(), getTopping3(), getTopping4(), getTopping5(), getTopping6()));
        menu.setPizze(List.of(getPizza(), getPizza2(), getPizza3(), getPizza4()));
        menu.setBevande(List.of(getBevanda(), getBevanda2(), getBevanda3(), getBevanda4(), getBevanda5(), getBevanda6(), getBevanda7(), getBevanda8()));
        return menu;
    }

    @Bean
    public Tavolo tavolo(@Value("${tavolo.coperto}") String coperto) {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumero(1);
        tavolo.setMaxCoperti(5);
        tavolo.setStatoTavolo(StatoTavolo.LIBERO);
        tavolo.setCoperto(Double.parseDouble(coperto));
        return tavolo;
    }

    @Bean
    public Tavolo tavolo2(@Value("${tavolo2.coperto}") String coperto) {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumero(2);
        tavolo.setMaxCoperti(3);
        tavolo.setStatoTavolo(StatoTavolo.LIBERO);
        tavolo.setCoperto(Double.parseDouble(coperto));
        return tavolo;
    }

    @Bean
    public Tavolo tavolo3(@Value("${tavolo3.coperto}") String coperto) {
        Tavolo tavolo = new Tavolo();
        tavolo.setNumero(3);
        tavolo.setMaxCoperti(5);
        tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);
        tavolo.setCoperto(Double.parseDouble(coperto));
        return tavolo;
    }

}
