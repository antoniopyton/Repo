package it.nextdevs.esercizioPomeridiano.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;

//    private static int cont;

    private String categoria;

    private String titolo;

    private String cover;

    private String contenuto;

    private int tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private Autore autore;

//    public Post(String categoria, String titolo, String contenuto, int tempoDiLettura) {
//        this.categoria = categoria;
//        this.titolo = titolo;
//        this.contenuto = contenuto;
//        this.tempoDiLettura = tempoDiLettura;
//        this.cover = "https://picsum.photos/200/300";
//        cont++;
//        id = cont;
//    }
}
