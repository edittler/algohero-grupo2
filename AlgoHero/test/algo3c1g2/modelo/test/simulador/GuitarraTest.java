package algo3c1g2.modelo.test.simulador;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3c1g2.modelo.simulador.Guitarra;

public class GuitarraTest {

	@Test
	public void testConstructor() {
		Guitarra oneGuitar = new Guitarra(null, null);
		/* Cuando se crea la guitarra y todavia no se ha convocado
		 * al metodo vivir, el instante de reprocuddion debe ser 0
		 */
		assertEquals(0, oneGuitar.getInstanteActual(), 0);
	}

	@Test
	public void testVivir() {
		Guitarra oneGuitar = new Guitarra(null, null);
		oneGuitar.vivir();
		
		/* Al vivir, el objeto incremento su instante actual
		 * el incremento esta dado por el intervalo de simulacion.
		 * El intervalo de simulacion establecido es 0.0104166666666
		 */
		assertEquals(0.0104166666666, oneGuitar.getInstanteActual(), 0.000001);
	}

	@Test
	public void testReproducir() {
		Guitarra oneGuitar = new Guitarra(null, null);
		oneGuitar.reproducir('A', 0, 0);
	}

}
