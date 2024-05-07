package NextDevs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Eventoo{

    @Column(name = "squadra_casa")
    private String squadraCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;


    @Column(name = "squadra_vincente")
    private String squadraVincente;


    @Column(name = "goal_casa")
    private String goalCasa;

    @Column(name = "goal_ospite")
    private String goalOspite;

    public PartitaDiCalcio(Integer id, String titolo, LocalDate dataEvento, String descrizione, Integer numeroMassimoPartecipanti, TipoEventoo tipoEventoo, String squadraCasa, String squadraOspite, String squadraVincente, String goalCasa, String goalOspite) {
        super(id, titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEventoo);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
    }

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente, String goalCasa, String goalOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
    }

    public PartitaDiCalcio() {

    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public String getGoalCasa() {
        return goalCasa;
    }

    public void setGoalCasa(String goalCasa) {
        this.goalCasa = goalCasa;
    }

    public String getGoalOspite() {
        return goalOspite;
    }

    public void setGoalOspite(String goalOspite) {
        this.goalOspite = goalOspite;
    }
}
