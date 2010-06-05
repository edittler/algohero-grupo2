package grupo2.modelo.tests;

import static org.junit.Assert.*;
import org.junit.*;

import grupo2.modelo.constantes.*;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;


public class NotaTest {

	@Test
	public void testConstructor(){
		
		Nota unaNota = new Do();
		assertTrue(unaNota.getFrecuencia()==Constantes.FRECUENCIA_DO);
		assertTrue(unaNota.getDuracion()==Constantes.NEGRA);
		
		unaNota = new SolSostenido(new Blanca());
		
		assertTrue(unaNota.getFrecuencia()==Constantes.FRECUENCIA_SOL_SOSTENIDO);
		assertTrue(unaNota.getDuracion()==Constantes.BLANCA);
	}
	
}
