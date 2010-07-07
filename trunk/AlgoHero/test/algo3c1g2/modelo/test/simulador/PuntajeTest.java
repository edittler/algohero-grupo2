package algo3c1g2.modelo.test.simulador;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3c1g2.modelo.Cancion;
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
	public void testContarPuntosConCancionNula() {
		Cancion unaCancion = null;
		Puntaje unPuntaje = new Puntaje(unaCancion);
		
		boolean contoPuntos = unPuntaje.contarPuntos(0, 'A');
		
		/* Como no tiene una cancion almacenada el puntaje, 
		 * deberia devolver que no conto los puntos.
		 */
		assertFalse(contoPuntos);
	}
	
	@Test
	public void testContarPuntosConCancionSinNotas() {
		Cancion unaCancion = new Cancion("MiCancion");
		Puntaje unPuntaje = new Puntaje(unaCancion);
		
		boolean contoPuntos = unPuntaje.contarPuntos(0, 'A');
		
		/* Como Puntaje tiene almacenada una cancion sin notas, 
		 * deberia devolver que no conto los puntos.
		 */
		assertFalse(contoPuntos);
	}
	
	@Test
	public void testContarPuntosConCancionSinNotasYEnInstanteNegativo() {
		Cancion unaCancion = new Cancion("MiCancion");
		Puntaje unPuntaje = new Puntaje(unaCancion);
		
		boolean contoPuntos = unPuntaje.contarPuntos(-3, 'A');
		
		/* Como Puntaje tiene almacenada una cancion sin notas, 
		 * deberia devolver que no conto los puntos.
		 */
		assertFalse(contoPuntos);
	}

}
