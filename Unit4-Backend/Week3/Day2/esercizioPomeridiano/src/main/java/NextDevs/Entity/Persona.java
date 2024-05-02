package NextDevs.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private String cognome;

    private String email;

    @Column(name = "data_di_nascita")
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING)
    @Column(name = "sesso")
    private Sesso sesso;

    @OneToMany(mappedBy = "persone")
    @JoinColumn(name = "partecipazione_id")
    private List<Persona> partecipazioni;

    public Persona(int id, String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso, List<Persona> listaPartecipazioni) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.partecipazioni = listaPartecipazioni;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public List<Persona> getListaPartecipazioni() {
        return partecipazioni;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public void setListaPartecipazioni(List<Persona> listaPartecipazioni) {
        this.partecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso=" + sesso +
                ", listaPartecipazioni=" + partecipazioni +
                '}';
    }
}
