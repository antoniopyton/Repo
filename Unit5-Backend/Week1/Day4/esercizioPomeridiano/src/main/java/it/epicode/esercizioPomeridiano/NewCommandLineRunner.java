package it.epicode.esercizioPomeridiano;

import it.epicode.esercizioPomeridiano.bean.*;
import it.epicode.esercizioPomeridiano.enumeration.StatoOrdine;
import it.epicode.esercizioPomeridiano.service.IngredienteService;
import it.epicode.esercizioPomeridiano.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class NewCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private IngredienteService ingredienteService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(esercizioPomeridianoApplication.class);

        Menu menu = ctx.getBean(Menu.class);
        menu.stampaMenu();
//
//        Tavolo tavolo1 = ctx.getBean("tavolo1", Tavolo.class);
//
//        Ordine ordine = new Ordine(5, tavolo1);
//
//        Tavolo tavolo2 = ctx.getBean("tavolo2", Tavolo.class);
//
//        Ordine ordine2 = new Ordine(7, tavolo2);
//
//        ordine.setNumeroOrdine(1);
//        ordine.setDataAcquisizione(LocalDateTime.now());
//        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
//        ordine.setBevande(List.of(menu.getBevande().get(0), menu.getBevande().get(1)));
//        ordine.setIngredienti(List.of(menu.getIngredienti().get(0), menu.getIngredienti().get(1)));
//        ordine.setPizze(List.of(menu.getPizze().get(0), menu.getPizze().get(0), menu.getPizze().get(1), menu.getPizze().get(1)));
//
//
//        ordine.setNumeroOrdine(2);
//        ordine.setDataAcquisizione(LocalDateTime.now());
//        ordine.setStatoOrdine(StatoOrdine.IN_CORSO);
//        ordine.setBevande(List.of(menu.getBevande().get(0), menu.getBevande().get(1), menu.getBevande().get(0), menu.getBevande().get(1), menu.getBevande().get(2), menu.getBevande().get(2)));
//        ordine.setIngredienti(List.of(menu.getIngredienti().get(0), menu.getIngredienti().get(1),menu.getIngredienti().get(2), menu.getIngredienti().get(3), menu.getIngredienti().get(4), menu.getIngredienti().get(5), menu.getIngredienti().get(6)));
//        ordine.setPizze(List.of(menu.getPizze().get(0), menu.getPizze().get(0), menu.getPizze().get(1), menu.getPizze().get(1),  menu.getPizze().get(2), menu.getPizze().get(3)));
//
//
//        ordine.stampaOrdine();
//        ordine2.stampaOrdine();


          Pizza pizza = ctx.getBean("sasiccefriariell", Pizza.class);
          pizzaService.inserisciPizza(pizza);

          Pizza pizza2 = ctx.getBean("margherita", Pizza.class);
          pizzaService.inserisciPizza(pizza2);

          Pizza pizza3 = ctx.getBean("wurstel_e_patatine", Pizza.class);
          pizzaService.inserisciPizza(pizza3);

          Pizza pizza4 = ctx.getBean("diavola", Pizza.class);
          pizzaService.inserisciPizza(pizza4);

          Ingrediente ingrediente = ctx.getBean("mozzarella", Ingrediente.class);
          ingredienteService.inserisciIngrediente(ingrediente);

          Ingrediente ingrediente2 = ctx.getBean("patatine_fritte", Ingrediente.class);
          ingredienteService.inserisciIngrediente(ingrediente2);

          Ingrediente ingrediente3 = ctx.getBean("wurstel", Ingrediente.class);
          ingredienteService.inserisciIngrediente(ingrediente3);

          Ingrediente ingrediente4 = ctx.getBean("friarielli", Ingrediente.class);
          ingredienteService.inserisciIngrediente(ingrediente4);


    }
}
