package algo3c1g2.modelo.tests.nota;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;

//ACLARACION: SE USO JUNIT 4, POR FAVOR USAR ESA VERSION!!

public class SiTest {

	@Test
	public void testGetFrecuenciaConstructor1() {
		// Se crea la nota Si usando su constructor sin parametros 
		Nota unaNota = new Si();
		
		//Frecuencia caracteristica del tono Si en la octava 3 es de 493 Hz
		assertEquals("Frecuencia inicializada incorrectamente", 493, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetFrecuenciaConstructor2() {
		// Se crea la nota Si estableciendo cualquier figura (en este caso Negra) 
		Nota unaNota = new Si(new Negra());
		
		//Frecuencia caracteristica del tono Si en la octava 3 es de 493 Hz
		assertEquals("Frecuencia inicializada incorrectamente", 493, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetDuracionDefault() {
		// Se crea la nota Si usando su constructor sin parametros 
		Nota unaNota = new Si();
		
		// La duracion de la nota Si por default es 1 Negra
		assertEquals("Duracion inicializada incorrectamente", 1, unaNota.getDuracion(), 0.00001);
	}

	@Test
	public void testGetDuracionRedonda() {
		// Se crea la nota Si y se pasa una figura Redonda 
		Nota unaNota = new Si(new Redonda());
		
		// La duracion de la figura Redonda es de 4 Negras
		assertEquals("Duracion establecida incorrectamente", 4, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionBlanca() {
		// Se crea la nota Si y se pasa una figura Blanca 
		Nota unaNota = new Si(new Blanca());
		
		// La duracion de la figura Blanca es de 2 Negras
		assertEquals("Duracion establecida incorrectamente", 2, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionNegra() {
		// Se crea la nota Si y se pasa una figura Negra 
		Nota unaNota = new Si(new Negra());
		
		// La duracion de la figura Negra es de 1 Negra
		assertEquals("Duracion establecida incorrectamente", 1, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionCorchea() {
		// Se crea la nota Si y se pasa una figura Corchea 
		Nota unaNota = new Si(new Corchea());
		
		// La duracion de la figura Corchea es de 0.5 Negra
		assertEquals("Duracion establecida incorrectamente", 0.5, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionSemicorchea() {
		// Se crea la nota Si y se pasa una figura Semicorchea 
		Nota unaNota = new Si(new Semicorchea());
		
		// La duracion de la figura Semicorchea es de 0.25 Negra
		assertEquals("Duracion establecida incorrectamente", 0.25, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionFusa() {
		// Se crea la nota Si y se pasa una figura Fusa
		Nota unaNota = new Si(new Fusa());
		
		// La duracion de la figura Fusa es de 0.125 Negra
		assertEquals("Duracion establecida incorrectamente", 0.125, unaNota.getDuracion(), 0.00001);
	}
	
}
