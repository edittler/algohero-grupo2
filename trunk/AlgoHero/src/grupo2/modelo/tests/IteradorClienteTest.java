package grupo2.modelo.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import grupo2.modelo.*;
import org.junit.*;



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
		IteradorCliente<String> iteradorElementos =  new IteradorCliente<String>(listaElementos);
		
		//testeo que el iterador funcione correctamente
		
		assertEquals("Primer Dato obtenido Erroneo", iteradorElementos.next(),"testuno");
		assertEquals("Segundo Dato obtenido Erroneo", iteradorElementos.next(),"testdos");
		assertEquals("Tercer Dato obtenido Erroneo", iteradorElementos.next(),"testtres");
		assertEquals("Cuarto Dato obtenido Erroneo", iteradorElementos.next(),"testcuatro");
		
		
		
		
			
		
	}

}
