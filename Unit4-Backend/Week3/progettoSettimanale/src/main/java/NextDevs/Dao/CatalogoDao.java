package NextDevs.Dao;

import NextDevs.Entity.Catalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CatalogoDao {


    private EntityManager em;

    public CatalogoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo prodotto) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prodotto);
        et.commit();
    }

    public Catalogo getByIsbn (String isbn) {
        return em.find(Catalogo.class, isbn);
    }

    public void update(Catalogo catalogo) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(catalogo);
        et.commit();
    }

    public List<Catalogo> findAll() {
        return em.createQuery("SELECT c FROM Catalogo c", Catalogo.class).getResultList();
    }

    public List<Catalogo> findByTitle(String title) {
        return em.createQuery("SELECT c FROM Catalogo c WHERE titolo like :title", Catalogo.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }

    public List<Catalogo> findByAuthor(String author) {
        return em.createQuery("SELECT c FROM Catalogo c WHERE autore = :author", Catalogo.class)
               .setParameter("author", author).getResultList();
    }

    public List<Catalogo> findByYear(Integer year) {
        return em.createQuery("SELECT c FROM Catalogo c", Catalogo.class)
                .getResultStream()
                .filter(catalogo -> catalogo.getAnnoPubblicazione().getYear() == year)
                .toList();
    }


    public void delete (String isbn) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Catalogo prodotto = getByIsbn(isbn);

        if (prodotto != null) {
            em.remove(prodotto);
        } else {
            System.out.println("Prodotto non presente");
        }

        et.commit();
    }

}
