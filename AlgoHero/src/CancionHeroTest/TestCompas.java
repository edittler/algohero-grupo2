package CancionHeroTest;

import CancionHero.Compas;
import CancionHero.Silencio;
import CancionHero.Figura.Corchea;
import CancionHero.Figura.Redonda;
import junit.framework.TestCase;

public class TestCompas extends TestCase {

	public void testConstructor(){
		Compas unCompas=new Compas();
		assertTrue(unCompas.getNumerador()==4);
		assertTrue(unCompas.getDenominador()==4);
		assertFalse(unCompas.getElementos()==null);
		
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
		try{
			unCompas.agregarElemento(new Silencio(new Redonda()));
			unCompas.agregarElemento(new Silencio(new Corchea()));
			fail("deberia haber lanzado una excepcion");
		}
		catch (RuntimeException e){return;}
		fail("deberia haber capturado");
	}
	
}
