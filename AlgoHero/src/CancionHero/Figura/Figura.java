package CancionHero.Figura;

import CancionHero.ElementoDeCompas;

public class Figura extends ElementoDeCompas {

	private double duracion;//Medida en negras
	
	public Figura(double duracion){
		setDuracion(duracion);
	}
	
	// devuelve la duracion medida en negras
	public double getDuracion() {
		return duracion;
	}
	
	protected void setDuracion(double duracion) {
		this.duracion = duracion;
	}

}
