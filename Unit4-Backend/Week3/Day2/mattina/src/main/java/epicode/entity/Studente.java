package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity //solo questa annotazione farà diventare quesat una tabella
@Table(name = "studenti") // NON è OBBLIGATORIO (serve per dare delle informazioni aggiuntive)
public class Studente {

    @Id // questa sarà la chiave primaria
    @GeneratedValue // se vogliamo cambiare la strategia iìautoatica dobbiamo fare (strategy = )
    // ^^ GENERA IN AUTOMATICO LA CHIAVE PRIMARIA
    private int matricola;
    @Column // per cambiare nome (name = "")
    //  se vogliamo metterlo "NOT NULL?"(nullable = false), poi ce se sono altri come unique,length,precision
    private String nome;
    @Column(nullable = false, length = 30)
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

//    @Embedded // variabile creata per fare il one-to-one con l'altra classe
//    private Indirizzo indirizzo;

    @OneToOne // modo per fare il one-to-many (?)
    @JoinColumn (name = "indirizzo_id_fk")
    private Indirizzo indirizzo;

    //LAto proprietario: è sempre quello many e ha la join column
    @ManyToOne
    @JoinColumn(name = "classe_studenti_id_fk")
    private ClasseStudenti classeStudenti;

    @ManyToMany
    @JoinTable(name = "studenti_corsi",
            joinColumns = @JoinColumn(name = "studenti_id"),
            inverseJoinColumns = @JoinColumn(name = "corsi_id"))
    private List<Corso> corsi;

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita, Indirizzo indirizzo) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
    }
    //ricordarsi di fare anche il costruttore vuoto!!
    // può essere utile per creare uno studente vuoto inizialmente e poi inserirci dentro i dati
    public Studente() {}

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    public ClasseStudenti getClasseStudenti() {
        return classeStudenti;
    }

    public void setClasseStudenti(ClasseStudenti classeStudenti) {
        this.classeStudenti = classeStudenti;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
}