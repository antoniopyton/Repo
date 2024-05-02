package epicode;

import epicode.dao.IndirizzoDao;
import epicode.dao.StudenteDao;
import epicode.entity.Indirizzo;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao dao = new StudenteDao(em);

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
    }
}

