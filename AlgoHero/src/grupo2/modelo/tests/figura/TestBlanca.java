package grupo2.modelo.tests.figura;

import static org.junit.Assert.*;
import grupo2.modelo.figura.*;

import org.junit.Test;

// SE ESTA USANDO JUNIT 4

public class TestBlanca {
	
	@Test
	public void testGetDuracion(){
		// Creo la figura Blanca
		Figura unaFigura = new Blanca();
		
		// La figura Blanca tiene una duracion de 2 Negras
		assertEquals("Mal inicializada la duracion", 2.00, unaFigura.getDuracion(), 0.00001);
	}
	
}
