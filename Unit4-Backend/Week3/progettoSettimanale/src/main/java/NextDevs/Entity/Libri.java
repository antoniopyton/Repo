package NextDevs.Entity;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libri extends Catalogo {
    private String Autore;
    private String Genere;

    public Libri(String codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        Autore = autore;
        Genere = genere;
    }

    public Libri() {

    }

    public String getAutore() {
        return Autore;
    }

    public String getGenere() {
        return Genere;
    }

    public void setAutore(String autore) {
        Autore = autore;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "Autore='" + Autore + '\'' +
                ", Genere='" + Genere + '\'' +
                '}';
    }
}

