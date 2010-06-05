package grupo2.modelo.tecla;


import grupo2.modelo.nota.Nota;

import java.util.Hashtable;

public class MapaDeTeclas {
	
	private Hashtable<Float,CombinacionDeTeclas> mapa;
	
	public MapaDeTeclas(){
		this.mapa=new Hashtable<Float,CombinacionDeTeclas>();
	}
	
	public void agregarMapeo(Nota nota,CombinacionDeTeclas combinacion){
		this.mapa.put(nota.getFrecuencia(),combinacion);
	}
	
	public CombinacionDeTeclas obtenerCombinacion(Nota nota){
		return this.mapa.get(nota.getFrecuencia());
	}
}
