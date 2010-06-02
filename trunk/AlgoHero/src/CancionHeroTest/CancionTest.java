package CancionHeroTest;
import java.util.ArrayList;
import java.util.Hashtable;

import CancionHero.*;
import CancionHero.Figura.*;
import CancionHero.Nota.*;
import CancionHero.Tecla.*;
import Constantes.Constantes;
import junit.framework.TestCase;

public class CancionTest extends TestCase{

	@Test
	public void testCrearCancionCumpleFeliz(){
		Cancion CumpleFeliz = new Cancion("CumpleFeliz");
		CumpleFeliz.setTempo(90);
		
		Compas unCompas = new Compas(3,4);
	
		unCompas.agregarElemento(new Silencio(new Blanca()));
		
		Nota unaNota = new Nota(new Do(), new Corchea());
		unCompas.agregarElemento(unaNota);
		
		unCompas.agregarElemento(new Silencio(new Semicorchea()));
		
		unaNota = new Nota(new Do(), new Semicorchea());
		unCompas.agregarElemento(unaNota);
		
		//finalizamos la creacion del compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
		unCompas = new Compas(3,4);
		
		unaNota = new Nota(new Re(), new Negra());
		unCompas.agregarElemento(unaNota);
		
		unaNota = new Nota(new Do(), new Negra());
		unCompas.agregarElemento(unaNota);
	
		unaNota = new Nota(new Fa(), new Negra());
		unCompas.agregarElemento(unaNota);
	
		//finalizamos la creacion del segundo compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
	    assertTrue("Nombre Falso",CumpleFeliz.getNombre().equals("CumpleFeliz") );
	    assertEquals(CumpleFeliz.getTempo(), 90); //Prueba que el tempo sea correcto
	    
	    //cargo el mapeo automatico y pruebo si cargo correctamente las notas
	    // en sus correspondientes teclas. Antes debo crear la combinacion de teclas
	    
	    ArrayList<Tecla> teclas = new ArrayList<Tecla>();
	    teclas.add(new A());
	    teclas.add(new S());
	    teclas.add(new J());
	    teclas.add(new K());
	    
	    CumpleFeliz.mapearTeclas(teclas);
	    
	    Hashtable<Tono, Tecla> unMapeo = CumpleFeliz.getMapeo();
	    Tecla unaTecla = unMapeo.get(new Do());
	    //assertEquals(unaTecla.getCodigoASCII(),Constantes.CODIGO_ASCII_A);
	   
	    
	}
	
	
}
