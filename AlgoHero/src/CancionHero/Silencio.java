package CancionHero;

import CancionHero.Figura.*;

public class Silencio extends ElementoDeCompas {

	private Figura figura;
	
	public Silencio(Figura unaFigura) {
		this.figura=unaFigura;
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

}
