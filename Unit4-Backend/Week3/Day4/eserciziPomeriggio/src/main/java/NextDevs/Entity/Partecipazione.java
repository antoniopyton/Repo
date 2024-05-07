package NextDevs.Entity;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "eventoo_id")
    private Eventoo eventoo;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(int id, Persona persona, Eventoo eventoo, Stato stato) {
        this.persona = persona;
        this.eventoo = eventoo;
        this.stato = stato;
    }

    public Partecipazione() {

    }

    public int getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Eventoo getEventoo() {
        return eventoo;
    }

    public Stato getStato() {
        return stato;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEvento(Eventoo evento) {
        this.eventoo = eventoo;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
