package NextDevs.Dao;


import NextDevs.Entity.Eventoo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventooDao {

    private EntityManager em;

    public EventooDao(EntityManager em) {
        this.em = em;
    }

    public void save(Eventoo eventoo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(eventoo);
        et.commit();
    }

    public Eventoo getEventoById (int evento) {
        Eventoo e = em.find(Eventoo.class, evento);

        return e;
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Eventoo eventoo = getEventoById(id);

        if(eventoo!= null) {
            em.remove(eventoo);
        } else {
            System.out.println("Evento non presente");
        }

        et.commit();
    }

}
