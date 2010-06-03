package CancionHero;

import java.util.ArrayList;
import java.util.Hashtable;
import CancionHero.Figura.*;
import CancionHero.Nota.Tono;
import CancionHero.Tecla.Tecla;

public class Silencio extends ElementoDeCompas {

	private Figura figura;

	public Silencio(Figura unaFigura) {
		this.figura = unaFigura;
	}

	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}
	
	public void mapear(Hashtable<Float,Integer> mapeo, ArrayList<Tecla> teclas, int indiceTeclas){
		// como el silencio no se mapea, no realiza ninguna operacion.
	}

}
