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
	public void testVivir1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testCumpleConLaCondiccionDeReproduccion() {
		fail("Not yet implemented");
	}

}
