package NextDevs.Dao;

import NextDevs.Entity.Prestito;
import NextDevs.Entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UtenteDao {

    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getByIsbn (String isbn) {
        return em.find(Utente.class, isbn);
    }

    public void update(Utente utente) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(utente);
        et.commit();
    }

    public List<Utente> findAll() {
        return em.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();
    }

    public void delete (String isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Utente utente = getByIsbn(isbn);

        if (utente != null) {
            em.remove(utente);
        } else {
            System.out.println("Prodotto non presente");
        }

        et.commit();
    }

}
