package algo3c1g2.modelo;

import algo3c1g2.modelo.figura.Figura;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.MapaDeTeclas;

public abstract class ElementoDeCompas {
	
	private Figura figura;
	
	// devuelve la duracion medida en negras.
	public abstract double getDuracion();
	
	public double getDuracionEnSegundos(int Tempo){
		return (this.getDuracion()/((Tempo/60.00)));
	}
	public abstract boolean isNota();

	public void setFigura(Figura figura) {
		this.figura = figura;
	}
	
	public Figura getFigura(){
		return this.figura;
	}
}
