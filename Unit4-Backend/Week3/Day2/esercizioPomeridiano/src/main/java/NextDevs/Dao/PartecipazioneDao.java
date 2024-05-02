package NextDevs.Dao;

import NextDevs.Entity.Eventoo;
import NextDevs.Entity.Partecipazione;
import NextDevs.Entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDao {

    private EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazione);
        et.commit();
    }

    public Partecipazione getEventoById (int partecipazione) {
        Partecipazione e = em.find(Partecipazione.class, partecipazione);

        return e;
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Partecipazione partecipazione = getEventoById(id);

        if (partecipazione != null) {
            em.remove(partecipazione);
        } else {
            System.out.println("Evento non presente");
        }

        et.commit();
    }
}
