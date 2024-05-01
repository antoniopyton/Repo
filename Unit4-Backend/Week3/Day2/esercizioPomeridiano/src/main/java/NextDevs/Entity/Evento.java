package NextDevs.Entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name ="eventi")
public class Evento {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titolo;


    private LocalDate dataEvento;

    @Column(length = 1000)
    private String descrizione;

    private Integer numeroMassimoPartecipanti;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    public Evento(Integer id, String titolo, LocalDate dataEvento, String descrizione, Integer numeroMassimoPartecipanti, TipoEvento tipoEvento) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.tipoEvento = tipoEvento;
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


    public TipoEvento getTipoEvento() {
        return tipoEvento;
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

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", tipoEvento=" + tipoEvento +
                '}';
    }

    public Evento() {

    }

    }
