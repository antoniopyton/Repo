package it.epicode.esercizioPomeridiano.repository;

import it.epicode.esercizioPomeridiano.bean.Bevanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BevandaRepository extends JpaRepository<Bevanda, Integer> {
}
