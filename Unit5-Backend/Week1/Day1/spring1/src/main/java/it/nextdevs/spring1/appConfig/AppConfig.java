package it.nextdevs.spring1.appConfig;

import it.nextdevs.spring1.Bean.Aula;
import it.nextdevs.spring1.Bean.Computer;
import it.nextdevs.spring1.Bean.Smartphone;
import it.nextdevs.spring1.Bean.Studente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.List;


@Configuration
public class AppConfig {

    @Bean("Mario")
    @Primary
    @Scope("prototype")
    public Studente getStudente() {
        Studente studente = new Studente();
        studente.setNome("Mario");
        studente.setCognome("Rossi");
        studente.setIndirizzo("Via Roma 1");
        studente.setDispositivi(List.of(getComputer(), getSmartphone()));
        return studente;
    }

    @Bean("Pippo")
    public Studente getStudente2() {
        Studente studente = new Studente();
        studente.setNome("Pippo");
        studente.setCognome("Iono");
        studente.setIndirizzo("Via Napoli 2");
        return studente;
    }

    @Bean
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setMonitor(17);
        computer.setMarca("Apple");
        computer.setNome("Prova");
        computer.setCpu("Intel");
        computer.setRam(16);
        return computer;
    }

    @Bean
    public Smartphone getSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setMarca("Samsung");
        smartphone.setNome("S10");
        smartphone.setSchermo(7);
        return smartphone;
    }

    @Bean
    public Aula getAula(){
        Aula aula = new Aula();
        aula.setNome("A1");
        aula.setStudenti(List.of(getStudente(), getStudente2()));
        return aula;
    }
}
