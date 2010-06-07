package grupo2.modelo.tests;

import static org.junit.Assert.*;

import java.util.Iterator;


import org.junit.*;
import grupo2.modelo.*;
import grupo2.modelo.constantes.*;
import grupo2.modelo.excepciones.*;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.*;
import grupo2.modelo.tecla.CombinacionDeTeclas;
import grupo2.modelo.tecla.Tecla;


public class CancionTest {
	
	@Test
	public void testConstructor(){ 
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
	public void testAgregarCompas() {
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();//por default se crea 4/4
		
		//agregamos solo una blanca e intentamos introducir el compas imcompleto
		unCompas.agregarElemento(new Do(new Blanca())); 
		unaCancion.agregarCompas(unCompas);
		fail("Permite agregar un compas incompleto a la cancion");

	}
	
	@Test
	public void testObtenerCompas(){
		Cancion unaCancion = new Cancion("Una noche en la playa");
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Do(new Blanca()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Re(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		assertTrue(unaCancion.getCompas(0).getElemento(0).getDuracion()==Constantes.BLANCA);
		assertTrue(unaCancion.getCompas(0).getElemento(1).getDuracion()==Constantes.NEGRA);
		assertTrue(((Nota)unaCancion.getCompas(0).getElemento(2)).getFrecuencia()==Constantes.FRECUENCIA_RE);

	}

	@Test//Esta seria una prueba de integracion... nose si tiene otro formato u otra convencion establecida
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
		
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		teclas.agregarTecla(new Tecla('C'));

		unaCancion.mapear(new Mi(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('O'));
		teclas.agregarTecla(new Tecla('H'));
		teclas.agregarTecla(new Tecla('L'));
	
		unaCancion.mapear(new LaSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('I'));
		
		unaCancion.mapear(new Re(),teclas);
		
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Blanca()));
		unCompas.agregarElemento(new LaSostenido(new Corchea()));
		unCompas.agregarElemento(new Mi(new Corchea()));
		unCompas.agregarElemento(new Re(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Blanca()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unaCancion.agregarCompas(unCompas);

		CombinacionDeTeclas teclasPresionadas= new CombinacionDeTeclas();
		teclasPresionadas.agregarTecla(new Tecla('A'));
		teclasPresionadas.agregarTecla(new Tecla('C'));

		assertTrue(unaCancion.chequear(teclasPresionadas,0));
		
		teclasPresionadas = new CombinacionDeTeclas();
		teclasPresionadas.agregarTecla(new Tecla('O'));
		teclasPresionadas.agregarTecla(new Tecla('H'));
		teclasPresionadas.agregarTecla(new Tecla('L'));
		
		
		assertTrue(unaCancion.chequear(teclasPresionadas,4.00/3.00));
	}
}
