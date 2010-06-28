package algo3c1g2.vista;

import algo3c1g2.controlador.Punto;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaPrincipal extends Imagen {

	public VistaPrincipal(){
		String nombreArchivoImagen = "PantallaInicial2.jpg";
		setNombreArchivoImagen(nombreArchivoImagen);
		Punto posicionImagen = new Punto (0, 0);
		setPosicionable(posicionImagen);
	}
	
}
