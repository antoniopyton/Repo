package it.epicode.esercizioPomeridiano.bean;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ingrediente extends VoceDiMenu{

    @Id
    @GeneratedValue
    private int id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}
