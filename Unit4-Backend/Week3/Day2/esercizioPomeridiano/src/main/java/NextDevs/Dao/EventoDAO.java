package NextDevs.Dao;

import NextDevs.Entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private  EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
    }

    public Evento getEventoById (int evento) {
        Evento e = em.find(Evento.class, evento);

        return e;
    }

    public void delete (Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }
}
