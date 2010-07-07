package algo3c1g2.modelo.test.simulador;

import org.junit.Test;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.figura.Blanca;
import algo3c1g2.modelo.nota.Do;
import algo3c1g2.modelo.simulador.Guitarra;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;

public class GuitarraTest {

	@Test (expected=ParametroNuloExcepcion.class)
	public void testConstructorConParametrosNulos() {
		@SuppressWarnings("unused")
		Guitarra oneGuitar = new Guitarra(null, null);
	}
	
	@Test (expected=MapeoIncompletoExcepcion.class)
	public void testConstructorConCancionSinMapeo(){
		/* El constructor verifica que la cancion tenga el mapeo completo,
		 * sino, lanza una excepcion.
		 */
		@SuppressWarnings("unused")
		Guitarra oneGuitar = new Guitarra(new Cancion("MiCancion"), new Reproductor());
	}
	
	@Test (expected=ParametroNuloExcepcion.class)
	public void testAgregarCirculitoNulo(){
      Cancion unaCancion = new Cancion("unacancionsita");
      Compas unCompas = new Compas();
      unCompas.agregarElemento(new Do(new Blanca()));
      unCompas.agregarElemento(new Do(new Blanca()));
      unaCancion.agregarCompas(unCompas);
      
      CombinacionDeTeclas unaCombinacion= new CombinacionDeTeclas();
      unaCombinacion.agregarTecla(new Tecla('A'));
      unaCancion.mapear(new Do(), unaCombinacion);
      
		Guitarra oneGuitar = new Guitarra(unaCancion, new Reproductor());
		oneGuitar.agregarCirculito(null);
	}

	@Test
	public void testReproducir() {
	      Cancion unaCancion = new Cancion("unacancionsita");
	      Compas unCompas = new Compas();
	      unCompas.agregarElemento(new Do(new Blanca()));
	      unCompas.agregarElemento(new Do(new Blanca()));
	      unaCancion.agregarCompas(unCompas);
	      
	      CombinacionDeTeclas unaCombinacion= new CombinacionDeTeclas();
	      unaCombinacion.agregarTecla(new Tecla('A'));
	      unaCancion.mapear(new Do(), unaCombinacion);
	      
		Guitarra oneGuitar = new Guitarra(unaCancion, new Reproductor());
		oneGuitar.reproducir('A', 0, 0);
	}
	

	
	
}
