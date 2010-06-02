package CancionHero;

import java.util.Hashtable;
import java.util.Iterator;

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
	
	public void mapear(Hashtable<Tono,Tecla> mapeo, Iterator<Tecla> itTeclas){
		// como el silencio no se mapea, no realiza ninguna operacion.
	}

}
