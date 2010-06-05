package grupo2.modelo.tests.figura;

import static org.junit.Assert.*;
import grupo2.modelo.figura.*;
import org.junit.Test;

//SE ESTA USANDO JUNIT 4

public class FusaTest {

	@Test
	public void testGetDuracion() {
		// Creo la figura Fusa
		Figura unaFigura = new Fusa();
		
		// La figura Fusa tiene una duracion de 0.125 Negras
		assertEquals("Mal inicializada la duracion", 0.125, unaFigura.getDuracion(), 0.00001);
	}

}
