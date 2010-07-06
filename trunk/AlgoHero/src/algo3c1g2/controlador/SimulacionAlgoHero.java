package algo3c1g2.controlador;

import java.io.FileNotFoundException;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.simulador.Circulito;
import algo3c1g2.modelo.simulador.Guitarra;
import algo3c1g2.modelo.simulador.Puntaje;
import algo3c1g2.persistencia.PersistidorCancion;
import algo3c1g2.vista.TextoCirculito;
import algo3c1g2.vista.VistaGuitarra;
import algo3c1g2.vista.VistaPuntaje;
import algo3c1g2.vista.images.ImageCirculito;
import algo3c1g2.vista.images.ImageFondoGuitarra;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class SimulacionAlgoHero {
	private ControladorJuego controlador;
	
	public SimulacionAlgoHero(ControladorJuego unControlador,String cancionAReproducir){
		this.controlador=unControlador;
	
		PersistidorCancion unPersistidor = new PersistidorCancion();
		Cancion unaCancion = null;
		try {
			unaCancion = unPersistidor.cargarCancion(cancionAReproducir);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* ***********************************************/
	
        ImageFondoGuitarra vistaMesa = new ImageFondoGuitarra();
        controlador.agregarDibujable(vistaMesa);
        
		Puntaje puntaje = new Puntaje(unaCancion);
        Guitarra unaGuitarra = new Guitarra(unaCancion,controlador.getReproductorDeAudio());
        
        configuracionInicial(controlador,unaGuitarra,puntaje,6,12);
        
        int intervalo =(int) (1000*(60.00/unaCancion.getTempo())/64);
        controlador.setIntervaloSimulacion(intervalo);
        controlador.agregarObjetoVivo(unaGuitarra);
        
        VistaGuitarra vGuitarra= new VistaGuitarra();
        vGuitarra.setPosicionable(unaGuitarra);
        controlador.agregarDibujable(vGuitarra);
		
	}

	public void comenzar(){
		controlador.comenzarJuegoAsyn();
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
				// Se crea el ciculito para la cuerda i
				unCirculito=new Circulito(i);
				//Se crea la vista y se le asigna el posicionable unCirculito
				unaImageCirculito = new ImageCirculito();
				unaImageCirculito.setPosicionable(unCirculito);
				unTextoCirculito = new TextoCirculito("");
				unTextoCirculito.setPosicionable(unCirculito);
				//Se agregan al controlador
				controlador.agregarObjetoVivo(unCirculito);
				controlador.agregarDibujable(unaImageCirculito);
				controlador.agregarDibujable(unTextoCirculito);
				//Y por ultimo se agregan a la guitarra
				unaGuitarra.agregarCirculito(unCirculito);
			}				
		}
	}
	
}

