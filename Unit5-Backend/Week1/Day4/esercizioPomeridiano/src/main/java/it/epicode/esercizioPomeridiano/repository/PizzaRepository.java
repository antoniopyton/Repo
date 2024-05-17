package it.epicode.esercizioPomeridiano.repository;

import it.epicode.esercizioPomeridiano.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
