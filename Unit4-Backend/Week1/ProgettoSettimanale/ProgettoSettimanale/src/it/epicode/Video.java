package it.epicode;

public class Video  extends  ElementoMultimediale implements AudioVideo, VideoImmagine{
    private int luminosita;
    public Video(String title, int duration, int volume, int luminosita) {
        super(title, duration, volume);
        this.luminosita = luminosita;
    }

    public void alzaLuminosita() {
        if(this.luminosita < 10) {
            this.luminosita += 1;
        }
    }

    public void abbassaLuminosita() {
        if(this.luminosita > 0) {
            this.luminosita -= 1;
        }
    }



    public void abbassaVolume() {
        if(this.getVolume() > 0) {
            this.setVolume(this.getVolume() - 1);
        }
    }


    public void alzaVolume() {
        if (this.getVolume() < 10) {
            this.setVolume(this.getVolume() + 1);
        }
    }


    public void play() {
        int counter = 0;
        while (counter < this.getDuration()) {
            String volume = "!".repeat(Math.max(0, this.getVolume()));
            String luminosita = "*".repeat(Math.max(0, this.luminosita));
            counter++;
            System.out.println(this.getTitle() + " " + volume + luminosita);

        }

    }
}
