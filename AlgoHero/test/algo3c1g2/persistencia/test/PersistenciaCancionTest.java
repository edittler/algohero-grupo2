package algo3c1g2.persistencia.test;

import org.junit.Test;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.Silencio;
import algo3c1g2.modelo.figura.Blanca;
import algo3c1g2.modelo.figura.Corchea;
import algo3c1g2.modelo.figura.Negra;
import algo3c1g2.modelo.figura.Semicorchea;
import algo3c1g2.modelo.nota.Do;
import algo3c1g2.modelo.nota.Fa;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.nota.Re;
import algo3c1g2.persistencia.PersistidorCancion;


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
		
		//retornamos la cancion
		return CumpleFeliz;
	}
	
	public static final void main(String[] args){
		//vamos a persistir la cancion cumple feliz
		Cancion unaCancion = cancionCumpleFeliz();
		
		PersistidorCancion unPersistidorCancion = new PersistidorCancion();
		
		unPersistidorCancion.persistirYGuardar(unaCancion, "canciones/CumpleFeliz.xml");
		unPersistidorCancion.cagarCancion("canciones/CumpleFeliz.xml");
	}
	
}
