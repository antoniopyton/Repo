package it.nextdevs.mattina.Bean;

import it.nextdevs.mattina.MattinaApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        //accediamo al contesto di Spring
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MattinaApplication.class);

//		//recuperiamo dal contesto il been creato da spring
//		Studente studente = ctx.getBean(Studente.class);
//
//		Studente studente2 = ctx.getBean(Studente.class);
//
//		studente.setCognome("prova");
//
//		System.out.println(studente == studente2);
//
//		System.out.println(studente);
//
//		System.out.println(studente2);

        Aula aula = ctx.getBean(Aula.class);
        System.out.println(aula);

        Dispositivo dispositivo = ctx.getBean("smartphone", Dispositivo.class);

        System.out.println(dispositivo);

        Scuola scuola = ctx.getBean(Scuola.class);

        System.out.println(scuola);

    }
}
