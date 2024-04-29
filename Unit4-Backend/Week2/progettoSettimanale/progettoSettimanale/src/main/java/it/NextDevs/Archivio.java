package it.NextDevs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archivio {
    private List<Catalogo> prodotti = new ArrayList<>();

    public void aggiuntaProdotti(Catalogo prodotto) {

        if (prodotti.
                stream()
                .noneMatch(p -> p.getCodiceISBN()
                        .equals(prodotto.getCodiceISBN()))) {
            this.prodotti.add(prodotto);
        } else {
            System.out.println("Prodotto già esistente");
        }
    }

    public void rimozionePerISBN(String isbn) {

        if (this.prodotti.removeIf(p -> p.getCodiceISBN().equals(isbn))) {
            System.out.println("Prodotto rimosso con successo!!");
            System.out.println("-------------");
        } else {
            System.out.println("Non puoi rimuovere un articolo con questo Codice ISBN");
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

    @Override
    public String toString() {
        return "Archivio{" +
                "prodotti=" + prodotti +
                '}';
    }
}
