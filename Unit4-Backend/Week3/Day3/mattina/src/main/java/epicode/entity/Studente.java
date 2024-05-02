package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue
    private int matricola;

    @Column(nullable = false, length =  30)
    private String nome;

    @Column(nullable = false, length =  30)
    private String cognome;

    @Embedded
    private Indirizzo indirizzo;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public Studente() {

    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }
}
