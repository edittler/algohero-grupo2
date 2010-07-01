package algo3c1g2.persistencia.test;

import org.junit.Test;

import algo3c1g2.modelo.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;
import algo3c1g2.persistencia.PersistidorCancion;

/*
 * Este documento no es en realidad un Test, sino un ejemplo de como
 * se usa la persistencia.
 */

@SuppressWarnings("unused")
public class PersistenciaCancionTest {

	public static Cancion cancionCumpleFeliz(){
		Cancion CumpleFeliz = new Cancion("CumpleFeliz");
		CumpleFeliz.setTempo(90);
		
		Compas unCompas = new Compas(3,4);
		unCompas.agregarElemento(new Silencio(new Blanca()));
		
		Nota unaNota = new Do(new Corchea());
		unCompas.agregarElemento(unaNota);
		
		unCompas.agregarElemento(new Silencio(new Semicorchea()));
		
		unaNota = new Do(new Semicorchea());
		unCompas.agregarElemento(unaNota);
		
		//finalizamos la creacion del compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
		unCompas = new Compas(3,4);
		
		unaNota = new Re(new Negra());
		unCompas.agregarElemento(unaNota);
		
		unaNota = new Do(new Negra());
		unCompas.agregarElemento(unaNota);
	
		unaNota = new Fa(new Negra());
		unCompas.agregarElemento(unaNota);
	
		//finalizamos la creacion del segundo compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
		//Agrego las teclas de mapeo
		CombinacionDeTeclas combi = new CombinacionDeTeclas();
		combi.agregarTecla(new Tecla('A'));
		CumpleFeliz.mapear(new Do(), combi);
		
		combi = new CombinacionDeTeclas();
		combi.agregarTecla(new Tecla('S'));
		CumpleFeliz.mapear(new Re(), combi);
		
		//retornamos la cancion
		return CumpleFeliz;
	}
	
	public static final void main(String[] args){
		//vamos a persistir la cancion cumple feliz
		Cancion unaCancion = cancionCumpleFeliz();
		
		PersistidorCancion unPersistidorCancion = new PersistidorCancion();
		
		unPersistidorCancion.persistirYGuardar(unaCancion, "canciones/CumpleFeliz.xml");
		Cancion otraCancion = unPersistidorCancion.cargarCancion("canciones/CumpleFeliz.xml");
		String cancion= otraCancion.toString();
		System.out.print(cancion);
	}
	
}
