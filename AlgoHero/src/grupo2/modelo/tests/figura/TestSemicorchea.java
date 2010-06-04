package grupo2.modelo.tests.figura;

import static org.junit.Assert.*;
import grupo2.modelo.figura.*;
import org.junit.Test;

//SE ESTA USANDO JUNIT 4

public class TestSemicorchea {

	@Test
	public void testGetDuracion() {
		// Creo la figura Semicorchea
		Figura unaFigura = new Semicorchea();
		
		// La figura Semicorchea tiene una duracion de 0.25 Negras
		assertEquals("Mal inicializada la duracion", 0.25, unaFigura.getDuracion(), 0.00001);
	}

}
