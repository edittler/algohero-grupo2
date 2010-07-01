package algo3c1g2.modelo.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.*;

import algo3c1g2.modelo.*;
import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;


public class CancionTest {
	
	
	@Test
	public void testConstructorConParametro1(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		// Probamos que almacene correctamente el nombre de la cancion
		assertEquals("No inicializa correctamente el nombre de la cancion",unaCancion.getNombre(),"Una noche en la playa");
		// Probamos que inicialize el Tempo en 90
		assertTrue("No inicializa el Tempo de la cancion con el valor default",unaCancion.getTempo()==90);
	}

	@Test
	public void testSetNombre(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setNombre("Amigos especiales");
		
		// Probamos que cambie y almacene correctamente el nombre de la cancion
		assertEquals("No setea el nombre de la cancion correctamente",unaCancion.getNombre(),"Amigos especiales");
	}
	
	@Test
	public void testSetTempoCorrecto(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setTempo(50);
		
		// Probamos que cambie y almacene correctamente el Tempo
		assertTrue("No setea correctamente el tempo de la cancion",unaCancion.getTempo()==50);
	}
	
	@Test(expected=TempoInvalidoException.class)
	public void testSetTempoIncorrecto1() {
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		//Probamos ingresar un Tempo menor al admitido
		unaCancion.setTempo(29);
		fail("Permite setear un Tempo invalido, menor a 30");
	}
	
	@Test(expected=TempoInvalidoException.class)
	public void testSetTempoIncorrecto2(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		// Probamos ingresar un tempo mayor al admitido
		unaCancion.setTempo(180);
		fail("Permite setear un Tempo invalido, mayor a 150");

	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testAgregarCompasIncompleto() {
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();//por default se crea 4/4
		
		//agregamos solo una blanca e intentamos introducir el compas incompleto
		unCompas.agregarElemento(new Do(new Blanca())); 
		unaCancion.agregarCompas(unCompas);
		fail("Permite agregar un compas incompleto a la cancion");
	}
	
	@Test
	public void testMapear(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		teclas.agregarTecla(new Tecla('C'));

		unaCancion.mapear(new Mi(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('O'));
		teclas.agregarTecla(new Tecla('H'));
		teclas.agregarTecla(new Tecla('L'));
	
		unaCancion.mapear(new LaSostenido(), teclas);
		
		assertTrue(unaCancion.getMapeo().obtenerCombinacion(new Do())==null);
		Iterator<Tecla> itTeclasMi = unaCancion.getMapeo().obtenerCombinacion(new Mi()).getIteradorTeclas();
		assertTrue("Error al mapear tecla A",itTeclasMi.next().getCodigoASCII()=='A');
		assertTrue("Error al mapear tecla C",itTeclasMi.next().getCodigoASCII()=='C');
		
		itTeclasMi = unaCancion.getMapeo().obtenerCombinacion(new LaSostenido()).getIteradorTeclas();
		assertTrue("Error al mapear tecla O",itTeclasMi.next().getCodigoASCII()=='O');
		assertTrue("Error al mapear tecla H",itTeclasMi.next().getCodigoASCII()=='H');
		assertTrue("Error al mapear tecla L",itTeclasMi.next().getCodigoASCII()=='L');
	}

	
	@Test
	public void testChequear(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		// combinacion de teclas para la nota Mi
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		teclas.agregarTecla(new Tecla('C'));
		unaCancion.mapear(new Mi(),teclas);
		
		// combinacion de teclas para la nota LaSostenido
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('O'));
		teclas.agregarTecla(new Tecla('H'));
		teclas.agregarTecla(new Tecla('L'));
		unaCancion.mapear(new LaSostenido(), teclas);
		
		// combinacion de teclas para la nota Re
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('I'));
		unaCancion.mapear(new Re(),teclas);
		
		// creacion y agregacion de compas 1
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Blanca()));
		unCompas.agregarElemento(new LaSostenido(new Corchea()));
		unCompas.agregarElemento(new Mi(new Corchea()));
		unCompas.agregarElemento(new Re(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		// creacion y agregacion de compas 2
		unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Blanca()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		// conjunto de teclas presionadas en "el instante"
		CombinacionDeTeclas teclasPresionadas= new CombinacionDeTeclas();
		teclasPresionadas.agregarTecla(new Tecla('A'));
		teclasPresionadas.agregarTecla(new Tecla('C'));

		assertTrue(unaCancion.verificarTeclas(teclasPresionadas,0,0.01));
		
		teclasPresionadas = new CombinacionDeTeclas();
		teclasPresionadas.agregarTecla(new Tecla('O'));
		teclasPresionadas.agregarTecla(new Tecla('H'));
		teclasPresionadas.agregarTecla(new Tecla('L'));
		
		
		assertTrue(unaCancion.verificarTeclas(teclasPresionadas,4.00/3.00,0.01));
	}
	
	@Test
	public void testgetElemento(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		
		// combinacion de teclas para la nota Mi
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		teclas.agregarTecla(new Tecla('C'));
		unaCancion.mapear(new Mi(),teclas);
		
		// combinacion de teclas para la nota LaSostenido
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('O'));
		teclas.agregarTecla(new Tecla('H'));
		teclas.agregarTecla(new Tecla('L'));
		unaCancion.mapear(new LaSostenido(), teclas);
		
		// combinacion de teclas para la nota Re
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('I'));
		unaCancion.mapear(new Re(),teclas);
		
		// creacion y agregacion de compas 1
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Blanca()));
		unCompas.agregarElemento(new LaSostenido(new Corchea()));
		unCompas.agregarElemento(new Mi(new Corchea()));
		unCompas.agregarElemento(new Re(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		// creacion y agregacion de compas 2
		unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Blanca()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		// conjunto de teclas presionadas en "el instante"
		CombinacionDeTeclas teclasPresionadas= new CombinacionDeTeclas();
		teclasPresionadas.agregarTecla(new Tecla('A'));
		teclasPresionadas.agregarTecla(new Tecla('C'));

		assertEquals(unaCancion.getElemento(0,0.001),new Mi());
		assertEquals(unaCancion.getElemento(1.33333,0.001),new LaSostenido());
		assertEquals(unaCancion.getElemento(1.66666,0.001),new Mi());
		assertEquals(unaCancion.getElemento(2,0.001),new Re());
		assertEquals(unaCancion.getElemento(2.66666,0.001),new Mi());
		assertEquals(unaCancion.getElemento(4,0.001),new Mi());
		assertEquals(unaCancion.getElemento(4.66666,0.001),new LaSostenido());
	}
	
	@Test(expected=TiempoNegativoExcepcion.class)
	public void testGetElementoFueraDeRango1(){
		Cancion unaCancion = new Cancion("Palomitas de Maiz");
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Do(new Blanca()));
		unCompas.agregarElemento(new La(new Negra()));
		unCompas.agregarElemento(new Si(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		@SuppressWarnings("unused")
		ElementoDeCompas unElemento = unaCancion.getElemento(-1, 0.1);
		fail("Intento buscar un elemento en un instante negativo");
	
	}
	
	@Test
	public void testGetElementoFueraDeRango2(){
		Cancion unaCancion = new Cancion("Palomitas de Maiz");
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Do(new Blanca()));
		unCompas.agregarElemento(new La(new Negra()));
		unCompas.agregarElemento(new Si(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		ElementoDeCompas unElemento = unaCancion.getElemento(300, 0.1);
		assertTrue(unElemento==null);
	
	}
	
}
