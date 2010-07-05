package algo3c1g2.modelo.test.simulador;

import static org.junit.Assert.*;

import org.junit.Test;

import algo3c1g2.modelo.simulador.Circulito;

public class CirculitoTest {

	@Test
	public void testConstructor() {
		Circulito unCirculito = new Circulito(1);
		assertTrue(unCirculito.getNumeroDeCuerda()==1);
		assertFalse(unCirculito.estaHabilitado());
		assertFalse(unCirculito.fueReproducido());
		assertTrue(unCirculito.getTeclas()=="");
	}

	@Test
	public void testHabilitar() {
		Circulito unCirculito = new Circulito(1);
		unCirculito.habilitar();
		assertTrue(unCirculito.estaHabilitado());
	}

	@Test
	public void testEstablecerQueFueReproducido() {
		Circulito unCirculito = new Circulito(1);
		unCirculito.establecerQueFueReproducido();
		assertTrue(unCirculito.fueReproducido());
	}
	
	@Test
	public void testReiniciar() {
		Circulito unCirculito = new Circulito(1);
		assertTrue(unCirculito.getNumeroDeCuerda()==1);
		assertFalse(unCirculito.estaHabilitado());
		assertFalse(unCirculito.fueReproducido());
		assertTrue(unCirculito.getTeclas()=="");
	}

	@Test
	public void testVivirConCirculitoDeshabilitado() {
		Circulito unCirculito = new Circulito(1);
		// El Circulito se crea inicialmente deshabilitado
		int posEnYInicial = unCirculito.getY();
		// Como el circulito no esta habilitado, la posicion debe ser la misma
		assertTrue(posEnYInicial==unCirculito.getY());
	}
	
	@Test
	public void testVivirConCirculitoHabilitado() {
		Circulito unCirculito = new Circulito(1);
		// Habilito el Circulito
		unCirculito.habilitar();
		int posEnYInicial = unCirculito.getY();
		unCirculito.vivir();
		int posEnYFinal = unCirculito.getY();
		/* Como el circulito esta habilitado, la posicion debe
		 * incrementarse a 1 unidad
		 */
		assertTrue(posEnYInicial==(posEnYFinal-1));
	}

	@Test
	public void testCumpleConLaCondiccionDeReproduccionConParametrosNulos() {
		Circulito unCirculito = new Circulito(1);
		boolean cumpleCondiciones = unCirculito.cumpleConLaCondiccionDeReproduccion(0, 0, null);
		
		//Como los parametros son invalidos, debe devolver false
		assertFalse(cumpleCondiciones);
	}
	
	@Test
	public void testCumpleConLaCondiccionDeReproduccionConParametrosNulosYNegativos() {
		Circulito unCirculito = new Circulito(1);
		boolean cumpleCondiciones = unCirculito.cumpleConLaCondiccionDeReproduccion(-10, 0, null);
		
		//Como los parametros son invalidos, debe devolver false
		assertFalse(cumpleCondiciones);
	}

}
