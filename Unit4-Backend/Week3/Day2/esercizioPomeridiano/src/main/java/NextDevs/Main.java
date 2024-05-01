package NextDevs;

import NextDevs.Dao.EventoDAO;
import NextDevs.Entity.Evento;
import NextDevs.Entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizio30_04");
        EntityManager em = emf.createEntityManager();

        EventoDAO dao = new EventoDAO(em);

        Evento e1 = new Evento();
        e1.setTitolo("Concerto Pinguini Tattici Nucleari");
        e1.setDescrizione("Gran concerto al Pala Partenope di Napoli de I Pinguini Tattici Nucleari, con tanti super ospiti!");
        e1.setDataEvento(LocalDate.of(2024, 5, 20));
        e1.setTipoEvento(TipoEvento.PUBBLICO);
        e1.setNumeroMassimoPartecipanti(5000);

        dao.save(e1);

//        Evento e2 = new Evento();
//        e1.setTitolo("Udinese vs Napoli");
//        e1.setDescrizione("Tanti maxi schermi all'interno dello stadio Diego Armando Maradona, unisciti a noi e partecipa alla festa!");
//        e1.setDataEvento(LocalDate.of(2023, 5, 4));
//        e1.setTipoEvento(TipoEvento.PUBBLICO);
//        e1.setNumeroMassimoPartecipanti(5000);
//
//        dao.save(e2);
//        //MODIFICA AD UN EVENTO GIA' CREATO
//        Evento e2 = dao.getEventoById(1);
//        e2.setNumeroMassimoPartecipanti(4500);
//        dao.save(e2);

        //CREAZIONE NUOVO EVENTO
//        Evento e3 = new Evento();
//        e3.setTitolo("Udinese vs Napoli");
//        e3.setDataEvento(LocalDate.of(2023, 5, 4));
//        e3.setDescrizione("Tanti maxi schermi all'interno dello stadio Diego Armando Maradona, unisciti a noi e partecipa alla festa!");
//        e3.setTipoEvento(TipoEvento.PUBBLICO);
//
//        dao.save(e3);

//        Evento e4 = new Evento();
//        e3.setTitolo("Cena di lavoro");
//        e3.setDataEvento(LocalDate.of(2024, 5, 4));
//        e3.setTipoEvento(TipoEvento.PRIVATO);
//
//        dao.save(e4);
//
//        Evento e5 = new Evento();
//        e3.setTitolo("Incontro con CEO Epicode");
//        e3.setDataEvento(LocalDate.of(2024, 5, 2));
//        e3.setTipoEvento(TipoEvento.PRIVATO);
//
//        dao.save(e5);
//
//        Evento e6 = new Evento();
//        e3.setTitolo("Incontro con CEO Epicode parte due");
//        e3.setDataEvento(LocalDate.of(2024, 5, 3));
//        e3.setTipoEvento(TipoEvento.PRIVATO);
//
//        dao.save(e6);
    }

}
