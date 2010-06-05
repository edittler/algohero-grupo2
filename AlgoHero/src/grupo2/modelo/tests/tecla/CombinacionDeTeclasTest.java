package grupo2.modelo.tests.tecla;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
import grupo2.modelo.tecla.*;

public class CombinacionDeTeclasTest {
	
	@Test
	public void  testGetTeclaDeCombinacion(){
	//se crea una combinacion de teclas con el constructor sin parametros
	CombinacionDeTeclas unaCombinacion = new CombinacionDeTeclas();
	
	//creo una tecla 'A' y la agrego en la combinacion
	Tecla teclaA = new Tecla(65);
	unaCombinacion.agregarTecla(teclaA);
	
	//creo otra tecla 'B' y la agrego en la combinacion
	Tecla teclaB = new Tecla(66);
	unaCombinacion.agregarTecla(teclaB);
	
	Iterator<Tecla> itTeclas = unaCombinacion.getIteradorTeclas();
	
	assertEquals("Tecla_A invalida", itTeclas.next().getTecla(), 'A');
	assertEquals("Tecla_B invalida", itTeclas.next().getTecla(), 'B');
	}
	
}
