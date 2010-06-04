package CancionHeroTest;

import CancionHero.Figura.*;
import CancionHero.Nota.*;
import junit.framework.TestCase;
import Constantes.Constantes;
public class TestNota extends TestCase {

	public void testConstructor(){
		Nota unaNota=new Nota();
		assertTrue(unaNota.getTono().getFrecuencia()==Constantes.FRECUENCIA_DO);
		assertTrue(unaNota.getDuracion()==Constantes.NEGRA);
		
		unaNota=new Nota(new SolSostenido(),new Blanca());
		
		assertTrue(unaNota.getTono().getFrecuencia()==Constantes.FRECUENCIA_SOL_SOSTENIDO);
		assertTrue(unaNota.getDuracion()==Constantes.BLANCA);
	}
	
	public void testSetTono(){
		Nota unaNota=new Nota();
		
		unaNota.setTono(new LaSostenido());
		assertTrue(unaNota.getTono().getFrecuencia()==Constantes.FRECUENCIA_LA_SOSTENIDO);
		
	}
	public void testSetFigura(){
		Nota unaNota=new Nota();
		
		unaNota.setFigura(new Semicorchea());
		assertTrue(unaNota.getDuracion()==Constantes.SEMICORCHEA);
		
	}
}
