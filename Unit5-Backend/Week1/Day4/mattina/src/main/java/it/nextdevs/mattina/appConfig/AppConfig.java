package it.nextdevs.mattina.appConfig;

import it.nextdevs.mattina.Bean.Computer;
import it.nextdevs.mattina.Bean.Smartphone;
import it.nextdevs.mattina.Bean.Studente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;


@Configuration
public class AppConfig {

    @Bean("Mario")
    @Primary
//    @Scope("prototype")
    public Studente getStudente(@Value("${studente.nome}") String nome, @Value("${studente.cognome}") String cognome) {
        Studente studente = new Studente();
        studente.setNome(nome);
        studente.setCognome(cognome);
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

    @Bean("computer")
//    @Primary //Con primary sarà la prima cosa che va a recuperare se viene richiamato un dispositivo
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setMonitor(17);
        computer.setMarca("Apple");
        computer.setNome("Prova");
        computer.setCpu("Intel");
        computer.setRam(16);
        return computer;
    }

    @Bean("smartphone")
    public Smartphone getSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setMarca("Samsung");
        smartphone.setNome("S10");
        smartphone.setSchermo(7);
        return smartphone;
    }

//    @Bean
//    public Aula getAula(){
//        Aula aula = new Aula();
//        aula.setNome("A1");
//        aula.setStudenti(List.of(getStudente(), getStudente2()));
//        return aula;
//    }
}
