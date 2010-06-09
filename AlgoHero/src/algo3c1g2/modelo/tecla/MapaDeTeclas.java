package algo3c1g2.modelo.tecla;



import java.util.Hashtable;

import algo3c1g2.modelo.nota.Nota;

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
