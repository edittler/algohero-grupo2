package programa;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		super(717,538, unControladorJuego);
		this.setTitle("JUEGO");
	}

	private static final long serialVersionUID = 1L;

}
