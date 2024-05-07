package NextDevs.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Concerto  extends Eventoo{

    @Enumerated(EnumType.STRING)
    private Genere genere;

    private boolean inStreaming;

    public Concerto(Integer id, String titolo, LocalDate dataEvento, String descrizione, Integer numeroMassimoPartecipanti, TipoEventoo tipoEventoo, Genere genere, boolean inStreaming) {
        super(id, titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEventoo);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto(Genere genere, boolean inStreaming) {
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto() {

    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
