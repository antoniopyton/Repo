package it.NextDevs;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Archivio archivio = new Archivio();
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

        archivio.aggiuntaProdotti(libro1);
        archivio.aggiuntaProdotti(libro2);
        archivio.aggiuntaProdotti(libro3);
        archivio.aggiuntaProdotti(libro4);
        archivio.aggiuntaProdotti(libro5);
        archivio.aggiuntaProdotti(libro6);
        archivio.aggiuntaProdotti(libro7);
        archivio.aggiuntaProdotti(libro8);
        archivio.aggiuntaProdotti(libro9);
        archivio.aggiuntaProdotti(rivista1);
        archivio.aggiuntaProdotti(rivista2);
        archivio.aggiuntaProdotti(rivista3);
        archivio.aggiuntaProdotti(rivista4);
        archivio.aggiuntaProdotti(rivista5);
        archivio.aggiuntaProdotti(rivista6);
        archivio.aggiuntaProdotti(rivista7);
        archivio.aggiuntaProdotti(rivista8);

        archivio.rimozionePerISBN("05");

        archivio.ricercaPerISBN("01");

        archivio.ricercaPerAnno(1996);

        archivio.ricercaPerAutore("Tolkien");

        System.out.println(archivio);

    }

}
