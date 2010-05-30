package CancionHero.Figura;

import CancionHero.ElementoDeCompas;

public class Figura extends ElementoDeCompas {

	private double Duracion;//Medida en negras
	
	public Figura(double duracion){
		setDuracion(duracion);
	}
	
	public double getDuracion() {
		return Duracion;
	}
	
	protected void setDuracion(double duracion) {
		Duracion = duracion;
	}

}
