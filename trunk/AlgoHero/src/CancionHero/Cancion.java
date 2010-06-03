package CancionHero;

import java.util.*;

import CancionHero.Nota.*;
import CancionHero.Tecla.*;
import Constantes.Constantes;
import Excepciones.CompasInvalidoExcepcion;
import Excepciones.NoHayTeclasHabilitadasExcepcion;
import Excepciones.TempoInvalidoException;

public class Cancion {

	private String nombre;
	private int tempo; // [negras/minuto]
	private ArrayList<Compas> compaces;
	private Hashtable<Float,Integer> mapeo;// almacanena correspondencias entre un tono (diferenciadopor su frecuencia)
										// y una tecla (diferenciada por su CodigoASCII) <Tono,Tecla>
	// Constructor que asigna nombre a la cancion e inicializa colecciones
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.tempo = 90;
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new Hashtable<Float,Integer>();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
// 30<= tempo <= 150
	public void setTempo(int tempo)
	{
		if ((tempo<30)||(tempo>150)){
			throw new TempoInvalidoException();
		}
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}

	public ArrayList<Compas> getCompaces() {
		return compaces;
	}
	
	public Hashtable<Float,Integer> getMapeo(){
		return mapeo;
	}
	
	public void agregarCompas(Compas unCompas) {
		if (unCompas.estaInconcluso()){
			throw new CompasInvalidoExcepcion();
		}
		this.compaces.add(unCompas);
	}

	public void mapearTeclas(ArrayList<Tecla> teclas){
		
		if(teclas.size()==0){
			throw new NoHayTeclasHabilitadasExcepcion();
		}
		this.mapeo = new Hashtable<Float,Integer>();
		Iterator<Compas> itCompaces = this.getCompaces().iterator();
		
		/* A falta de lista circular y 
		 * de Iterador que retorne el inicio,
		 * se utiliza una variable de indice del arreglo
		 */
		int indiceTeclas = 0;
				
		/* Si la cantidad de claves del mapeo es igual a la CANTIDAD DE NOTAS,
		 * significa que se agregaron todas las notas posibles.
		 * Ese es el punto en el que finaliza el Mapeo
		 */
		while ((this.mapeo.size()<=Constantes.CANTIDAD_NOTAS)&&(itCompaces.hasNext())){
			/* 
			 * Obtengo un Compas y le pido q mapee sus notas
			 */
			Compas unCompas = itCompaces.next();
			unCompas.mapear(mapeo, teclas, indiceTeclas);
		}
	} // Fin Metodo mapeoAutomatico

}
