package algo3c1g2.modelo.test.figura;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.figura.*;

//SE ESTA USANDO JUNIT 4

public class CorcheaTest {

	@Test
	public void testGetDuracion() {
		// Creo la figura Corchea
		Figura unaFigura = new Corchea();
		
		// La figura Corchea tiene una duracion de 0.5 Negras
		assertEquals("Mal inicializada la duracion", 0.5, unaFigura.getDuracion(), 0.00001);
	}

}
