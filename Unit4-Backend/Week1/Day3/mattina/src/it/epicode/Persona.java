package it.epicode;

public class Persona {
    public String nome;

    public String cognome;

    public int eta;

    public static int contatore;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        contatore++;
    }
}
