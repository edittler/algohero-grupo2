package algo3c1g2.modelo.test.simulador;

import org.junit.Test;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.nota.Do;
import algo3c1g2.modelo.nota.DoSostenido;
import algo3c1g2.modelo.nota.Fa;
import algo3c1g2.modelo.nota.FaSostenido;
import algo3c1g2.modelo.nota.La;
import algo3c1g2.modelo.nota.LaSostenido;
import algo3c1g2.modelo.nota.Mi;
import algo3c1g2.modelo.nota.Re;
import algo3c1g2.modelo.nota.ReSostenido;
import algo3c1g2.modelo.nota.Si;
import algo3c1g2.modelo.nota.Sol;
import algo3c1g2.modelo.nota.SolSostenido;
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
		Cancion unaCancion = new Cancion("MiCancion");
		this.agregarMapeoCompleto(unaCancion);
		Guitarra oneGuitar = new Guitarra(unaCancion, new Reproductor());
		oneGuitar.agregarCirculito(null);
	}

	@Test
	public void testReproducir() {
		Cancion unaCancion = new Cancion("MiCancion");
		this.agregarMapeoCompleto(unaCancion);
		Guitarra oneGuitar = new Guitarra(unaCancion, new Reproductor());
		oneGuitar.reproducir('A', 0, 0);
	}
	
	private void agregarMapeoCompleto(Cancion cancion){
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		cancion.mapear(new Do(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		cancion.mapear(new DoSostenido(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('S'));
		cancion.mapear(new Re(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('S'));
		cancion.mapear(new ReSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('D'));
		cancion.mapear(new Mi(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('D'));
		cancion.mapear(new Fa(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('F'));
		cancion.mapear(new FaSostenido(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('F'));
		cancion.mapear(new Sol(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new SolSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new La(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('H'));
		cancion.mapear(new LaSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('H'));
		cancion.mapear(new Si(), teclas);
	}
	
	
}
