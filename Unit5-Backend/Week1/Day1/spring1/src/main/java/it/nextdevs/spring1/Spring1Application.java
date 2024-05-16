package it.nextdevs.spring1;

import it.nextdevs.spring1.Bean.Aula;
import it.nextdevs.spring1.Bean.Studente;
import it.nextdevs.spring1.appConfig.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {

		SpringApplication.run(Spring1Application.class, args);

		//accediamo al contesto di Spring
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		//recuperiamo dal contesto il been creato da spring
		Studente studente = ctx.getBean(Studente.class);

		Studente studente2 = ctx.getBean(Studente.class);

		studente.setCognome("prova");

		System.out.println(studente == studente2);

		System.out.println(studente);

		System.out.println(studente2);

		Aula aula = ctx.getBean(Aula.class);
		System.out.println(aula);
	}

}
