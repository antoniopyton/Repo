package nextdevs.esercizioPomeridiano.repository;

import nextdevs.esercizioPomeridiano.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}
