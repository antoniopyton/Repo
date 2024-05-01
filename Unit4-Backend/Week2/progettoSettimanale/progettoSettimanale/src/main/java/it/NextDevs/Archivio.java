package it.NextDevs;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archivio {
    private List<Catalogo> prodotti = new ArrayList<>();

    public void aggiuntaProdotti(Catalogo prodotto) throws ExceptionISBNErrato {

        try {
            if (prodotti.
                    stream()
                    .noneMatch(p -> p.getCodiceISBN()
                            .equals(prodotto.getCodiceISBN()))) {
                this.prodotti.add(prodotto);
            } else {
                System.out.println("Prodotto già esistente");
            }
        } catch (Exception e) {
            throw new ExceptionISBNErrato("Il codice ISBN inserito è errato");
        }

    }

    public void rimozionePerISBN(String isbn) throws ExceptionISBNErrato {

        try {
            if (this.prodotti.removeIf(p -> p.getCodiceISBN().equals(isbn))) {
                System.out.println("Prodotto rimosso con successo!!");
                System.out.println("-------------");
            } else {
                System.out.println("Non puoi rimuovere un articolo con questo Codice ISBN");
            }
        } catch (Exception e) {
            throw new ExceptionISBNErrato("Il codice ISBN inserito è errato");
        }
    }

    public void ricercaPerISBN(String isbn) {

        Optional<String> nomeProdotto = this.prodotti.stream()
                .filter(p -> p.getCodiceISBN().equals(isbn))
                .map(Catalogo::getTitolo)
                .findFirst();

        if (nomeProdotto.isPresent()) {
            System.out.println("Il nome del prodotto è: " + nomeProdotto.get());
            System.out.println("-------------");
        } else {
            System.out.println("Nessun prodotto trovato per l'ISBN fornito.");
        }

    }

    public void ricercaPerAnno(Integer anno) {

        List<String> prodottiPerAnno = this.prodotti.stream()
                .filter(p -> p.getAnnoPubblicazione().getYear() == (anno))
                .map(Catalogo::getTitolo)
                .toList();

        if (!prodottiPerAnno.isEmpty()) {
            System.out.println("I seguenti film sono stati prodotti nell'anno fornito: ");
            for (String titolo : prodottiPerAnno) {
                System.out.println(titolo);
            }
            System.out.println("-------------");
        } else {
            System.out.println("Nessun prodotto trovato con l'anno fornito.");
        }
    }

    public void ricercaPerAutore(String autore) {

        List<String> prodottiPerAutore = this.prodotti.stream()
                .filter(p -> p instanceof Libri)
                .map(p -> (Libri) p).filter(a -> a.getAutore().equals(autore))
                .map(Catalogo::getTitolo)
                .toList();

        if (!prodottiPerAutore.isEmpty()) {
            System.out.println("I seguenti film sono stati prodotti dall'autore cercato: ");
            for (String titolo : prodottiPerAutore) {
                System.out.println(titolo);
            }
            System.out.println("-------------");
        } else {
            System.out.println("Nessun prodotto trovato con l'autore fornito.");
        }
    }

    public void salvaSuDisco(String nomeFile) throws IOException {
        String data = prodotti.stream()
                .map(prodotto -> {
                    if (prodotto instanceof Libri) {
                        return this.libro((Libri) prodotto);
                    } else if (prodotto instanceof Riviste) {
                        return this.rivista((Riviste) prodotto);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.joining(System.lineSeparator()));
        FileUtils.writeStringToFile(new File(nomeFile), data, Charset.defaultCharset());
    }

    public List<Catalogo> caricaDaDisco(String nomeFile) throws IOException {
        List<String> lines = FileUtils.readLines(new File(nomeFile), Charset.defaultCharset());
        return lines.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    if (parts.length == 6) {
                        String isbn = parts[0];
                        String titolo = parts[1];
                        LocalDate annoPubblicazione = LocalDate.parse(parts[2]);
                        int numPagine = Integer.parseInt(parts[3]);
                        String autore = parts[4];
                        String genere = parts[5];
                        return new Libri(isbn, titolo, annoPubblicazione, numPagine, autore, genere);
                    } else if (parts.length == 5) {
                        String isbn = parts[0];
                        String titolo = parts[1];
                        LocalDate annoPubblicazione = LocalDate.parse(parts[2]);
                        int numPagine = Integer.parseInt(parts[3]);
                        String periodicita = parts[4];
                        if (periodicita != null) {
                            return new Riviste(isbn, titolo, annoPubblicazione, numPagine,
                                    Periodicita.fromString(periodicita));
                        }
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private String libro(Libri book) {
        return book.getCodiceISBN() +
                "," + book.getTitolo() +
                "," + book.getAnnoPubblicazione() +
                "," + book.getNumeroPagine() +
                "," + book.getAutore() +
                "," + book.getGenere();
    }

    private String rivista(Riviste news) {
        return news.getCodiceISBN() +
                "," + news.getTitolo() +
                "," + news.getAnnoPubblicazione() +
                "," + news.getNumeroPagine() +
                "," + news.getPeriodicita();
    }

    @Override
    public String toString() {
        return "Archivio{" +
                "prodotti=" + prodotti +
                '}';
    }
}
