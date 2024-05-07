package NextDevs;

import NextDevs.Dao.CatalogoDao;
import NextDevs.Dao.PrestitoDao;
import NextDevs.Dao.UtenteDao;
import NextDevs.Entity.*;
import NextDevs.Enum.Periodicita;
import NextDevs.Exceptions.ExceptionISBNErrato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ExceptionISBNErrato {
        Libri libro1 = new Libri("01", "Il signore degli Anelli La Compagnia dell'anello", LocalDate.of(1996, 1, 1), 250, "Tolkien", "Fantasy");
        Libri libro2 = new Libri("02", "Il signore degli Anelli Le Due Torri", LocalDate.of(1999, 1, 1), 420, "Tolkien", "Fantasy");
        Libri libro3 = new Libri("03", "Star Wars La Minaccia Fantasma", LocalDate.of(1996, 1, 1), 350, "George Lucas", "Fantascienza");
        Libri libro4 = new Libri("04", "Il signore degli Il Ritorno del Re", LocalDate.of(2002, 1, 1), 350, "Tolkien", "Fantasy");
        Libri libro5 = new Libri("05", "Le avventure di Tom Bombadil", LocalDate.of(1998, 1, 1), 220, "Tolkien", "Fantasy");
        Libri libro6 = new Libri("06", "Star Wars Rogue One", LocalDate.of(2005, 1, 1), 270, "George Lucas", "Fantascienza");
        Libri libro7 = new Libri("07", "Il Silmarillion", LocalDate.of(1999, 1, 1), 150, "Tolkien", "Fantasy");
        Libri libro8 = new Libri("08", "Lo Hobbit Un viaggio Inaspettato", LocalDate.of(1992, 1, 1), 420, "Tolkien", "Fantasy");
        Libri libro9 = new Libri("09", "The Mandalorian", LocalDate.of(2006, 1, 1), 290, "George Lucas", "Fantascienza");


        Riviste rivista1 = new Riviste("10", "Vanity Fair", LocalDate.of(1980, 1, 1), 80, Periodicita.SETTIMANALE);
        Riviste rivista2 = new Riviste("11", "Playboy", LocalDate.of(1980, 1, 1), 40, Periodicita.MENSILE);
        Riviste rivista3 = new Riviste("12", "Giallo Zafferano", LocalDate.of(2015, 1, 1), 50, Periodicita.SETTIMANALE);
        Riviste rivista4 = new Riviste("13", "La settimana Enigmistica", LocalDate.of(2005, 1, 1), 60, Periodicita.MENSILE);
        Riviste rivista5 = new Riviste("14", "Ciak Magazine", LocalDate.of(1990, 1, 1), 80, Periodicita.SETTIMANALE);
        Riviste rivista6 = new Riviste("15", "Il BRO CODE", LocalDate.of(2003, 1, 1), 180, Periodicita.SEMESTRALE);
        Riviste rivista7 = new Riviste("16", "DiPiù TV", LocalDate.of(2000, 1, 1), 50, Periodicita.SETTIMANALE);
        Riviste rivista8 = new Riviste("17", "National Geographic", LocalDate.of(1980, 1, 1), 120, Periodicita.MENSILE);

        List<Catalogo> prodotti = new ArrayList<>(List.of(libro1, libro2, libro3, libro4, libro5, libro6, libro7, libro8, libro9
        , rivista1, rivista2, rivista3, rivista4, rivista5, rivista6, rivista7, rivista8));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoSettimanaleW3");
        EntityManager em = emf.createEntityManager();

        UtenteDao utenteDao = new UtenteDao(em);

        PrestitoDao prestitoDao = new PrestitoDao(em);

        CatalogoDao catalogoDao = new CatalogoDao(em);

        prodotti.forEach(p -> {
            if (catalogoDao.getByIsbn(p.getCodiceISBN()) == null) {
                catalogoDao.save(p);
                System.out.println("aggiunto prodotto all'archivio. ISBN: " + p.getCodiceISBN());
            } else {
                catalogoDao.update(p);
                System.out.println("Aggiornato prodotto all'archivio. ISBN: " + p.getCodiceISBN());
            }
        });

        catalogoDao.delete("03");
        catalogoDao.delete("20");

        Catalogo findLibro = catalogoDao.getByIsbn("05");
        if (findLibro != null) {
            System.out.println(findLibro);
        } else {
            System.err.println("Libro non trovato");
        }

        List<Catalogo> findAnnoPub = catalogoDao.findByYear(2005);
        System.out.println("------------------------------------------------");
        System.out.println("Prodotti trovati per anno di pubblicazione indicato:");
        findAnnoPub.forEach(System.out::println);

        List<Catalogo> findAutore = catalogoDao.findByAuthor("Tolkien");
        System.out.println("------------------------------------------------");
        System.out.println("Prodotti trovati per autore indicato:" );
        findAutore.forEach(System.out::println);


        List<Catalogo> findTitolo = catalogoDao.findByTitle("Il signore");
        System.out.println("------------------------------------------------");
        System.out.println("Prodotti trovati per titolo indicato:");
        findTitolo.forEach(System.out::println);

        Utente utente1 = new Utente("Antonio", "Copetti", LocalDate.of(1999,1, 4), 1);
        Utente utente2 = new Utente("Mario", "Rossi", LocalDate.of(1995,5, 20), 2);
        utenteDao.save(utente1);
        utenteDao.save(utente2);

        Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.of(2024, 1, 1));
        prestito1.setDataRestituzioneEffettiva(LocalDate.of(2024, 4, 25));

        Prestito prestito2 = new Prestito(utente2, libro2, LocalDate.of(2024, 3, 5));
        prestito2.setDataRestituzioneEffettiva(LocalDate.of(2024, 4, 5));

        Prestito prestito3 = new Prestito(utente1, libro3, LocalDate.of(2024, 3, 2));
        prestito3.setDataRestituzioneEffettiva(LocalDate.of(2024, 4, 25));

        Prestito prestito4 = new Prestito(utente2, libro4, LocalDate.of(2024, 2, 22));
        prestito4.setDataRestituzioneEffettiva(LocalDate.of(2024, 3, 15));

        Prestito prestito5 = new Prestito(utente1, libro5, LocalDate.of(2024, 2, 11));
        prestito5.setDataRestituzioneEffettiva(LocalDate.of(2024, 2, 25));

//        prestitoDao.save(prestito1);
//        prestitoDao.save(prestito2);
//        prestitoDao.save(prestito3);
//        prestitoDao.save(prestito4);
//        prestitoDao.save(prestito5);

        prestitoDao.inPrestitoList("01");
        prestitoDao.inPrestitoList("02");
        prestitoDao.inPrestitoList("03");
        prestitoDao.inPrestitoList("04");
        prestitoDao.inPrestitoList("05");

        List<Prestito> prestatiUtente1 = prestitoDao.findPrestatiTesseraUtente(1);
        List<Prestito> prestatiUtente2 = prestitoDao.findPrestatiTesseraUtente(2);

        System.out.println("------------------------------------------------");
        System.out.println("Lista prodotti prestati utente 1");
        prestatiUtente1.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        System.out.println("Lista prodotti prestati utente 2");
        prestatiUtente2.forEach(System.out::println);

        System.out.println("------------------------------------------------");
        System.out.println("Lista prodotti scaduti e non restituiti");
        List<Prestito> prestatiScadutiNonRestituiti = prestitoDao.findPrestitiScadutiNonRestituiti();
        prestatiScadutiNonRestituiti.forEach(System.out::println);


    }





}
