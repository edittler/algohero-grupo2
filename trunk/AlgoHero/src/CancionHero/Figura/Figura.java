package CancionHero.Figura;

public abstract class Figura {

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
