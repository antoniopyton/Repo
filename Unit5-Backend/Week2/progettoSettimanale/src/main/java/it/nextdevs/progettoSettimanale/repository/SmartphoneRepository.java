package it.nextdevs.progettoSettimanale.repository;

import it.nextdevs.progettoSettimanale.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
