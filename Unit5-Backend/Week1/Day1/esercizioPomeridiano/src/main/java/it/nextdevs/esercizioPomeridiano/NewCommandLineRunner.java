package it.nextdevs.esercizioPomeridiano;

import it.nextdevs.esercizioPomeridiano.Bean.Menu;
import it.nextdevs.esercizioPomeridiano.Bean.Ordine;
import it.nextdevs.esercizioPomeridiano.Bean.Tavolo;
import it.nextdevs.esercizioPomeridiano.Enum.StatoOrdine;
import it.nextdevs.esercizioPomeridiano.appConfig.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NewCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        Menu menu = ctx.getBean(Menu.class);
        menu.stampaMenu();

        Tavolo tavolo1 = ctx.getBean("tavolo", Tavolo.class);

        Ordine ordine = new Ordine(5, tavolo1);

        ordine.setNumeroOrdine(1);
        ordine.setDataAcquisizione(LocalDateTime.now());
        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine.setBevande(List.of(menu.getBevande().get(0), menu.getBevande().get(2)));
        ordine.setToppings(List.of(menu.getToppings().get(0), menu.getToppings().get(1)));
        ordine.setPizze(List.of(menu.getPizze().get(0), menu.getPizze().get(1)));

        ordine.stampaOrdine();

    }
}
