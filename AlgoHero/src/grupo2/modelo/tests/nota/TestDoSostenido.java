package grupo2.modelo.tests.nota;

import static org.junit.Assert.assertEquals;
import grupo2.modelo.constantes.*;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;

import org.junit.Test;

//ACLARACION: SE USO JUNIT 4, POR FAVOR USAR ESA VERSION!!

public class TestDoSostenido {

	@Test
	public void testGetFrecuencia() {
		// Se crea la nota DoSostenido usando su constructor sin parametros 
		Nota unaNota = new DoSostenido();
		
		// Se comparan las frecuencias que almacena el objeto con la almacenada en la clase constantes
		assertEquals("Frecuencia inicializada incorrectamente", Constantes.FRECUENCIA_DO_SOSTENIDO, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetDuracionDefault() {
		// Se crea la nota DoSostenido usando su constructor sin parametros 
		Nota unaNota = new DoSostenido();
		
		// La duracion de la nota DoSostenido por default es 1 Negra
		assertEquals("Duracion inicializada incorrectamente", Constantes.NEGRA, unaNota.getDuracion(), 0.00001);
	}

	@Test
	public void testGetDuracionRedonda() {
		// Se crea la nota DoSostenido y se pasa una figura Redonda 
		Nota unaNota = new DoSostenido(new Redonda());
		
		// La duracion de la figura Redonda es de 4 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.REDONDA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionBlanca() {
		// Se crea la nota DoSostenido y se pasa una figura Blanca 
		Nota unaNota = new DoSostenido(new Blanca());
		
		// La duracion de la figura Blanca es de 2 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.BLANCA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioNegra() {
		// Se crea la nota DoSostenido y se pasa una figura Negra
		Nota unaNota = new DoSostenido(new Negra());
		
		// La duracion de la figura Negra es de 1 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.NEGRA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioCorchea() {
		// Se crea la nota DoSostenido y se pasa una figura Corchea
		Nota unaNota = new DoSostenido(new Corchea());
		
		// La duracion de la figura Corchea es de 0.5 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.CORCHEA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioSemicorchea() {
		// Se crea la nota DoSostenido y se pasa una figura Semicorchea
		Nota unaNota = new DoSostenido(new Semicorchea());
		
		// La duracion de la figura Corchea es de 0.25 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.SEMICORCHEA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracioFusa() {
		// Se crea la nota DoSostenido y se pasa una figura Fusa
		Nota unaNota = new DoSostenido(new Fusa());
		
		// La duracion de la figura Corchea es de 0.125 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.FUSA, unaNota.getDuracion(), 0.00001);
	}
	
}
