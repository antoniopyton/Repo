package it.nextdevs.mattina.Bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
public class Smartphone extends Dispositivo{

    private int schermo;


}
