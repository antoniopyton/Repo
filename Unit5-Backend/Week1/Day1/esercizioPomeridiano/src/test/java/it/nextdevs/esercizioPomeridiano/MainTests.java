package it.nextdevs.esercizioPomeridiano;

import it.nextdevs.esercizioPomeridiano.Bean.Tavolo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class MainTests {

	private static ApplicationContext ctx;

	@BeforeAll
	public static void getApplicationContext() {
		ctx = new AnnotationConfigApplicationContext(Main.class);
	}

	@Test
	void verificaCostoCopertoTavolo() {
		Tavolo tavolo = ctx.getBean(Tavolo.class);
		Assertions.assertEquals(2, tavolo.getCoperto());
	}

	@ParameterizedTest
	@CsvSource({"tavolo1,2", "tavolo2,4", "tavolo3,6"})
	public void verificaCostoCopertoPerTuttiITavoli(String tavolo, double coperto) {
		Tavolo tavolo1 = ctx.getBean(tavolo, Tavolo.class);
		Assertions.assertEquals(coperto, tavolo1.getCoperto());
	}

}
