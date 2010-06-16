package algo3c1g2.modelo.test.figura;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.figura.*;

// SE ESTA USANDO JUNIT 4

public class RedondaTest {

	@Test
	public void testGetDuracion() {
		// Creo la figura Redonda
		Figura unaFigura = new Redonda();
		
		// La figura Redonda tiene una duracion de 4 Negras
		assertEquals("Mal inicializada la duracion", 4.00, unaFigura.getDuracion(), 0.00001);
	}

}
