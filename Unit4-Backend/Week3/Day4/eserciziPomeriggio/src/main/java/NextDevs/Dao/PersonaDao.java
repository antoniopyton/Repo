package NextDevs.Dao;

import NextDevs.Entity.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDao {

    private EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(persona);
        et.commit();
    }

    public Persona getPersonaById (int id) {
        return em.find(Persona.class, id);
    }

    public void delete (int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Persona persona = getPersonaById(id);

        if (persona != null) {
            em.remove(persona);
        } else {
            System.out.println("Persona non presente");
        }

        et.commit();
    }

}
