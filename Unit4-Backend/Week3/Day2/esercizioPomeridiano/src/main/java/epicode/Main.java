package epicode;

import epicode.dao.StudenteDao;
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

        Studente s1 = new Studente();
        s1.setNome("Antonio");
        s1.setCognome("Copetti");
        s1.setIndirizzo("Traversa via cittadella 15");
        s1.setDataNascita(LocalDate.of(1999, 1, 4));

        //dao.save(s1);

        Studente s2 = dao.getById(1);
        System.out.println(s2);

        s2.setIndirizzo("Via Cittadella");

        //dao.save(s2);

        dao.delete(s2);

    }

}
