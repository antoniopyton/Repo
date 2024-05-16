package it.nextdevs.mattina;

import it.nextdevs.mattina.Bean.Aula;
import it.nextdevs.mattina.Bean.Studente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class MattinaApplicationTests {

	static ApplicationContext ctx;

	@BeforeAll
	public static void accediAlContesto() {
		ctx = new AnnotationConfigApplicationContext(MattinaApplication.class);
		System.out.println("Accesso al contesto eseguito");
	}

	@Test
	void verificaNomePrimoStudente() {
		Studente s1 = ctx.getBean("Mario",Studente.class);
		Assertions.assertEquals("Mario", s1.getNome());

	}

	@Test
    void verificaNomeSecondoStudente() {
        Studente s2 = ctx.getBean("Pippo",Studente.class);
        Assertions.assertEquals("Pippo", s2.getNome());
    }

	@Test
	public void verificaAulaNotNull() {
		Aula aula1 = ctx.getBean(Aula.class);
		Assertions.assertNotNull(aula1);
	}


	@Test
	public void verificaNumeroStudentiInAula() {
		Aula aula1 = ctx.getBean(Aula.class);
		Assertions.assertEquals(2, aula1.getStudenti().size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"P", "M"})
	public void verificaNumeroStudentiConNomeCheIniziaCon(String inizio) {
		Aula aula = ctx.getBean(Aula.class);
		aula.getStudenti().stream().filter(studente -> studente.getNome().startsWith(inizio)).forEach(System.out::println);
		long numero = aula.getStudenti().stream().filter(studente -> studente.getNome().startsWith(inizio)).count();
		Assertions.assertEquals(1, numero);
	}

	@ParameterizedTest
	@CsvSource({"C,0", "M,1", "L,0", "P,1"})
	public void verificaNumeroStudentiConNomeCheIniziaCon(String inizio, int conteggio) {
		Aula aula = ctx.getBean(Aula.class);
		aula.getStudenti().stream().filter(studente -> studente.getNome().startsWith(inizio)).forEach(System.out::println);
		long numero = aula.getStudenti().stream().filter(studente -> studente.getNome().startsWith(inizio)).count();
		Assertions.assertEquals(conteggio, numero);
	}

	@AfterAll
	public static void chiudiContesto() {
		ctx = null;
		System.out.println("Contesto chiuso");
	}

}
