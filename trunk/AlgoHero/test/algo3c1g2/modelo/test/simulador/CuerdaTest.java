package algo3c1g2.modelo.test.simulador;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

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

	@Test
	public void testHabilitarUnCirculitoCuandoNoSeAgregoNinguno() {
		Cuerda unaCuerda = new Cuerda();
		Circulito unCirculito = unaCuerda.habilitarUnCirculito("",1,1,1);
		
		assertTrue(unCirculito==null);
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
		Circulito otroCirculito = unaCuerda.habilitarUnCirculito("",1,1,1);
		
		assertTrue(unCirculito==otroCirculito);
	}
	
	@Test
	public void testHabilitarUnCirculitoCorrectoIntegral() {
		Cuerda unaCuerda = new Cuerda();
		// Agrego un Circulito a la Cuerda
		Circulito unCirculito = new Circulito(1);
		unaCuerda.agregarCirculito(unCirculito);
		/* Habilito un Circulito,
		 * como la cuerda tiene uno solo, me debe debolver el mismo
		 */
		Circulito otroCirculito = unaCuerda.habilitarUnCirculito("A",1,1,1);
		assertTrue(unCirculito==otroCirculito);
		
		/* Ademas, voy a probar que el circulito se encuentre habilitado,
		 * y se le haya asignado la tecla correctamente.
		 */
		assertTrue(otroCirculito.estaHabilitado());
		assertTrue(otroCirculito.getTeclas()=="A");
	}

	

}
