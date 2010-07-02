package algo3c1g2.modelo.test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;

import algo3c1g2.modelo.*;


public class IteradorClienteTest {
	
	
	@Test
	public void testElementosIteradorCliente(){
		//creo una lista de string 
		ArrayList<String> listaElementos =new ArrayList<String>();
		
		//agrego elementos en la lista
		
		listaElementos.add("testuno");
		listaElementos.add("testdos");
		listaElementos.add("testtres");
		listaElementos.add("testcuatro");
		
		//creo el iterador para la lista creada
		IteradorCliente<String> itElementos =  new IteradorCliente<String>(listaElementos);
		
		//testeo que el iterador funcione correctamente
		
		//verifico que haya elementos en la lista
		assertTrue("No existen mas elementos en las Lista", itElementos.hasNext());
		
		assertEquals("Primer Dato obtenido Erroneo", itElementos.next(),"testuno");
		assertEquals("Segundo Dato obtenido Erroneo", itElementos.next(),"testdos");
		assertEquals("Tercer Dato obtenido Erroneo", itElementos.next(),"testtres");
		assertEquals("Cuarto Dato obtenido Erroneo", itElementos.next(),"testcuatro");
		
		//Pruebo que no haya elementos en la lista
		assertFalse("Existen elementos en la lista",itElementos.hasNext());
		
		
			
		
	}

}
