package it.nextdevs.mattina.repository;

import it.nextdevs.mattina.Bean.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {

    public List<Studente> findByNome(String nome);

    public List<Studente> findByNomeLike(String nome);

    public List<Studente> findByCognome(String cognome);

}
