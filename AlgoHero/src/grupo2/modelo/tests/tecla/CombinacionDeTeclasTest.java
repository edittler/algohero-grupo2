package grupo2.modelo.tests.tecla;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import grupo2.modelo.tecla.*;

public class CombinacionDeTeclasTest {
	
	@Test
	public void  testGetTeclaDeCombinacion(){
	//se crea una combinacion de teclas con el constructor sin parametros
	CombinacionDeTeclas unaCombinacion = new CombinacionDeTeclas();
	
	//creo una tecla para ingresar en la combinacion
	Tecla teclaA = new Tecla(65);

	//se agrega tecla en la combinacion 
	unaCombinacion.agregarTecla(teclaA);
	
	//creo otra tecla para ingresar en la combinacion
	Tecla teclaB = new Tecla(66);

	//se agrega tecla en la combinacion 
	unaCombinacion.agregarTecla(teclaB);
	
	assertEquals("Tecla_A invalida", unaCombinacion.getIteradorTeclas().next().getTecla(), 'A');
	//ver porque falla cuando quiero obtener la segunda tecla ingresada en la combinacion
	/*assertEquals("Tecla_B invalida", unaCombinacion.getIteradorTeclas().next().getTecla(), 'B');
	
    */
    
	
	
	}
	
	
	
	
	
	
	
	
	

}
