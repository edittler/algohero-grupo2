package grupo2.modelo.tests;

import java.util.Iterator;

import grupo2.modelo.Compas;
import grupo2.modelo.ElementoDeCompas;
import grupo2.modelo.Silencio;
import grupo2.modelo.figura.*;
import grupo2.modelo.nota.Do;
import junit.framework.TestCase;

public class TestCompas extends TestCase {

	
	public void testConstructor(){
		Compas unCompas=new Compas();
		assertTrue(unCompas.getNumerador()==4);
		assertTrue(unCompas.getDenominador()==4);
		
		unCompas=new Compas(6,8);
		assertTrue(unCompas.getNumerador()==6);
		assertTrue(unCompas.getDenominador()==8);
		
	}
	
	
	public void testSetNumerador(){
		
		Compas unCompas=new Compas();
		unCompas.setNumerador(15);
		assertTrue(unCompas.getNumerador()==15);
		try{
			unCompas.setNumerador(-3);
			fail("deberia haber lanzado una excepcion");
		}
		catch (RuntimeException e){return;}
		fail("deberia haber capturado");
		
	}
	
	
	
	public void testSetDenominador(){
		Compas unCompas=new Compas();
		unCompas.setDenominador(16);
		assertTrue(unCompas.getDenominador()==16);
		unCompas.setDenominador(4);
		assertTrue(unCompas.getDenominador()==4);
		unCompas.setDenominador(1);
		assertTrue(unCompas.getDenominador()==1);
		try{
			unCompas.setDenominador(-3);
			fail("deberia haber lanzado una excepcion");
		}
		catch (RuntimeException e){
			try{
				unCompas.setDenominador(7);
				fail("deberia haber lanzado una excepcion");
			}
			catch (RuntimeException E){return;}
			fail("deberia haber capturado");
		}
		fail("deberia haber capturado");
	}
	
	
	
	public void testElemento(){
		Compas unCompas=new Compas();
		unCompas.agregarElemento(new Silencio(new Blanca()));
		unCompas.agregarElemento(new Do(new Negra()));
		Iterator<ElementoDeCompas> itElementos=unCompas.getIteratorElementos();
		assertTrue((itElementos.next().getDuracion())==(new Blanca()).getDuracion());
		
		try{
			unCompas.agregarElemento(new Silencio(new Redonda()));
			unCompas.agregarElemento(new Silencio(new Corchea()));
			fail("deberia haber lanzado una excepcion");
		}
		catch (RuntimeException e){return;}
		fail("deberia haber capturado");
	}
	
}
