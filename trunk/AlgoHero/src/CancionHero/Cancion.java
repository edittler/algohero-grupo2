package CancionHero;

import java.util.*;
import CancionHero.Nota.*;
import CancionHero.Tecla.*;

public class Cancion {

	private String nombre;
	private int tempo; // [negras/minuto]
	private ArrayList<Compas> compaces;
	private Hashtable<Nota,Tecla> mapeo;

	// Constructor que asigna nombre a la cancion e inicializa colecciones
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new Hashtable<Nota,Tecla>();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}

	public ArrayList<Compas> getCompaces() {
		return compaces;
	}
	
	public void agregarCompas(Compas unCompas) {
		this.compaces.add(unCompas);
	}

	public void asignarMapeoAutomatico(){
		this.mapeo = new Hashtable<Nota,Tecla>();
		
	
	}

}
