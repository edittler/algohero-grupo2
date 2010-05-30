package CancionHero;

import java.util.*;

public class Cancion {

	private ArrayList<Compas> compaces;
	private int tempo; //[negras/minuto]
	private Hashtable mapeo;
	
	public ArrayList<Compas> getCompaces() {
		return compaces;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public int getTempo() {
		return tempo;
	}

}
