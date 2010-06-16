package algo3c1g2.modelo.test.nota;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;

//ACLARACION: SE USO JUNIT 4, POR FAVOR USAR ESA VERSION!!

public class DoSostenidoTest {

	@Test
	public void testGetFrecuenciaConstructor1() {
		// Se crea la nota DoSostenido usando su constructor sin parametros 
		Nota unaNota = new DoSostenido();
		
		//Frecuencia caracteristica del tono Do Sostenido en la octava 3 es de 277 Hz
		assertEquals("Frecuencia inicializada incorrectamente", 277, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetFrecuenciaConstructor2() {
		// Se crea la nota DoSostenido estableciendo cualquier figura (en este caso Negra) 
		Nota unaNota = new DoSostenido(new Negra());
		
		//Frecuencia caracteristica del tono Do Sostenido en la octava 3 es de 277 Hz
		assertEquals("Frecuencia inicializada incorrectamente", 277, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetDuracionDefault() {
		// Se crea la nota DoSostenido usando su constructor sin parametros 
		Nota unaNota = new DoSostenido();
		
		// La duracion de la nota DoSostenido por default es 1 Negra
		assertEquals("Duracion inicializada incorrectamente", 1, unaNota.getDuracion(), 0.00001);
	}

	@Test
	public void testGetDuracionRedonda() {
		// Se crea la nota DoSostenido y se pasa una figura Redonda 
		Nota unaNota = new DoSostenido(new Redonda());
		
		// La duracion de la figura Redonda es de 4 Negras
		assertEquals("Duracion establecida incorrectamente", 4, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionBlanca() {
		// Se crea la nota DoSostenido y se pasa una figura Blanca 
		Nota unaNota = new DoSostenido(new Blanca());
		
		// La duracion de la figura Blanca es de 2 Negras
		assertEquals("Duracion establecida incorrectamente", 2, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioNegra() {
		// Se crea la nota DoSostenido y se pasa una figura Negra
		Nota unaNota = new DoSostenido(new Negra());
		
		// La duracion de la figura Negra es de 1 Negra
		assertEquals("Duracion establecida incorrectamente", 1, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioCorchea() {
		// Se crea la nota DoSostenido y se pasa una figura Corchea
		Nota unaNota = new DoSostenido(new Corchea());
		
		// La duracion de la figura Corchea es de 0.5 Negra
		assertEquals("Duracion establecida incorrectamente", 0.5, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioSemicorchea() {
		// Se crea la nota DoSostenido y se pasa una figura Semicorchea
		Nota unaNota = new DoSostenido(new Semicorchea());
		
		// La duracion de la figura Corchea es de 0.25 Negras
		assertEquals("Duracion establecida incorrectamente", 0.25, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioFusa() {
		// Se crea la nota DoSostenido y se pasa una figura Fusa
		Nota unaNota = new DoSostenido(new Fusa());
		
		// La duracion de la figura Corchea es de 0.125 Negras
		assertEquals("Duracion establecida incorrectamente", 0.125, unaNota.getDuracion(), 0.00001);
	}
	
}
