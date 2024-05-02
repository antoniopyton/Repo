package epicode.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classe_studenti")
public class ClasseStudenti {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private int piano;

    //lato inverso: è sempre il lato one e ha la lista
    @OneToMany(mappedBy = "classeStudenti")
    private List<Studente> studenti;

    public ClasseStudenti(int id, String nome, int piano) {
        this.id = id;
        this.nome = nome;
        this.piano = piano;
    }

    public ClasseStudenti() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPiano() {
        return piano;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }
}
