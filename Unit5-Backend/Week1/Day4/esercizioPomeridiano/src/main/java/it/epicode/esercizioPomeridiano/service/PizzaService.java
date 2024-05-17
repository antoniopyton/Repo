package it.epicode.esercizioPomeridiano.service;

import it.epicode.esercizioPomeridiano.bean.Pizza;
import it.epicode.esercizioPomeridiano.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void inserisciPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public Pizza getPizza(int id) {
        return pizzaRepository.findById(id).get();
    }

    public List<Pizza> getPizze() {
        return pizzaRepository.findAll();
    }

    public void eliminaPizza(int id) {
        pizzaRepository.deleteById(id);
    }

//    public List<Pizza> getPizzaByNome(String nome){
//        return pizzaRepository.findByNome(nome);
//    }
//
//    public List<Pizza> getPizzaByNomeLike(String nome){
//        return pizzaRepository.findByNomeLike(nome);
//    }
}
