package it.nextdevs.GestionePrenotazioni.appConfig;

import it.nextdevs.GestionePrenotazioni.beans.Edificio;
import it.nextdevs.GestionePrenotazioni.beans.Postazione;
import it.nextdevs.GestionePrenotazioni.beans.Prenotazione;
import it.nextdevs.GestionePrenotazioni.beans.Utente;
import it.nextdevs.GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

//    @Bean("edificio")
//    public Edificio edificio(){
//        Edificio edificio = new Edificio();
//        edificio.setCitta("Napoli");
//        edificio.setIndirizzo("Via Roma");
//        edificio.setNome("Edificio 1");
//        edificio.setPostazioni(List.of(postazione1()));
//        return edificio;
//    }
//
//    public Postazione postazione(){
//        Postazione postazione = new Postazione();
//        postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
//        postazione.setEdificio(edificio());
//        postazione.setNumeroOccupanti(20);
//        postazione.setDescrizione("Il nostro open space è un ambiente moderno e versatile, ideale per il lavoro in smart working. ");
//        return postazione;
//    }
//
//    public Postazione postazione1(){
//        Postazione postazione1 = new Postazione();
//        postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
//        postazione1.setEdificio(edificio());
//        postazione1.setNumeroOccupanti(10);
//        postazione1.setDescrizione("Il nostro interno è un ambiente privato ma versatile, ideale per il lavoro in smart working.");
//        return postazione1;
//    }
//
//    public Postazione postazione2(){
//        Postazione postazione2 = new Postazione();
//        postazione2.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
//        postazione2.setEdificio(edificio());
//        postazione2.setNumeroOccupanti(15);
//        postazione2.setDescrizione("La nostra Sala Riunioni è uno spazio moderno e versatile, ideale per il qualsiasi tipo di riunione.");
//        return postazione2;
//    }
//
//    public Prenotazione prenotazione(){
//        Prenotazione prenotazione = new Prenotazione();
//        prenotazione.setPostazione(postazione());
//        prenotazione.setId(1);
//        prenotazione.setUtente(utente());
//        return prenotazione;
//    }
//
//    public Prenotazione prenotazione1(){
//        Prenotazione prenotazione1 = new Prenotazione();
//        prenotazione1.setPostazione(postazione2());
//        prenotazione1.setId(2);
//        prenotazione1.setUtente(utente1());
//        return prenotazione1;
//    }
//
//
//    public Utente utente(){
//        Utente utente = new Utente();
//        utente.setNomeCompleto("Antonio Copetti");
//        utente.setUsername("antoniopyton");
//        utente.setPrenotazioni(List.of(prenotazione()));
//        return utente;
//    }
//
//    public Utente utente1(){
//        Utente utente1 = new Utente();
//        utente1.setNomeCompleto("Luigi Copetti");
//        utente1.setUsername("luigimachine");
//        utente1.setPrenotazioni(List.of(prenotazione()));
//        return utente1;
//    }


}
