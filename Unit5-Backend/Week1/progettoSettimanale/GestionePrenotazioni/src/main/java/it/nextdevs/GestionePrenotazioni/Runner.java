package it.nextdevs.GestionePrenotazioni;

import it.nextdevs.GestionePrenotazioni.beans.Edificio;
import it.nextdevs.GestionePrenotazioni.beans.Postazione;
import it.nextdevs.GestionePrenotazioni.beans.Prenotazione;
import it.nextdevs.GestionePrenotazioni.beans.Utente;
import it.nextdevs.GestionePrenotazioni.enums.TipoPostazione;
import it.nextdevs.GestionePrenotazioni.service.EdificioService;
import it.nextdevs.GestionePrenotazioni.service.PostazioneService;
import it.nextdevs.GestionePrenotazioni.service.PrenotazioneService;
import it.nextdevs.GestionePrenotazioni.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);

            Edificio edificio = ctx.getBean(Edificio.class);
            edificio.setCitta("Napoli");
            edificio.setIndirizzo("Via Roma");
            edificio.setNome("Edificio 1");
            edificioService.inserisciEdificio(edificio);


            Postazione postazione = ctx.getBean(Postazione.class);
            postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
            postazione.setEdificio(edificio);
            postazione.setNumeroOccupanti(20);
            postazione.setDescrizione("Il nostro open space è un ambiente moderno e versatile, ideale per il lavoro in smart working. ");
            postazioneService.inserisciPostazione(postazione);


            Postazione postazione1 = ctx.getBean(Postazione.class);
            postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
            postazione1.setEdificio(edificio);
            postazione1.setNumeroOccupanti(10);
            postazione1.setDescrizione("Il nostro interno è un ambiente privato ma versatile, ideale per il lavoro in smart working.");
            postazioneService.inserisciPostazione(postazione1);

            Postazione postazione2 = ctx.getBean(Postazione.class);
            postazione2.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
            postazione2.setEdificio(edificio);
            postazione2.setNumeroOccupanti(15);
            postazione2.setDescrizione("La nostra Sala Riunioni è uno spazio moderno e versatile, ideale per il qualsiasi tipo di riunione.");
            postazioneService.inserisciPostazione(postazione2);


            Utente utente = ctx.getBean(Utente.class);
            utente.setNomeCompleto("Antonio Copetti");
            utente.setUsername("antoniopyton");
            utente.setEmail("acopetti99@gmail.com");
            utenteService.inserisciUtente(utente);

            Utente utente1 = ctx.getBean(Utente.class);
            utente1.setNomeCompleto("Luigi Copetti");
            utente1.setUsername("luigimachine");
            utente1.setEmail("luigi@gmail.com");
            utenteService.inserisciUtente(utente1);


//            Prenotazione prenotazione = ctx.getBean(Prenotazione.class);
//            prenotazione.setPostazione(postazione);
//            prenotazione.setId(1);
//            prenotazione.setUtente(utente);
//            prenotazioneService.inserisciPrenotazione(prenotazione);
//
//
//            Prenotazione prenotazione1 = ctx.getBean(Prenotazione.class);
//            prenotazione1.setPostazione(postazione2);
//            prenotazione1.setId(2);
//            prenotazione1.setUtente(utente1);
//            prenotazioneService.inserisciPrenotazione(prenotazione1);

        


    }
}
