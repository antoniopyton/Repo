package it.nextdevs.mattina;

import it.nextdevs.mattina.Bean.Computer;
import it.nextdevs.mattina.Bean.Smartphone;
import it.nextdevs.mattina.Bean.Studente;
import it.nextdevs.mattina.service.DispositivoService;
import it.nextdevs.mattina.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private StudenteService studenteService;

    @Autowired
    private DispositivoService dispositivoService;

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MattinaApplication.class);

        Studente studente = ctx.getBean("Mario", Studente.class);
        studenteService.inserisciStudente(studente);

        Studente studente2 = ctx.getBean("Pippo", Studente.class);
        studenteService.inserisciStudente(studente2);

        Computer computer = ctx.getBean("computer", Computer.class);
        computer.setStudente(studente);
        dispositivoService.inserisciDispositivo(computer);

        Smartphone smartphone = ctx.getBean("smartphone", Smartphone.class);
        smartphone.setStudente(studente2);
        dispositivoService.inserisciDispositivo(smartphone);

        System.out.println(studenteService.getStudentiByNome("Mario"));

        System.out.println(studenteService.getStudentiByNomeLike("%o"));

        System.out.println(dispositivoService.getComputerByRamLessThan(32));

        System.out.println(dispositivoService.getDispositiviOrderByNome());
    }
}
