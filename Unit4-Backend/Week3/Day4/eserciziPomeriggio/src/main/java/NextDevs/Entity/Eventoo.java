package NextDevs.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name ="eventi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Eventoo {

    @Id
    @GeneratedValue
    //da usare quando la generation type è SEQUENCE
    //@SequenceGenerator(name="eventi_id_sequence",initialValue = 1, allocationSize = 1)
    private Integer id;


    private String titolo;

    private LocalDate dataEvento;

    @Column(nullable = false, length = 1000)
    private String descrizione;


    @Column(name = "numero_massimo_partecipanti")
    private Integer numeroMassimoPartecipanti;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEventoo tipoEventoo;


    @OneToMany(mappedBy = "eventoo")
    private List<Partecipazione> partecipazioni;


    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;



    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Eventoo(Integer id, String titolo, LocalDate dataEvento, String descrizione, Integer numeroMassimoPartecipanti, TipoEventoo tipoEventoo) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.tipoEventoo = tipoEventoo;
    }

    public Integer getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }


    public TipoEventoo getTipoEvento() {
        return tipoEventoo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public void setTipoEvento(TipoEventoo tipoEvento) {
        this.tipoEventoo = tipoEventoo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", tipoEvento=" + tipoEventoo +
                '}';
    }

    public Eventoo() {

    }

}
