package it.epicode;

public abstract class ElementoMultimediale {

    private String title;
    private int duration;
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public ElementoMultimediale(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public ElementoMultimediale(String title, int duration, int volume) {
        this.title = title;
        this.duration = duration;
        this.volume = volume;
    }
}
