package NextDevs.Dao;

import NextDevs.Entity.Prestito;
import NextDevs.Entity.Riviste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {

    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getByIsbn (String isbn) {
        return em.find(Prestito.class, isbn);
    }

    public void update(Prestito prestito) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(prestito);
        et.commit();
    }

    public List<Prestito> inPrestitoList(String isbn) {
        return em.createQuery("SELECT p FROM Prestito p", Prestito.class)
                .getResultStream().filter(p -> p.getElementoPrestato().getCodiceISBN().equals(isbn)).toList();
    }

//    public List<Prestito> findPrestati() {
//        return em.createQuery("SELECT p FROM Prestito p", Prestito.class)
//                .getResultStream().
//    }

    public List<Prestito> findPrestatiTesseraUtente(int idUtente) {
        return em.createQuery("SELECT p FROM Prestito p", Prestito.class)
               .getResultStream().filter(p -> p.getUtente().getId() == idUtente).toList();
    }

    public List<Prestito> findPrestitiScadutiNonRestituiti() {
        return em.createQuery("SELECT p FROM Prestito p", Prestito.class)
               .getResultStream().filter(p -> p.getDataRestituzionePrevista().isBefore(LocalDate.now()) || p.getDataRestituzioneEffettiva() == null).toList();
    }

    public List<Prestito> findAll() {
        return em.createQuery("SELECT p FROM Prestito p", Prestito.class).getResultList();
    }

    public void delete (String isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Prestito prestito = getByIsbn(isbn);

        if (prestito != null) {
            em.remove(prestito);
        } else {
            System.out.println("Prodotto non presente");
        }

        et.commit();
    }

}
