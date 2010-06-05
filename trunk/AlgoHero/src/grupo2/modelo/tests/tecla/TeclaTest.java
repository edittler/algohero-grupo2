package grupo2.modelo.tests.tecla;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grupo2.modelo.tecla.*;


public class TeclaTest {
	
	@Test 
	  public void testGetTecla(){
		
		Tecla unaTecla = new Tecla(115);
		
		//se prueba que  el codigo ASCII ingresado coincida  
		assertEquals("codigo ASCIII incorrecto", unaTecla.getCodigoASCII(),115);
		//se prueba que el la tecla devuelta sea la correcta para el codigo ASCII ingresado
		assertEquals("Tecla incorrecta", unaTecla.getTecla(),'s');
					
		
	}
	
	
	
	  
	
	
	

}
