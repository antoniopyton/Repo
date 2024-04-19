package it.epicode;

public class Audio extends  ElementoMultimediale{
    public Audio(String title, int duration, int volume) {
        super(title, duration, volume);
    }

    public void play() {
        int counter = 0;
        while (counter < this.getDuration()) {
            String volume = "!".repeat(Math.max(0, this.getVolume()));
            counter++;
            System.out.println(this.getTitle() + " " + volume);

        }

    }

    public void alzaVolume() {
        if(this.getVolume() < 10) {
            this.setVolume(this.getVolume() + 1);
        }
    }

    public void abbassaVolume() {
        if(this.getVolume() > 0) {
            this.setVolume(this.getVolume() - 1);
        }
    }
}
