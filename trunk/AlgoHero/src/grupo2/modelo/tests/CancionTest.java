package grupo2.modelo.tests;

import static org.junit.Assert.*;
import org.junit.*;
import grupo2.modelo.*;
import grupo2.modelo.constantes.*;
import grupo2.modelo.excepciones.*;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;


public class CancionTest {
	
	@Test
	public void testConstructor(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		// Probamos que almacene correctamente el nombre de la cancion
		assertEquals(unaCancion.getNombre(),"Una noche en la playa");
		// Probamos que inicialize el Tempo en 90
		assertTrue(unaCancion.getTempo()==90);
	}

	@Test
	public void testSetNombre(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setNombre("Amigos especiales");
		
		// Probamos que cambie y almacene correctamente el nombre de la cancion
		assertEquals(unaCancion.getNombre(),"Amigos especiales");
	}
	
	@Test
	public void testSetTempo1(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setTempo(50);
		
		// Probamos que cambie y almacene correctamente el Tempo
		assertTrue(unaCancion.getTempo()==50);
	}
	
	@Test(expected=TempoInvalidoException.class)
	public void test() {
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		//Probamos ingresar un Tempo menor al admitido
		unaCancion.setTempo(29);
	}
	
	@Test(expected=TempoInvalidoException.class)
	public void testSetTempo3(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		// Probamos ingresar un tempo mayor al admitido
		unaCancion.setTempo(180);
	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testAgregarCompas() {
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();//por default se crea 4/4
		
		//agregamos solo una blanca e intentamos introducir el compas imcompleto
		unCompas.agregarElemento(new Do(new Blanca())); 
		unaCancion.agregarCompas(unCompas);
	}
	
	@Test
	public void testobtenerCompas(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Do(new Blanca()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Re(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		assertTrue(unaCancion.getCompas(0).getElemento(0).getDuracion()==Constantes.BLANCA);
		assertTrue(unaCancion.getCompas(0).getElemento(1).getDuracion()==Constantes.NEGRA);
	}

}
