package grupo2.modelo;

import grupo2.modelo.figura.Figura;
import grupo2.modelo.tecla.CombinacionDeTeclas;
import grupo2.modelo.tecla.MapaDeTeclas;

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
}
