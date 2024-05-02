package NextDevs.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Location {

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private String citta;

    public Location(int id, String nome, String citta) {
        this.id = id;
        this.nome = nome;
        this.citta = citta;
    }

    public Location() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
