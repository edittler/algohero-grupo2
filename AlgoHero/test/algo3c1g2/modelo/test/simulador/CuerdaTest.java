package algo3c1g2.modelo.test.simulador;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.simulador.Circulito;
import algo3c1g2.modelo.simulador.Cuerda;

public class CuerdaTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testConstructor() {
		Cuerda unaCuerda = new Cuerda();
		
		/* Al inicializar el objeto, se inicializa la coleccion,
		 * voy a verificar que se inicializa la coleccion y
		 * ésta se encuentra vacia
 		 */
		Iterator unIt = unaCuerda.iteradorCirculitos();
		
		assertFalse(unIt.hasNext());
	}
	
	@Test (expected=ParametroNuloExcepcion.class)
	public void testAgregarCirculitoNulo() {
		Cuerda unaCuerda = new Cuerda();
		unaCuerda.agregarCirculito(null);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAgregarCirculito() {
		Circulito unCirculito = new Circulito(1);
		Cuerda unaCuerda = new Cuerda();
		unaCuerda.agregarCirculito(unCirculito);
		
		/* Ahora que agregue el circulito,
		 * pido el iterador y verifico si se encuentra en la coleccion
		 */
		Iterator unIt = unaCuerda.iteradorCirculitos();
		assertTrue(unIt.next()==unCirculito);
		assertFalse(unIt.hasNext());
	}

	@Test (expected=SinElementoParaHabilitarExcepcion.class)
	public void testHabilitarUnCirculitoCuandoNoSeAgregoNinguno() {
		Cuerda unaCuerda = new Cuerda();
		unaCuerda.habilitarUnCirculito("",1,1,1);
	}
	
	@Test
	public void testHabilitarUnCirculitoCorrecto() {
		Cuerda unaCuerda = new Cuerda();
		// Agrego un Circulito a la Cuerda
		Circulito unCirculito = new Circulito(1);
		unaCuerda.agregarCirculito(unCirculito);
		
		/* Habilito un Circulito,
		 * como la cuerda tiene uno solo, me debe debolver el mismo
		 */
		unaCuerda.habilitarUnCirculito("",1,1,1);
	}

}
