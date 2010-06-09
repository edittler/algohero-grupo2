package algo3c1g2.modelo.tests.tecla;

import static org.junit.Assert.*;
import org.junit.*;

import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.tecla.*;


public class TeclaTest {
	
	@Test
	public void testConstructor(){
		Tecla unaTecla = new Tecla('A');
		//Probamos que inicialice la tecla correctamente
		assertTrue("No inicializa correctamente la tecla",unaTecla.getCodigoASCII()=='A');
	}
	
	@Test(expected=TeclaNoAceptadaExcepcion.class)
	public void testSetTecla(){
		Tecla unaTecla = new Tecla('A');//Probamos ingresar una tecla invalida
		unaTecla.setCodigoASCII('´');
		fail("Permite ingresar una telca invalida");
	}
	
	@Test 
	 public void testGetTecla(){
		
		//creo una tecla y le asigno el codigo ASCII correspondiente a 'S'
		Tecla unaTecla = new Tecla(83);
		
		//se prueba que  el codigo ASCII ingresado coincida  
		assertEquals("codigo ASCIII incorrecto", unaTecla.getCodigoASCII(),83);
		//se prueba que el la tecla devuelta sea la correcta para el codigo ASCII ingresado
		assertEquals("Tecla incorrecta", unaTecla.getTecla(),'S');
	}
	
}
