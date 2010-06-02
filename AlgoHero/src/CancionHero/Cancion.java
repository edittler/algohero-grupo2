package CancionHero;

import java.util.*;

import CancionHero.Nota.*;
import CancionHero.Tecla.*;
import Constantes.Constantes;

public class Cancion {

	private String nombre;
	private int tempo; // [negras/minuto]
	private ArrayList<Compas> compaces;
	private Hashtable<Tono,Tecla> mapeo;

	// Constructor que asigna nombre a la cancion e inicializa colecciones
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new Hashtable<Tono,Tecla>();
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
	
	public Hashtable<Tono, Tecla> getMapeo(){
		return mapeo;
	}
	
	public void agregarCompas(Compas unCompas) {
		this.compaces.add(unCompas);
	}

	public void mapearTeclas(ArrayList<Tecla> teclas){
		this.mapeo = new Hashtable<Tono,Tecla>();
		Iterator<Compas> itCompaces = this.getCompaces().iterator();
		Iterator<Tecla> itTeclas = teclas.iterator();
		/* Si la cantidad de claves del mapeo es igual a la CANTIDAD DE NOTAS,
		 * significa que se agregaron todas las notas posibles.
		 * Ese es el punto en el que finaliza el Mapeo
		 */
		
		while ((this.mapeo.size()<=Constantes.CANTIDAD_NOTAS)&&(itCompaces.hasNext())){
		
			/* 
			 * Obtengo un Compas y le pido q mapee sus notas
			 */
			
			Compas unCompas = itCompaces.next();
			unCompas.mapear(mapeo, itTeclas);
		}
	} // Fin Metodo mapeoAutomatico

}
