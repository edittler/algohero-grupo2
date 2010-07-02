package algo3c1g2.modelo.test.figura;

import static org.junit.Assert.*;
import org.junit.Test;

import algo3c1g2.modelo.figura.*;


public class EqualsFiguraTest {
	
	@Test
	public void testEqualsCorrecto1(){
		Figura unaFigura = new Blanca();
		Figura otraFigura = new Blanca();
		
		//Las figuras son iguales, la comparacion debe dar verdadero
		assertTrue(unaFigura.equals(otraFigura));
	}
	
	@Test
	public void testEqualsIncorrecto1(){
		Figura unaFigura = new Blanca();
		Figura otraFigura = new Negra();
		
		//Las figuras son distintas, la comparacion debe dar falso
		assertFalse(unaFigura.equals(otraFigura));
	}

}
