package algo3c1g2.modelo.test.simulador;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.simulador.Puntaje;

public class PuntajeTest {

	@Test
	public void testConstructor() {
		Cancion unaCancion = new Cancion("MiCancion");
		Puntaje unPuntaje = new Puntaje(unaCancion);
		
		/* El puntaje debe tener almacenados 0 puntos al inicializarse,
		 * verifico esto
		 */
		assertEquals(unPuntaje.getPuntos(),0);
	}
	

	@Test
	public void testGetElementoAReproducirConCancionNula() {
		Cancion unaCancion = null;
		Puntaje unPuntaje = new Puntaje(unaCancion);
		
		Nota unaNota = unPuntaje.getElementoAReproducir(40);
		
		assertTrue(unaNota==null);
	}
	
	@Test
	public void testGetElementoAReproducirConCancionSinNotas() {
		Cancion unaCancion = new Cancion("MiCancion");
		Puntaje unPuntaje = new Puntaje(unaCancion);
		
		Nota unaNota = unPuntaje.getElementoAReproducir(40);
		
		assertTrue(unaNota==null);
	}

	@Test
	public void testContarPuntos() {
		fail("Not yet implemented");
	}

}
