package it.epicode;

public class Immagine extends ElementoMultimediale implements VideoImmagine{

    private int luminosita;
    public Immagine(String title, int luminosita) {
        super(title);
        this.luminosita = luminosita;
    }

    @Override
    public void alzaLuminosita() {
        if(this.luminosita < 10) {
            this.luminosita += 1;
        }
    }
    @Override
    public void abbassaLuminosita() {
        if(this.luminosita > 0) {
            this.luminosita -= 1;
        }
    }

    public void show() {
        System.out.println(this.getTitle() + " " + "*".repeat(Math.max(0, this.luminosita)));
    }
}
