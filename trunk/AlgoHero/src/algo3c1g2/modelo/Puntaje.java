package algo3c1g2.modelo;

import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Puntaje implements Posicionable {

	private int puntos;
	private Cancion cancion;
	private static final double PRESICION_DEL_JUEGO=0.5; //segundos
	
	public Puntaje(){
		this.puntos= 0;
	}
	
	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	
	public int getPuntos(){
		return this.puntos;
	}

	public boolean contarPuntos(double instante, char tecla){
		CombinacionDeTeclas TeclasPresionadas=new CombinacionDeTeclas();
		Tecla unaTecla=new Tecla(tecla);
		boolean acerto=false;
	
		TeclasPresionadas.agregarTecla(unaTecla);
		acerto= this.cancion.verificarTeclas(TeclasPresionadas, instante, PRESICION_DEL_JUEGO);
			this.puntos=(acerto)?
					this.puntos+=1000
					:this.puntos;
			return true;
		}
		

		

	
	
	
					
					
	
}
