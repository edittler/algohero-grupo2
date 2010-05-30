package CancionHero.Nota;

import CancionHero.ElementoDeCompas;
import CancionHero.Figura.*;

public class Nota extends ElementoDeCompas {

	private Tono tono;
	private Figura figura;
	
	public Nota(){
		this.setTono(new Do());
		this.setFigura(new Negra());
	}
	
	public Nota(Tono unTono, Figura unaFigura){
		this.setTono(unTono);
		this.setFigura(unaFigura);
	}
	
	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	public void setTono(Tono tono) {
		this.tono = tono;
	}

	public Tono getTono() {
		return tono;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}

}
