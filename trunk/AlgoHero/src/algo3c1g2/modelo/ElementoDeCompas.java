package algo3c1g2.modelo;

import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.MapaDeTeclas;

public abstract class ElementoDeCompas {

	// devuelve la duracion medida en negras.
	public abstract double getDuracion();

	public abstract boolean chequear(MapaDeTeclas mapeo,
			CombinacionDeTeclas teclasPresionadas);
	
	public double getDuracionEnSegundos(int Tempo){
		return (this.getDuracion()/((Tempo/60.00)));
	}
	public abstract boolean isNota();
}
