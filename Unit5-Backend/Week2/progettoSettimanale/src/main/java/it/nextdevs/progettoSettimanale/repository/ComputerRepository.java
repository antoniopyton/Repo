package it.nextdevs.progettoSettimanale.repository;

import it.nextdevs.progettoSettimanale.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}
