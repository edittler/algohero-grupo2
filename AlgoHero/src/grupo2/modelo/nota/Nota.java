package grupo2.modelo.nota;

import java.util.Iterator;

import grupo2.modelo.ElementoDeCompas;
import grupo2.modelo.figura.*;
import grupo2.modelo.tecla.CombinacionDeTeclas;
import grupo2.modelo.tecla.MapaDeTeclas;
import grupo2.modelo.tecla.Tecla;

public abstract class Nota extends ElementoDeCompas {

	private float frecuencia;
	private Figura figura;
	
	/*
	 * Poscondicion: Asigna la frecuencia pasada por parametro y la Figura Negra por default
	 */
	public Nota(float frecuencia){
		this.setFrecuencia(frecuencia);
		this.setFigura(new Negra());
	}
	
	/*
	 * Poscondicion: Asigna la frecuencia y Figura pasadas por parametro
	 */
	public Nota(float frecuencia, Figura unaFigura){
		this.setFrecuencia(frecuencia);
		this.setFigura(unaFigura);
	}
	
	protected void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}

	public float getFrecuencia() {
		return frecuencia;
	}

	protected void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}
	
	// Devuelve la duracion de la negra medida en figuras negras
	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	public boolean chequear(MapaDeTeclas mapeo,	CombinacionDeTeclas teclasPresionadas){
		Iterator<Tecla> itTeclasPresionadas = teclasPresionadas.getIteradorTeclas();
		boolean resultado= true;
		while(itTeclasPresionadas.hasNext()&&resultado){
			Tecla unaTeclaPresionada = itTeclasPresionadas.next();
			resultado = (mapeo.obtenerCombinacion(this).contains(unaTeclaPresionada));
		}
		return resultado;
	}
	
}
