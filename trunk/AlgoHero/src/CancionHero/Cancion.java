package CancionHero;

import java.util.*;

public class Cancion {

	private String nombre;
	private ArrayList<Compas> compaces;
	private int tempo; //[negras/minuto]
	private Hashtable mapeo;
	
	public Cancion(String Nombre){
		this.setNombre(Nombre);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Compas> getCompaces() {
		return compaces;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public int getTempo() {
		return tempo;
	}

	public void agregarCompas(Compas unCompas) {
		this.compaces.add(unCompas);
		
	}

	

}
