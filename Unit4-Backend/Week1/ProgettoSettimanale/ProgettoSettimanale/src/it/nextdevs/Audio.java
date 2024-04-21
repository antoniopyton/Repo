package it.nextdevs;

public class Audio extends ElementoMultimediale {
    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);

    }

    public void play() {
        int counter = 0;
        while (counter < this.getDurata()) {
            String volume = "!".repeat(Math.max(0, this.getVolume()));
            counter++;
            System.out.println(this.getTitolo() + " " + volume);
        }
    }

    public void abbassaVolume() {
        if(this.getVolume() > 0) {
            this.setVolume(this.getVolume() - 1);
        }
    }

    public void alzaVolume() {
        if(this.getVolume() < 10) {
            this.setVolume(this.getVolume() + 1);
        }
    }
}
