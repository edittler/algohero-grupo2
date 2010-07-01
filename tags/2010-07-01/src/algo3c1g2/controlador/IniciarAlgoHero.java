package algo3c1g2.controlador;

import algo3c1g2.GeneradorCancion;
import algo3c1g2.GolDeMessiDondeEstas;
import algo3c1g2.modelo.Cancion;
import algo3c1g2.persistencia.PersistidorCancion;
import algo3c1g2.vista.Mesa;
import algo3c1g2.vista.VentanaPrincipal;
import algo3c1g2.vista.VistaFondo;
import algo3c1g2.vista.VistaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class IniciarAlgoHero {
	
	
public static void main(String[] args) {
		
		ControladorJuego controlador = new ControladorJuego(true);
		
		// PANTALLA DE BIENVENIDA
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
		VistaPrincipal principal = new VistaPrincipal();
		controlador.agregarDibujable(principal);
	    controlador.comenzarJuego(1);
		controlador.detenerJuego();
		
		
		/************CREAMOS UNA CANCION********************/
		GeneradorCancion unGenerador = new GolDeMessiDondeEstas();
		String rutaArchivo = unGenerador.obtenerArchivoCancion();
		
		PersistidorCancion unPersistidor = new PersistidorCancion();
		Cancion unaCancion = unPersistidor.cargarCancion(rutaArchivo);
		/************************************************/
	 
	
	Mesa unaMesa = new Mesa(717,538);
	VistaFondo vistaMesa = new VistaFondo();
	vistaMesa.setPosicionable(unaMesa);
	controlador.agregarDibujable(vistaMesa);
	
	Guitarra unaGuitarra=new Guitarra(unaCancion,controlador);
	Escuchador escu = new Escuchador(unaGuitarra);
	controlador.agregarKeyPressObservador(escu);
	controlador.agregarObjetoVivo(unaGuitarra);

		
}

}
