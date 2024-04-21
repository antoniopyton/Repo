package it.nextdevs;

public abstract class ElementoMultimediale {
    private int durata;
    private String titolo;
    private int volume;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public ElementoMultimediale(String titolo, int durata, int volume) {
        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;
    }

    public int getDurata() {
        return this.durata;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
