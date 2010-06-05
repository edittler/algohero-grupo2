package grupo2.modelo.tests;

import static org.junit.Assert.*;
import grupo2.modelo.Cancion;
import grupo2.modelo.Compas;
import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;
import org.junit.*;
import grupo2.modelo.excepciones.*;


public class TestCancion {
	
	@Test
	public void testConstructor(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		assertEquals(unaCancion.getNombre(),"Una noche en la playa");//probamos que almacene correctamente el nobmre
		assertTrue(unaCancion.getTempo()==90); //probamos que inicialize el Tempo en 90
	}

	@Test
	public void testSetNombre(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setNombre("Amigos especiales");
		assertEquals(unaCancion.getNombre(),"Amigos especiales");
	}
	
	@Test
	public void testSetTempo1(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setTempo(50);
		assertTrue(unaCancion.getTempo()==50);//probamos que almacene correctamente el Tempo
	}
	
	
	@Test(expected=TempoInvalidoException.class)
	public void test() {//Probamos ingresar un Tempo menor al admitido
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setTempo(29);
	}
	
	@Test(expected=TempoInvalidoException.class)
	public void testSetTempo3(){// Probamos ingresar un tempo mayor al admitido
		Cancion unaCancion = new Cancion("Una noche en la playa");
			unaCancion.setTempo(180);
	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testAgregarCompas() {
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();//por default se crea 4/4
		unCompas.agregarElemento(new Do(new Blanca())); //agregamos solo una blanca
		
		
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
