package CancionHero.Nota;

import java.util.ArrayList;
import java.util.Hashtable;
import CancionHero.ElementoDeCompas;
import CancionHero.Figura.*;
import CancionHero.Tecla.Tecla;
import Constantes.Constantes;

public abstract class Nota extends ElementoDeCompas {

	private float frecuencia;
	private Figura figura;
	
	// Constructor por defecto crea una nota Do Negra
//	public Nota(){
//		this.setFrecuencia(Constantes.FRECUENCIA_DO); NO SE PUEDE INSTANCIAR !!!!!!!!!!!!!
//		this.setFigura(new Negra());
//	}
	
	public Nota(float frecuencia){
		this.setFrecuencia(frecuencia);
		this.setFigura(new Negra());
	}
	public Nota(float frecuencia, Figura unaFigura){
		this.setFrecuencia(frecuencia);
		this.setFigura(unaFigura);
	}
	
	private void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}

	public float getFrecuencia() {
		return frecuencia;
	}

	
	// Devuelve la duracion de la negra medida en figuras negras
	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	private void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}
	


}
