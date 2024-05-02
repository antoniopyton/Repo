package epicode;

import epicode.dao.ClasseStudentiDao;
import epicode.dao.CorsoDao;
import epicode.dao.IndirizzoDao;
import epicode.dao.StudenteDao;
import epicode.entity.ClasseStudenti;
import epicode.entity.Corso;
import epicode.entity.Indirizzo;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mattina02_05");
        EntityManager em = emf.createEntityManager();

        StudenteDao dao = new StudenteDao(em);
        ClasseStudentiDao classeStudentiDao = new ClasseStudentiDao(em);
        CorsoDao corsoDao = new CorsoDao(em);

        // !! QUESTA E PER LA LEZIONE DI JPA CRUD !!
//        Studente s1 = new Studente();
//        s1.setNome("Elena");
//        s1.setCognome("Kekic");
//
//        s1.setDataNascita(LocalDate.of(2004, 12, 30));
//        //dao.save(s1);
//
//        Studente s2 = dao.getById(2);
//        System.out.println(s2);
//
//
//        //dao.save(s2);
//
//        dao.delete(s2);

// !! QUESTA E PER LA LEZIONE DI JPA RELATIONSHIP !!
        Studente s3 = new Studente();
        // mi serviva siccome indirizzo l'ho modificato in modo da diventare una tabella
        IndirizzoDao indirizzoDao = new IndirizzoDao(em);
        s3.setNome("Elena");
        s3.setCognome("Kekic");
        s3.setDataNascita(LocalDate.of(2000, 8, 26));

        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setVia("Via dei Mille");
        indirizzo.setComune("Trieste");
        indirizzo.setProvincia("TS");

        indirizzoDao.Indirizzosave(indirizzo);

        s3.setIndirizzo(indirizzo);

        dao.save(s3);

        ClasseStudenti classeStudenti = new ClasseStudenti();
        classeStudenti.setNome("1B");
        classeStudenti.setPiano(3);

        classeStudentiDao.save(classeStudenti);

        Studente s2 = new Studente();
        s2.setNome("Antonio");
        s2.setCognome("Copetti");
        s2.setDataNascita(LocalDate.of(1999, 4, 1));
        s2.setClasseStudenti(classeStudenti);

        dao.save(s2);

        //creo due corsi e li assegno a tutti gli studenti gia presenti sul db
        Corso c1 = new Corso();
        c1.setNome("Recupero matematica");
        corsoDao.save(c1);

        Corso c2 = new Corso();
        c2.setNome("Cad");
        corsoDao.save(c2);

        //recupero gli studenti dal db
        Studente s1 = dao.getById(4);
        Studente s4 = dao.getById(2);

        //setto su ogni studente la lista di corsi a cui partecipa
        s1.setCorsi(List.of(c1, c2));
        s4.setCorsi(List.of(c1, c2));

        //salvo gli aggiornamenti sugli studenti sul db
        dao.save(s1);
        dao.save(s4);


    }
}

