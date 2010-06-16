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
		
		Nota unaNota = new Do(new Corchea());
		unCompas.agregarElemento(unaNota);
		
		unCompas.agregarElemento(new Silencio(new Semicorchea()));
		
		unaNota = new Do(new Semicorchea());
		unCompas.agregarElemento(unaNota);
		
		//finalizamos la creacion del compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
		unCompas = new Compas(3,4);
		
		unaNota = new Re(new Negra());
		unCompas.agregarElemento(unaNota);
		
		unaNota = new Do(new Negra());
		unCompas.agregarElemento(unaNota);
	
		unaNota = new Fa(new Negra());
		unCompas.agregarElemento(unaNota);
	
		//finalizamos la creacion del segundo compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
	    assertTrue("Nombre Falso",CumpleFeliz.getNombre().equals("CumpleFeliz") );
	    assertEquals(CumpleFeliz.getTempo(), 90); //Prueba que el tempo sea correcto
	    
	    //cargo el mapeo automatico y pruebo si cargo correctamente las notas
	    // en sus correspondientes teclas. Antes debo crear la combinacion de teclas
	    
	}
	
}
