package it.nextdevs.esercizioPomeridiano;

import it.nextdevs.esercizioPomeridiano.Bean.Bevanda;
import it.nextdevs.esercizioPomeridiano.Bean.Menu;
import it.nextdevs.esercizioPomeridiano.Bean.Pizza;
import it.nextdevs.esercizioPomeridiano.Bean.Topping;
import it.nextdevs.esercizioPomeridiano.appConfig.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);


		Menu menu = ctx.getBean("menu", Menu.class);
		System.out.println(menu);

		Topping topping = ctx.getBean("wurstel", Topping.class);

		Topping topping2 = ctx.getBean("sugo", Topping.class);

		Topping topping3 = ctx.getBean("patatine_fritte", Topping.class);

		Topping topping4 = ctx.getBean("salame_piccante", Topping.class);

		Topping topping5 = ctx.getBean("salsiccia", Topping.class);

		Topping topping6 = ctx.getBean("friarielli", Topping.class);

		System.out.println("LISTA DEI TOPPINGS");
		System.out.println(topping);
		System.out.println("----------");
		System.out.println(topping2);
		System.out.println("----------");
		System.out.println(topping3);
		System.out.println("----------");
		System.out.println(topping4);
		System.out.println("----------");
		System.out.println(topping5);
		System.out.println("----------");
		System.out.println(topping6);

		Pizza pizza = ctx.getBean("margherita", Pizza.class);

		Pizza pizza2 = ctx.getBean("wurstel_e_patatine", Pizza.class);

		Pizza pizza3 = ctx.getBean("diavola", Pizza.class);

		Pizza pizza4 = ctx.getBean("sasiccefriariell", Pizza.class);

		System.out.println("LISTA PIZZE");
		System.out.println("----------");
		System.out.println(pizza);
		System.out.println("----------");
		System.out.println(pizza2);
		System.out.println("----------");
		System.out.println(pizza3);
		System.out.println("----------");
		System.out.println(pizza4);
		System.out.println("----------");

		Bevanda bevanda = ctx.getBean("cocacola_33", Bevanda.class);

		Bevanda bevanda2 = ctx.getBean("cocacola_66", Bevanda.class);

		Bevanda bevanda3 = ctx.getBean("heineken_33", Bevanda.class);

		Bevanda bevanda4 = ctx.getBean("heineken_66", Bevanda.class);


		System.out.println("LISTA BEVANDE");
		System.out.println(bevanda);
		System.out.println("----------");
		System.out.println(bevanda2);
		System.out.println("----------");
		System.out.println(bevanda3);
		System.out.println("----------");
		System.out.println(bevanda4);



	}

}
