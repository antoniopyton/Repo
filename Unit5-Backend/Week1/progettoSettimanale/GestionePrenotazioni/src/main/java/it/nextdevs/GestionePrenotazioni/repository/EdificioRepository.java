package it.nextdevs.GestionePrenotazioni.repository;

import it.nextdevs.GestionePrenotazioni.beans.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
