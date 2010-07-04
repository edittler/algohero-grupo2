package algo3c1g2.modelo.tecla;



import java.util.Hashtable;

import algo3c1g2.modelo.excepciones.NoHayTeclasHabilitadasExcepcion;
import algo3c1g2.modelo.nota.Nota;

public class MapaDeTeclas {
	
	private Hashtable<String,CombinacionDeTeclas> mapa;
	
	public MapaDeTeclas(){
		this.mapa=new Hashtable<String,CombinacionDeTeclas>();
	}
	
	public void agregarMapeo(Nota nota,CombinacionDeTeclas combinacion){
		this.mapa.put(nota.getClass().getName(),combinacion);
	}
	
	public CombinacionDeTeclas obtenerCombinacion(Nota nota){
		CombinacionDeTeclas unaCombi = this.mapa.get(nota.getClass().getName());
		if (unaCombi==null) throw new NoHayTeclasHabilitadasExcepcion();
		return unaCombi;
	}
	
	public Hashtable<String, CombinacionDeTeclas> getMapa(){
		return this.mapa;
	}

}
