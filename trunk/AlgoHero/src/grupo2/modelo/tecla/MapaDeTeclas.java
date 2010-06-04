package grupo2.modelo.tecla;


import java.util.Hashtable;

public class MapaDeTeclas {
	
	private Hashtable<Float,CombinacionDeTeclas> mapa;
	
	public MapaDeTeclas(){
		this.mapa=new Hashtable<Float,CombinacionDeTeclas>();
	}
	
	public void agregarMapeo(float nota,CombinacionDeTeclas combinacion){
		this.mapa.put(nota,combinacion);
	}
	
	public CombinacionDeTeclas obtenerCombinacion(float nota){
		return this.mapa.get(nota);
	}
}
