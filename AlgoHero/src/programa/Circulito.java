package programa;

import algo3c1g2.modelo.nota.Nota;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Circulito implements ObjetoVivo, Posicionable {

	private int x;
	private int y;
	private Nota nota;
	private boolean habilitado;
	private int POSICION_INICIAL_Y=-45; 
	
	public Circulito(Nota nota){
		
		this.nota=nota;
		this.x=nota.ubicacionCuerda();
		this.y=POSICION_INICIAL_Y;
		habilitado=false;
	}
	
	public boolean estaHabilitado(){
		return this.habilitado;
	}
	
	public void habilitar(){
		this.habilitado=true;
	}
	
	public void reiniciar(){
		this.y=POSICION_INICIAL_Y;
		habilitado=false;
	}
	
	@Override
	public void vivir() {	
		if(habilitado)
		this.y=this.y+2;
		if(this.y>VentanaPrincipal.TAMAÑO_VERTICAL){  
			this.reiniciar();
		}
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x=x;		
	}

}
