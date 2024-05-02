package epicode.entity;

@Embeddable
public class Indirizzo {
    private String via;
    private String comune;
    private String provincia;

    public Indirizzo(String via, String comune, String provincia) {
        this.via = via;
        this.comune = comune;
        this.provincia = provincia;
    }

    public Indirizzo() {

    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }
}
