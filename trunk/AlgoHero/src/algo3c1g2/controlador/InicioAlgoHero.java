package algo3c1g2.controlador;

import algo3c1g2.generadorcanciones.GeneradorCancion;
import algo3c1g2.generadorcanciones.GolDeMessiDondeEstas;
import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Circulito;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.Guitarra;
import algo3c1g2.modelo.Puntaje;
import algo3c1g2.modelo.figura.Blanca;
import algo3c1g2.modelo.figura.Negra;
import algo3c1g2.modelo.nota.Do;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import algo3c1g2.persistencia.PersistidorCancion;
import algo3c1g2.vista.TextoCirculito;
import algo3c1g2.vista.VistaPuntaje;
import algo3c1g2.vista.images.ImageCirculito;
import algo3c1g2.vista.images.ImageFondoGuitarra;
import algo3c1g2.vista.images.ImageFondoInicio;
import algo3c1g2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class InicioAlgoHero {

	public static void main(String[] args) {

		ControladorJuego controlador = new ControladorJuego(true);

		// PANTALLA DE BIENVENIDA
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);

		ImageFondoInicio principal = new ImageFondoInicio();
		controlador.agregarDibujable(principal);
		controlador.comenzarJuego(1);
		controlador.detenerJuego();

		/************ CREAMOS UNA CANCION ********************/
		GeneradorCancion unGenerador = new GolDeMessiDondeEstas();
		String rutaArchivo = unGenerador.obtenerArchivoCancion();

		PersistidorCancion unPersistidor = new PersistidorCancion();
		Cancion unaCancion = unPersistidor.cargarCancion(rutaArchivo);
		/************************************************/

//		unaCancion = new Cancion("unacancionsita");
//		Compas unCompas = new Compas();
//		unCompas.agregarElemento(new Do(new Blanca()));
//		unCompas.agregarElemento(new Do(new Blanca()));
//		unaCancion.agregarCompas(unCompas);
//		
//		CombinacionDeTeclas unaCombinacion= new CombinacionDeTeclas();
//		unaCombinacion.agregarTecla(new Tecla('A'));
//		unaCancion.mapear(new Do(), unaCombinacion);
		
		
		ImageFondoGuitarra vistaMesa = new ImageFondoGuitarra();
		controlador.agregarDibujable(vistaMesa);
		
		Guitarra unaGuitarra = new Guitarra(unaCancion,controlador.getReproductorDeAudio());
		
		configuracionInicial(controlador,unaGuitarra,6,5);

		controlador.setIntervaloSimulacion(15);
		
	}

	private static void configuracionInicial(ControladorJuego controlador,Guitarra unaGuitarra,int cuerdas, int circulitosPorCuerda) {
		Circulito unCirculito = null;
		ImageCirculito unaImageCirculito = null;
		TextoCirculito unTextoCirculito = null;
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
			Puntaje puntaje = new Puntaje();
			VistaPuntaje vistaPuntaje = new VistaPuntaje("");
			vistaPuntaje.setPosicionable(puntaje);
			controlador.agregarDibujable(vistaPuntaje);
			controlador.agregarObjetoVivo(unaGuitarra);
			
		}
	}

}
