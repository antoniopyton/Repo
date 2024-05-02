package epicode.dao;

import epicode.entity.Indirizzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class IndirizzoDao {
    private EntityManager em;

    public IndirizzoDao(EntityManager em) {
        this.em = em;
    }

    public void Indirizzosave(Indirizzo indirizzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(indirizzo);
        et.commit();
    }

    public Indirizzo getById(int id) {
        // è una SELECT mascherata, restituirà un oggetto dello stesso tipo della classe
        Indirizzo s = em.find(Indirizzo.class, id);

        return s;
    }

    public void delete(Indirizzo indirizzo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(indirizzo);
        et.commit();
    }
}

