package algo3c1g2.modelo.test;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;

public class CancionCumpleFelizTest {

	@Test
	public void testCrearCancionCumpleFeliz(){
		Cancion CumpleFeliz = new Cancion("CumpleFeliz");
		CumpleFeliz.setTempo(90);
		
		Compas unCompas = new Compas(3,4);
		unCompas.agregarElemento(new Silencio(new Blanca()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Silencio(new Semicorchea()));
		unCompas.agregarElemento(new Do(new Semicorchea()));
		
		//finalizamos la creacion del compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
		unCompas = new Compas(3,4);
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Do(new Negra()));
		unCompas.agregarElemento(new Fa(new Negra()));
	
		//finalizamos la creacion del segundo compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
	    assertTrue("Nombre Falso",CumpleFeliz.getNombre().equals("CumpleFeliz") );
	    //Prueba que el tempo sea correcto
	    assertEquals(CumpleFeliz.getTempo(), 90); 
	    
	}
	
}
