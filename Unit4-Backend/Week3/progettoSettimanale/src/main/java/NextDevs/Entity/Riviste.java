package NextDevs.Entity;

import NextDevs.Enum.Periodicita;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "riviste")
public class Riviste extends Catalogo {

    private Periodicita periodicita;

    public Riviste(String codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Riviste () {

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }
}
