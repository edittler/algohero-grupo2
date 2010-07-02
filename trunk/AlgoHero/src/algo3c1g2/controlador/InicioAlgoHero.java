package algo3c1g2.controlador;

import algo3c1g2.generadorcanciones.GeneradorCancion;
import algo3c1g2.generadorcanciones.GolDeMessiDondeEstas;
import algo3c1g2.modelo.Cancion;
import algo3c1g2.persistencia.PersistidorCancion;
import algo3c1g2.vista.images.ImageFondoGuitarra;
import algo3c1g2.vista.images.ImageFondoInicio;
import algo3c1g2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

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

		ImageFondoGuitarra vistaMesa = new ImageFondoGuitarra();
		controlador.agregarDibujable(vistaMesa);

		Guitarra unaGuitarra = new Guitarra(unaCancion, controlador);
		Escuchador escu = new Escuchador(unaGuitarra);
		controlador.agregarKeyPressObservador(escu);
		controlador.agregarObjetoVivo(unaGuitarra);
	}

}
