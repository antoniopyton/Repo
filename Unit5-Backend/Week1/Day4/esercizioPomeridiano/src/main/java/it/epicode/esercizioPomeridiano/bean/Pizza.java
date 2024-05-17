package it.epicode.esercizioPomeridiano.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pizza extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @OneToMany(mappedBy = "pizza", fetch = FetchType.EAGER)
    private List<Ingrediente> ingredienti;
    private boolean xl;
}
