package it.epicode.esercizioPomeridiano.service;

import it.epicode.esercizioPomeridiano.bean.Ingrediente;
import it.epicode.esercizioPomeridiano.bean.Pizza;
import it.epicode.esercizioPomeridiano.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public void inserisciIngrediente(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    public Ingrediente getIngrediente(int id) {
        return ingredienteRepository.findById(id).get();
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienteRepository.findAll();
    }

    public void eliminaIngrediente(int id) {
        ingredienteRepository.deleteById(id);
    }

}
