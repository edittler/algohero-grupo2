package algo3c1g2.modelo.tests.nota;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;

//ACLARACION: SE USO JUNIT 4, POR FAVOR USAR ESA VERSION!!

public class FaTest {

	@Test
	public void testGetFrecuenciaConstructor1() {
		// Se crea la nota Fa usando su constructor sin parametros 
		Nota unaNota = new Fa();
		
		// Se comparan las frecuencias que almacena el objeto con la almacenada en la clase constantes
		assertEquals("Frecuencia inicializada incorrectamente", Constantes.FRECUENCIA_FA, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetFrecuenciaConstructor2() {
		// Se crea la nota Fa estableciendo cualquier figura (en este caso Negra) 
		Nota unaNota = new Fa(new Negra());
		
		// Se comparan las frecuencias que almacena el objeto con la almacenada en la clase constantes
		assertEquals("Frecuencia inicializada incorrectamente", Constantes.FRECUENCIA_FA, unaNota.getFrecuencia(), 0.001);
	}
	
	@Test
	public void testGetDuracionDefault() {
		// Se crea la nota Fa usando su constructor sin parametros 
		Nota unaNota = new Fa();
		
		// La duracion de la nota Fa por default es 1 Negra
		assertEquals("Duracion inicializada incorrectamente", Constantes.NEGRA, unaNota.getDuracion(), 0.00001);
	}

	@Test
	public void testGetDuracionRedonda() {
		// Se crea la nota Fa y se pasa una figura Redonda 
		Nota unaNota = new Fa(new Redonda());
		
		// La duracion de la figura Redonda es de 4 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.REDONDA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionBlanca() {
		// Se crea la nota Fa y se pasa una figura Blanca
		Nota unaNota = new Fa(new Blanca());
		
		// La duracion de la figura Blanca es de 2 Negras
		assertEquals("Duracion establecida incorrectamente", Constantes.BLANCA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionNegra() {
		// Se crea la nota Fa y se pasa una figura Negra
		Nota unaNota = new Fa(new Negra());
		
		// La duracion de la figura Negra es de 1 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.NEGRA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionCorchea() {
		// Se crea la nota Fa y se pasa una figura Corchea
		Nota unaNota = new Fa(new Corchea());
		
		// La duracion de la figura Corchea es de 0.5 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.CORCHEA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionSemicorchea() {
		// Se crea la nota Fa y se pasa una figura Semicorchea
		Nota unaNota = new Fa(new Semicorchea());
		
		// La duracion de la figura Semicorchea es de 0.25 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.SEMICORCHEA, unaNota.getDuracion(), 0.00001);
	}
	
	@Test
	public void testGetDuracionFusa() {
		// Se crea la nota Fa y se pasa una figura Fusa
		Nota unaNota = new Fa(new Fusa());
		
		// La duracion de la figura Fusa es de 0.125 Negra
		assertEquals("Duracion establecida incorrectamente", Constantes.FUSA, unaNota.getDuracion(), 0.00001);
	}
	
}
