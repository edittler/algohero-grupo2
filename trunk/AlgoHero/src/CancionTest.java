import CancionHero.*;
import CancionHeroTest.*;

@TestCase
public class CancionTest {

	@Test
	public void crearCancionCumpleFeliz(){
		Cancion CumpleFeliz = new Cancion("CumpleFeliz");
		CumpleFeliz.setTempo(90);
		
		Compas unCompas = new Compas(3,4);
	
		unCompas.agregarElemento(new Silencio(new Blanca()));
		
		Nota unaNota = new Nota(new Do(), new Corchea());
		unCompas.agregarElemento(unaNota);
		
		unCompas.agregarElemento(new Silencio(new Semicorchea()))
		
		unaNota = new Nota(new Do(), new Semicorchea());
		unCompas.agregarElemento(unaNota);
		
		//finalizamos la creacion del compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
		unCompas = new Compas(3,4);
		
		unaNota = new Nota(new Re(), new Negra());
		unCompas.agregarElemento(unaNota);
		
		unaNota = new Nota(new Do(), new Negra());
		unCompas.agregarElemento(unaNota);
	
		unaNota = new Nota(new Fa(), new Negra());
		unCompas.agregarElemento(unaNota);
	
		//finalizamos la creacion del segundo compas, lo agregamos a la cancion
		CumpleFeliz.agregarCompas(unCompas);
		
	}
	
}
