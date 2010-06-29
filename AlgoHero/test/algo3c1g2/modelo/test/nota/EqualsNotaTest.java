package algo3c1g2.modelo.test.nota;

import static org.junit.Assert.*;
import org.junit.Test;

import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.figura.*;

public class EqualsNotaTest {

	@Test
	public void testEqualsCorrecto1(){
		Nota unaNota = new Do(new Blanca());
		Nota otraNota = new Do(new Blanca());
		
		//Las notas son iguales, la comparacion debe dar verdadero
		assertTrue(unaNota.equals(otraNota));
	}
	
	
	@Test
	public void testEqualsCorrecto2(){
		Nota unaNota = new Do(new Blanca());
		Nota otraNota = new Do(new Negra());
		
		//Las notas son iguales, la comparacion debe dar verdadero
		assertTrue(unaNota.equals(otraNota));
	}
	
	@Test
	public void testEqualsIncorrecto1(){
		Nota unaNota = new ReSostenido(new Blanca());
		Nota otraNota = new Do(new Negra());
		
		//Las notas no son iguales, la comparacion debe dar falso
		assertFalse(unaNota.equals(otraNota));
	}
}
