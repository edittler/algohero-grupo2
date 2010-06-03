package CancionHero.Nota;

import java.util.ArrayList;
import java.util.Hashtable;
import CancionHero.ElementoDeCompas;
import CancionHero.Figura.*;
import CancionHero.Tecla.Tecla;

public class Nota extends ElementoDeCompas {

	private Tono tono;
	private Figura figura;
	
	// Constructor por defecto crea una nota Do Negra
	public Nota(){
		this.setTono(new Do());
		this.setFigura(new Negra());
	}
	
	public Nota(Tono unTono, Figura unaFigura){
		this.setTono(unTono);
		this.setFigura(unaFigura);
	}
	
	// Devuelve la duracion de la negra medida en figuras negras
	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	public void setTono(Tono tono) {
		this.tono = tono;
	}

	public Tono getTono() {
		return tono;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}
	
	public void mapear(Hashtable<Float,Integer> mapeo, ArrayList<Tecla> teclas, int indiceTeclas){
		if(mapeo.contains(this.getTono())==false){
			if(teclas.size()<indiceTeclas){ //Me huele a un error aca... no seria >   ?
				mapeo.put(this.getTono().getFrecuencia(), teclas.get(indiceTeclas).getCodigoASCII());
				indiceTeclas+=1;
			} else {
				mapeo.put(this.getTono().getFrecuencia(), teclas.get(0).getCodigoASCII());
				indiceTeclas=1;
			}
		}
	}

}
