package algo3c1g2.modelo.figura;

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
