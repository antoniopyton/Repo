package NextDevs;

import NextDevs.Dao.EventooDao;
import NextDevs.Dao.LocationDao;
import NextDevs.Dao.PartecipazioneDao;
import NextDevs.Dao.PersonaDao;
import NextDevs.Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Mainn {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizio30_04");
        EntityManager em = emf.createEntityManager();

        EventooDao eventooDao = new EventooDao(em);
        LocationDao locationDao = new LocationDao(em);
        PersonaDao personaDao = new PersonaDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);

        Eventoo e1 = new Eventoo();
        e1.setTitolo("Concerto Pinguini Tattici Nucleari");
        e1.setDescrizione("Gran concerto al Pala Partenope di Napoli de I Pinguini Tattici Nucleari, con tanti super ospiti!");
        e1.setDataEvento(LocalDate.of(2024, 5, 20));
        e1.setTipoEvento(TipoEventoo.PUBBLICO);
        e1.setNumeroMassimoPartecipanti(5000);

        eventooDao.save(e1);

        Location location = new Location();
        location.setNome("Circo Massimo");
        location.setCitta("Roma");

        locationDao.save(location);

        e1.setLocation(location);
        eventooDao.save(e1);

        Persona p1 = new Persona();
        p1.setNome("Antonio");
        p1.setCognome("Copetti");
        p1.setEmail("acopetti99@gmail.com");
        p1.setSesso(Sesso.MASCHIO);


        Persona p2 = new Persona();
        p2.setNome("Luigi");
        p2.setCognome("Copetti");
        p2.setEmail("luigi@gmail.com");
        p2.setSesso(Sesso.MASCHIO);

        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setEvento(e1);
        partecipazione.setPersona(p1);
        partecipazione.setStato(Stato.DA_CONFERMARE);

        partecipazioneDao.save(partecipazione);

        Partecipazione partecipazione2 = new Partecipazione();
        partecipazione.setEvento(e1);
        partecipazione.setPersona(p2);
        partecipazione.setStato(Stato.CONFERMATO);

        partecipazioneDao.save(partecipazione2);

    }

}
