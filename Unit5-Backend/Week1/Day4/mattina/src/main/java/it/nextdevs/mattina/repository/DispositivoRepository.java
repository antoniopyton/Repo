package it.nextdevs.mattina.repository;

import it.nextdevs.mattina.Bean.Computer;
import it.nextdevs.mattina.Bean.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {

        public List<Computer> findByRamLessThan(int ram);

//      @Query(value = "select d from Dispositivo d order by d.nome desc", nativeQuery = true) //native query per scrivere query in sql
        @Query("select d from Dispositivo d order by d.nome desc") //query in jpql
        public List<Dispositivo> findAllOrderByNomeDesc();

}
