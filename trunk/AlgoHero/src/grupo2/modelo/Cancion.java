package grupo2.modelo;

import java.util.*;
import grupo2.modelo.excepciones.*;
import grupo2.modelo.tecla.*;

public class Cancion {

	private String nombre;
	private int tempo; // [negras/minuto]
	private ArrayList<Compas> compaces;
	private MapaDeTeclas mapeo;// almacanena correspondencias entre un tono (diferenciadopor su frecuencia)
										// y una combinacion de teclas
	// Constructor que asigna nombre a la cancion e inicializa colecciones
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.tempo = 90;
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new MapaDeTeclas();
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
	
	public MapaDeTeclas getMapeo(){
		return mapeo;
	}
	
	public void agregarCompas(Compas unCompas) {
		if (unCompas.estaInconcluso()){
			throw new CompasInvalidoExcepcion();
		}
		this.compaces.add(unCompas);
	}

	public void mapear(float nota, CombinacionDeTeclas combinacion){
		this.mapeo.agregarMapeo(nota, combinacion);
	}

}
