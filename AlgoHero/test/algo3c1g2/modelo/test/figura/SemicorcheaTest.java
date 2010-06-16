package algo3c1g2.modelo.test.figura;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.figura.*;

//SE ESTA USANDO JUNIT 4

public class SemicorcheaTest {

	@Test
	public void testGetDuracion() {
		// Creo la figura Semicorchea
		Figura unaFigura = new Semicorchea();
		
		// La figura Semicorchea tiene una duracion de 0.25 Negras
		assertEquals("Mal inicializada la duracion", 0.25, unaFigura.getDuracion(), 0.00001);
	}

}
