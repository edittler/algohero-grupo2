package algo3c1g2.modelo;

import algo3c1g2.modelo.figura.Figura;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.MapaDeTeclas;

public class Silencio extends ElementoDeCompas {

	private Figura figura;

	public Silencio(Figura unaFigura) {
		this.setFigura(	unaFigura);
	}

	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	private void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}
	public boolean chequear(MapaDeTeclas mapeo,
			CombinacionDeTeclas teclasPresionadas){
		return false;
	}

	@Override
	public boolean isNota() {
		return false;
	}
	
}
