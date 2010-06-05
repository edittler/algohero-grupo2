package grupo2.modelo.tests.figura;

import static org.junit.Assert.*;
import grupo2.modelo.figura.*;

import org.junit.Test;

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
