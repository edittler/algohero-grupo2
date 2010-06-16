package algo3c1g2.modelo.tests.tecla;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.Iterator;

import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;

public class MapaDeTeclasTest {
	
	@Test
	  public void testMapeoTeclas(){
		
		MapaDeTeclas mapa = new MapaDeTeclas();
		
		//Creo dos combinacion de Teclas 
		CombinacionDeTeclas unaCombinacion = new CombinacionDeTeclas();
		CombinacionDeTeclas otraCombinacion = new CombinacionDeTeclas();
		
		//Le agrego teclas a las siguientes combinaciones
		
		//Combinacion de las Teclas A B
		unaCombinacion.agregarTecla(new Tecla(65)); 
		unaCombinacion.agregarTecla(new Tecla(66)); 
		
		//Combinacion de las Teclas E F P
		otraCombinacion.agregarTecla(new Tecla(69));
		otraCombinacion.agregarTecla(new Tecla(70));
		otraCombinacion.agregarTecla(new Tecla(80));
		
		
		
		
		//Hago el mapeo de las notas con la combinacion de teclas
		
		mapa.agregarMapeo(new Do(), unaCombinacion);
		mapa.agregarMapeo(new La(), unaCombinacion);
		
		mapa.agregarMapeo(new FaSostenido(),otraCombinacion);
		mapa.agregarMapeo(new Sol(), otraCombinacion);
		mapa.agregarMapeo(new ReSostenido(), otraCombinacion);
		
		
		//Obtengo la combinacion de teclas asociadas a la nota Do
		
		CombinacionDeTeclas unaCombinacionAsociada = mapa.obtenerCombinacion(new La());
		CombinacionDeTeclas otraCombinacionAsociada = mapa.obtenerCombinacion(new ReSostenido());
				
		Iterator<Tecla> combinacionUno = unaCombinacionAsociada.getIteradorTeclas();
		Iterator<Tecla> combinacionDos = otraCombinacionAsociada.getIteradorTeclas();
		
		//Pruebo si me asocio bien las notas a las teclas.
		
		assertEquals("Tecla asociada a la Nota La invalida", combinacionUno.next().getTecla(), 'A');
		assertEquals("Tecla asociada a la Nota La invalida", combinacionUno.next().getTecla(), 'B');
		assertEquals("Tecla asociada a la Nota ReSostenido invalida", combinacionDos.next().getTecla(), 'E');
		assertEquals("Tecla asociada a la Nota ReSostenido invalida", combinacionDos.next().getTecla(), 'F');
		assertEquals("Tecla asociada a la Nota ReSostenido invalida", combinacionDos.next().getTecla(), 'P');
		
		
			
		
	}
	

}
