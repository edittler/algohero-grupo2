package grupo2.modelo.tests;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.Blanca;
import grupo2.modelo.nota.Do;
import grupo2.modelo.nota.Nota;
import grupo2.modelo.nota.SolSostenido;
import junit.framework.TestCase;
public class TestNota extends TestCase {

	public void testConstructor(){
		Nota unaNota = new Do();
		assertTrue(unaNota.getFrecuencia()==Constantes.FRECUENCIA_DO);
		assertTrue(unaNota.getDuracion()==Constantes.NEGRA);
		
		unaNota = new SolSostenido(new Blanca());
		
		assertTrue(unaNota.getFrecuencia()==Constantes.FRECUENCIA_SOL_SOSTENIDO);
		assertTrue(unaNota.getDuracion()==Constantes.BLANCA);
	}
	
}
