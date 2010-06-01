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

	protected ArrayList<Compas> getCompaces() {
		return compaces;
	}
	
	public void agregarCompas(Compas unCompas) {
		this.compaces.add(unCompas);
	}

	public void mapeoAutomatico(ArrayList<Tecla> teclas){
		this.mapeo = new Hashtable<Tono,Tecla>();
		Iterator<Compas> itCompaces = this.getCompaces().iterator();
		
		/* Si la cantidad de claves del maeo es igual a la CANTIDAD DE NOTAS,
		 * significa que se agregaron todas las notas posibles.
		 * Ese es el punto en el que finaliza el Mapeo
		 */
		
		while (this.mapeo.size() <= Constantes.CANTIDAD_NOTAS){
		
			/* 
			 * Obtengo un Compas y recorro las notas
			 */
			
			int indiceTeclas = 0; //Es el indice para acceder a la lista de Teclas
			
			while (itCompaces.hasNext()){
				Compas unCompas = itCompaces.next();
				Iterator<ElementoDeCompas> itNotas = unCompas.getElementos().iterator();
			
				while (itNotas.hasNext()){
					
					/* Si el ElementoDeCompas es Nota,
					 * Procede a asignar el mapeo.
					 * (Todavia no se resolvio como asignar mapeo a acorde)
					 * (Hay que resolver la excepcion, lo ideal seria que
					 * si lanza error que lo ignore)
					 */
					
					Nota unaNota = (Nota) itNotas.next();
					
					/* Adquiero el Tono de la Nota.
					 * Si el Tono no esta en Hashtable, no tiene tecla asignada.
					 * Entonces, le asigno una tecla.
					 */
					Tono unTono = unaNota.getTono();
				
					if (this.mapeo.contains(unTono)==false){
						
						/* A falta de conocer si Java implementa una
						 * Lista Circular, se resolvio utilizar un 
						 * ArrayList y verificar el indice con el tamaño del array.
						 * Si el indice es igual al tamaño, se reinicia a 0
						 */
						if (indiceTeclas < teclas.size()){
							this.mapeo.put(unTono, teclas.get(indiceTeclas));
						} else {
							indiceTeclas = 0;
							this.mapeo.put(unTono, teclas.get(indiceTeclas));
						}
						indiceTeclas+=indiceTeclas;
					}
				}
			}
		}
	} // Fin Metodo mapeoAutomatico

}
