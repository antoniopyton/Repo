package it.nextdevs.spring1.Bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Computer extends Dispositivo {

    private int monitor;
    private String cpu;
    private int ram;

}
