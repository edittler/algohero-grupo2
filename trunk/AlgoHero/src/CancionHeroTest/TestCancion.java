package CancionHeroTest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import junit.framework.TestCase;
import CancionHero.Cancion;
import CancionHero.Compas;
import CancionHero.ElementoDeCompas;
import CancionHero.Tecla.*;
import CancionHero.Nota.*;
import CancionHero.Figura.*;
import Constantes.Constantes;

public class TestCancion extends TestCase {

	public void testConstructor(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		assertEquals(unaCancion.getNombre(),"Una noche en la playa");//probamos que almacene correctamente el nobmre
		assertTrue(unaCancion.getTempo()==90); //probamos que inicialize el Tempo en 90
	}

	public void testSetTempo(){ 
		Cancion unaCancion = new Cancion("Una noche en la playa");
		unaCancion.setTempo(50);
		assertTrue(unaCancion.getTempo()==50);//probamos que almacene correctamente el Tempo
		try{
			unaCancion.setTempo(29);
			fail("deberia haber lanzado una excepcion"); //Probamos que no permita ingresar un Tempo invalido
		}
		catch (RuntimeException e){return;}
		fail("deberia haber capturado");
	}
	
	public void testAgregarCompas() {
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();//por default se crea 4/4
		unCompas.agregarElemento(new Nota(new Do(),new Blanca())); //agregamos solo una blanca
		try 	// e intentamos agregar el compas inconcluso a la cancion
		{
			unaCancion.agregarCompas(unCompas);
			fail("deberia haber lanzada una excepcion");
		}
		catch(RuntimeException e){ return;}
		fail("deberia haber capturado");
		
	}
	
	
	public void testMapeo(){ //Probamos mapear algo sensillo
		Cancion unaCancion = new Cancion("pa' lante");
		Compas unCompas = new Compas();
		ArrayList<Tecla> tecla = new ArrayList<Tecla>();
		
		
		tecla.add(new A()); //Habilitamos las teclas A y J
		tecla.add(new J());
		unCompas.agregarElemento(new Nota(new Do(),new Blanca())); //Agregamos al compas notas
		unCompas.agregarElemento(new Nota(new ReSostenido(),new Negra()));
		unCompas.agregarElemento(new Nota(new FaSostenido(),new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		unaCancion.mapearTeclas(tecla);
		Hashtable<Float,Integer> unHash = unaCancion.getMapeo();


		assertTrue(unHash.containsKey(new Do().getFrecuencia()));
		
		assertTrue(unHash.get(new Do().getFrecuencia())==Constantes.CODIGO_ASCII_A); // Probamos que las notas esten mapeadas con su tecla correspondiente
		
		assertTrue(unHash.get(new ReSostenido().getFrecuencia())==Constantes.CODIGO_ASCII_J); 
		
		assertTrue(unHash.get(new ReSostenido().getFrecuencia())==Constantes.CODIGO_ASCII_A);
		
		
		ArrayList<Tecla> teclas = new ArrayList<Tecla>();
		try{ //Probamos que no permita mapear sin teclas
			unaCancion.mapearTeclas(teclas);
			fail("deberia haber lanzado una excepcion");
		}
		catch (RuntimeException e) {return;}
			fail("deberia haber capturado");
	}

}
