package CancionHero;

import java.util.ArrayList;
import java.util.Hashtable;
import CancionHero.Nota.Tono;
import CancionHero.Tecla.Tecla;

public abstract class ElementoDeCompas {

	// devuelve la duracion medida en negras.
	public abstract double getDuracion();
	
	// mapea la nota en la tecla dada por el orden del iterador
	public abstract void mapear(Hashtable<Float,Integer> mapeo, ArrayList<Tecla> teclas, int indiceTeclas);
}
