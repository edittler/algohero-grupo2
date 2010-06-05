package grupo2.modelo.tests.figura;

import static org.junit.Assert.*;
import grupo2.modelo.figura.*;
import org.junit.Test;

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
