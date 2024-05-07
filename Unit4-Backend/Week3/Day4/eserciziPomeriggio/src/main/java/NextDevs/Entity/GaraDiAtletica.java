package NextDevs.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Eventoo {

    @ManyToMany(mappedBy = "gare")
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(Integer id, String titolo, LocalDate dataEvento, String descrizione, Integer numeroMassimoPartecipanti, TipoEventoo tipoEventoo, Set<Persona> atleti, Persona vincitore) {
        super(id, titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEventoo);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(Set<Persona> atleti, Persona vincitore) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica() {

    }
}
