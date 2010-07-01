package algo3c1g2.modelo.test.figura;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.figura.*;

//SE ESTA USANDO JUNIT 4

public class NegraTest {

	@Test
	public void testGetDuracion() {
		// Creo la figura Negra
		Figura unaFigura = new Negra();
		
		// La figura Negra tiene una duracion de 1 Negras
		assertEquals("Mal inicializada la duracion", 1.00, unaFigura.getDuracion(), 0.00001);
	}

}
