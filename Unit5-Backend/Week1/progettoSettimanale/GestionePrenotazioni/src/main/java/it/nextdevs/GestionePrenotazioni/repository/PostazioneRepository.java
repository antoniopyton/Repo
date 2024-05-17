package it.nextdevs.GestionePrenotazioni.repository;

import it.nextdevs.GestionePrenotazioni.beans.Postazione;
import it.nextdevs.GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

    List<Postazione> findByTipoEdificio_Citta(TipoPostazione tipoPostazione, String citta);

}
