package algo3c1g2.modelo.tests.figura;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.figura.*;

// SE ESTA USANDO JUNIT 4

public class BlancaTest {
	
	@Test
	public void testGetDuracion(){
		// Creo la figura Blanca
		Figura unaFigura = new Blanca();
		
		// La figura Blanca tiene una duracion de 2 Negras
		assertEquals("Mal inicializada la duracion", 2.00, unaFigura.getDuracion(), 0.00001);
	}
	
}
