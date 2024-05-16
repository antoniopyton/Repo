package it.nextdevs.mattina;

import it.nextdevs.mattina.Bean.Aula;
import it.nextdevs.mattina.Bean.Dispositivo;
import it.nextdevs.mattina.Bean.Scuola;
import it.nextdevs.mattina.Bean.Studente;
import it.nextdevs.mattina.appConfig.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MattinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MattinaApplication.class, args);

	}

}
