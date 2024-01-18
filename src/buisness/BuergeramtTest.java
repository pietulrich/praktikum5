package buisness;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.businessBuergeraemter.Buergeramt;

class BuergeramtTest {
	private Buergeramt buergeramt;
	String[] dienst = {"Hauptwohnsitz", "Nebenwohnsitz"};
	
	@BeforeEach
	void setUp() throws Exception {
		this.buergeramt = new Buergeramt("B�rgerb�ro Querenburg", 9, 17, "Querenburger H�he 256", dienst);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.buergeramt = null;
	}

	@Test
	void test() {
		assertTrue(this.buergeramt.getName() == "B�rgerb�ro Querenburg");
		
	}
	
	@Test
	void test2() {
		Throwable T = assertThrows(IllegalArgumentException.class, () -> {new Buergeramt("B�rgerb�ro Querenburg", 9, 17, "Querenburger H�he 256", null);});
		assertEquals("Dienstleistungen dr�fen nicht leer sein!", T.getMessage());
	}

}
