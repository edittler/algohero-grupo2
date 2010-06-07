package grupo2.modelo;

import grupo2.modelo.tecla.CombinacionDeTeclas;
import grupo2.modelo.tecla.MapaDeTeclas;

public abstract class ElementoDeCompas {

	// devuelve la duracion medida en negras.
	public abstract double getDuracion();

	public abstract boolean chequear(MapaDeTeclas mapeo,
			CombinacionDeTeclas teclasPresionadas);
}
