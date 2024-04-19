package it.epicode;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("Darsena", 10, 10);
        audio1.play();

        Video video1 = new Video("Loving can hurt", 20, 5, 3);
        video1.play();

        Immagine immagine1 = new Immagine("Il prigioniero di Azkaban", 7);
        immagine1.show();
    }
}
