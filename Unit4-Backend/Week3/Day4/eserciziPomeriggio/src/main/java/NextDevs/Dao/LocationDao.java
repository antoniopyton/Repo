package NextDevs.Dao;

import NextDevs.Entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDao {

    private EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(location);
        et.commit();
    }

    public Location getEventoById (int location) {
        Location e = em.find(Location.class, location);

        return e;
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Location location = getEventoById(id);

        if (location != null) {
            em.remove(location);
        } else {
            System.out.println("Evento non presente");
        }

        et.commit();
    }
}
