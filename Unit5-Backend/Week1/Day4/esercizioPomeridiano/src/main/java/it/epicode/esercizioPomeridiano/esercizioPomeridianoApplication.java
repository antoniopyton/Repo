package it.epicode.esercizioPomeridiano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class esercizioPomeridianoApplication {

	public static void main(String[] args) {

		SpringApplication.run(esercizioPomeridianoApplication.class, args);

//		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		Menu menu = ctx.getBean(Menu.class);
//
//		menu.stampaMenu();
	}

}
