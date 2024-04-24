package it.nextdevs;

import java.util.ArrayList;

public class Pizza {
    public ArrayList<String> ingredienti;
    public Integer prezzo;
    public String nome;

    public Pizza (String nome, Integer prezzo, ArrayList<String> ingredienti){
        this.nome = nome;
        this.prezzo = prezzo;
        this.ingredienti = ingredienti;
    }

    public ArrayList<String> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(ArrayList<String> ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int kilocalorie() {
        int totalekl = 0;
        for (ArrayList ingredienti: ingrediente){


        }

        return kilocalorie();
    }

}
