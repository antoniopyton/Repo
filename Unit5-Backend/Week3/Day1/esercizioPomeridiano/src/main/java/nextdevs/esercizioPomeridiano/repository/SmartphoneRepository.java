package nextdevs.esercizioPomeridiano.repository;


import nextdevs.esercizioPomeridiano.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
