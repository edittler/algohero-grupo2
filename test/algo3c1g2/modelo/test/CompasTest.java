package algo3c1g2.modelo.test;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.Iterator;

import algo3c1g2.modelo.*;
import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;


public class CompasTest {

	@Test
	public void testConstructorSinParametros(){
		Compas unCompas = new Compas();
		assertTrue(unCompas.getNumerador()==4);
		assertTrue(unCompas.getDenominador()==4);
	}
	
	@Test
	public void testConstructorConParametros(){
		Compas unCompas = new Compas(6,8);
		assertTrue(unCompas.getNumerador()==6);
		assertTrue(unCompas.getDenominador()==8);
	}
	
	@Test
	public void testSetNumeradorCorrecto(){
		Compas unCompas = new Compas();
		unCompas.setNumerador(15);
		assertTrue(unCompas.getNumerador()==15);
	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testSetNumeradorIncorrecto(){
		Compas unCompas = new Compas();
		unCompas.setNumerador(-3);
	}
	
	@Test
	public void testSetDenominadorCorrecto(){
		Compas unCompas = new Compas();
		unCompas.setDenominador(16);
		assertTrue(unCompas.getDenominador()==16);
		
		unCompas.setDenominador(4);
		assertTrue(unCompas.getDenominador()==4);
		
		unCompas.setDenominador(1);
		assertTrue(unCompas.getDenominador()==1);
	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testSetDenominadorIncorrecto1(){
		Compas unCompas = new Compas();
		unCompas.setDenominador(0);
		fail("Permite setear el valor 0 como Denominador");
	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testSetDenominadorIncorrecto2(){
		Compas unCompas = new Compas();
		unCompas.setDenominador(-3);
		fail("Permite setear un valor negativo");
	}
	
	@Test(expected=CompasInvalidoExcepcion.class)
	public void testSetDenominadorIncorrecto3(){
		Compas unCompas = new Compas();
		unCompas.setDenominador(3);
		fail("Permite setear un Denominador invalido, que no se corresponde a una figura musical");
	}
	
	@Test	
	public void testAgregarElementos(){
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Silencio(new Blanca()));
		unCompas.agregarElemento(new Do(new Negra()));
		
		Iterator<ElementoDeCompas> itElementos = unCompas.getIteratorElementos();
		assertTrue((itElementos.next().getDuracion())==(new Blanca()).getDuracion());
		assertTrue((itElementos.next().getDuracion())==(new Negra()).getDuracion());
	}
	
	@Test(expected=CompasSobrepasadoExcepcion.class)
	public void testAgregarMasElementosDeLoPermitido(){
		Compas unCompas=new Compas();
		unCompas.agregarElemento(new Silencio(new Blanca()));
		unCompas.agregarElemento(new Do(new Negra()));
		unCompas.agregarElemento(new Silencio(new Redonda()));
		unCompas.agregarElemento(new Silencio(new Corchea()));
	}
	
}
