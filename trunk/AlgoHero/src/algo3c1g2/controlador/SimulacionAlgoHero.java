package algo3c1g2.controlador;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.Silencio;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.simulador.Circulito;
import algo3c1g2.modelo.simulador.Guitarra;
import algo3c1g2.modelo.simulador.Puntaje;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import algo3c1g2.persistencia.PersistidorCancion;
import algo3c1g2.vista.TextoCirculito;
import algo3c1g2.vista.VistaPuntaje;
import algo3c1g2.vista.images.ImageCirculito;
import algo3c1g2.vista.images.ImageFondoGuitarra;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class SimulacionAlgoHero {
	private ControladorJuego controlador;
	
	public SimulacionAlgoHero(ControladorJuego unControlador,String cancionAReproducir){
		this.controlador=unControlador;
	
		PersistidorCancion unPersistidor = new PersistidorCancion();
		Cancion unaCancion = unPersistidor.cargarCancion(cancionAReproducir);
//      unaCancion = new Cancion("unacancionsita");
//      Compas unCompas = new Compas();
//      unCompas.agregarElemento(new FaSostenido(new Corchea()));
//      unCompas.agregarElemento(new FaSostenido(new Semicorchea()));
//      unCompas.agregarElemento(new Re(new Semicorchea()));
//      unCompas.agregarElemento(new FaSostenido(new Semicorchea()));
//      unCompas.agregarElemento(new Si(new Semicorchea()));
//      unCompas.agregarElemento(new Si(new Corchea()));
//      unCompas.agregarElemento(new Silencio(new Blanca()));
//
//      unaCancion.agregarCompas(unCompas);
//      
//      CombinacionDeTeclas unaCombinacion= new CombinacionDeTeclas();
//      unaCombinacion.agregarTecla(new Tecla('A'));
//      unaCancion.mapear(new FaSostenido(), unaCombinacion);
//      
//       unaCombinacion= new CombinacionDeTeclas();
//      unaCombinacion.agregarTecla(new Tecla('A'));
//      unaCancion.mapear(new Re(), unaCombinacion);
//      
//       unaCombinacion= new CombinacionDeTeclas();
//      unaCombinacion.agregarTecla(new Tecla('A'));
//      unaCancion.mapear(new Si(), unaCombinacion);
		unaCancion.setTempo(130);
		/************************************************/
	
        ImageFondoGuitarra vistaMesa = new ImageFondoGuitarra();
        controlador.agregarDibujable(vistaMesa);
        
		Puntaje puntaje = new Puntaje(unaCancion);
        Guitarra unaGuitarra = new Guitarra(unaCancion,controlador.getReproductorDeAudio());
        
        configuracionInicial(controlador,unaGuitarra,puntaje,6,12);
        
        int intervalo =(int) (1000*(60.00/unaCancion.getTempo())/64);
        controlador.setIntervaloSimulacion(intervalo);
        controlador.agregarObjetoVivo(unaGuitarra);
		
	}


	private static void configuracionInicial(ControladorJuego controlador,Guitarra unaGuitarra,Puntaje puntaje,int cuerdas, int circulitosPorCuerda) {
		Circulito unCirculito = null;
		ImageCirculito unaImageCirculito = null;
		TextoCirculito unTextoCirculito = null;

		VistaPuntaje vistaPuntaje = new VistaPuntaje("");
		vistaPuntaje.setPosicionable(puntaje);
		controlador.agregarDibujable(vistaPuntaje);
		
		Escuchador escu = new Escuchador(unaGuitarra,puntaje);
		controlador.agregarKeyPressObservador(escu);
	
		
		for(int i=1;i<=cuerdas;i++){    //TODO PRUEBAS que no permita agregar en la cuerda 7
			for(int j=0;j<circulitosPorCuerda;j++){
			unCirculito=new Circulito(i); //se crea el ciculito para la cuerda i
			
			unaImageCirculito = new ImageCirculito(); //se crean las vistas y se les asigna el posicionable unCirculito
			unaImageCirculito.setPosicionable(unCirculito);
			unTextoCirculito = new TextoCirculito("");
			unTextoCirculito.setPosicionable(unCirculito);
			
			controlador.agregarObjetoVivo(unCirculito);//Se agregan al controlador
			controlador.agregarDibujable(unaImageCirculito);
			controlador.agregarDibujable(unTextoCirculito);

			//Y por ultimo se agregan a la guitarra
			unaGuitarra.agregarCirculito(unCirculito);
			}

						
		}
	}
		
  public void comenzar(){
	  controlador.comenzarJuegoAsyn();
  }
	
}

