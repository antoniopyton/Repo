package it.epicode.esercizioPomeridiano.repository;

import it.epicode.esercizioPomeridiano.bean.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
