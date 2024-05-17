package it.epicode.esercizioPomeridiano.service;

import it.epicode.esercizioPomeridiano.bean.Bevanda;
import it.epicode.esercizioPomeridiano.bean.Pizza;
import it.epicode.esercizioPomeridiano.repository.BevandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BevandaService {

    @Autowired
    private BevandaRepository bevandaRepository;

    public void inserisciPizza(Bevanda bevanda) {
        bevandaRepository.save(bevanda);
    }

}
