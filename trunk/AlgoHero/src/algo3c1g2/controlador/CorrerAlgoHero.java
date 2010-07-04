package algo3c1g2.controlador;


import algo3c1g2.vista.images.ImageFondoInicio;
import algo3c1g2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class CorrerAlgoHero {

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
		
		//VentanaInicial ventana = new VentanaInicial(controlador);
		//ventana.setVisible(true);
		
		
		
		
		
		
	}
}
