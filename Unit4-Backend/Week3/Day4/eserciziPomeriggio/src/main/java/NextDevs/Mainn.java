package NextDevs;

import NextDevs.Dao.EventooDao;
import NextDevs.Dao.LocationDao;
import NextDevs.Dao.PartecipazioneDao;
import NextDevs.Dao.PersonaDao;
import NextDevs.Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;

public class Mainn {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizio03_05");
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

        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
        partitaDiCalcio.setSquadraCasa("Napoli");
        partitaDiCalcio.setSquadraOspite("Salernitana");
        partitaDiCalcio.setSquadraVincente("Napoli");
        partitaDiCalcio.setGoalCasa("3");
        partitaDiCalcio.setGoalOspite("0");
        partitaDiCalcio.setDescrizione("Napoli vs Salernitana, sfida salvezza per i granata");
        partitaDiCalcio.setTitolo("Napoli vs Salernitana");
        partitaDiCalcio.setNumeroMassimoPartecipanti(50000);
        partitaDiCalcio.setDataEvento(LocalDate.of(2026,5,6));
        eventooDao.save(partitaDiCalcio);


        Concerto concerto = new Concerto();
        concerto.setGenere(Genere.POP);
        concerto.setInStreaming(true);
        concerto.setNumeroMassimoPartecipanti(20000);
        concerto.setDataEvento(LocalDate.of(2026,5,6));
        concerto.setTitolo("Civico97 in Concerto: Stadi tour");
        eventooDao.save(concerto);

        Query query = em.createQuery("select c from Concerto c where c.inStreaming=:valore");

        Query query2 = em.createQuery("select c from Concerto c where c.inStreaming=:valore");

        Query query3 = em.createQuery("select p from PartitaDiCalcio p where p.goalCasa >p.goalOspite");

        Query query4 = em.createQuery("select g from GaraDiAtletica g where g.vincitore =:persona");


    }

}
