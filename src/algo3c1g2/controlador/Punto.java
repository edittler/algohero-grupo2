package algo3c1g2.controlador;

import static java.lang.Math.abs;
import static java.lang.Math.hypot;

import ar.uba.fi.algo3.titiritero.Posicionable;



public class Punto implements Posicionable {
	
	private int X;
	private int Y;
	private int hashCode;
	
	public Punto(){
		this.X = 0;
		this.Y = 0;
		this.hashCode = 0;
	}
	
	public Punto(int X, int Y) {
		this.X = X;
		this.Y = Y;
		this.hashCode = this.hashCode();
	}
	
	public Punto(Punto posicion) {
		this.X = posicion.X;
		this.Y = posicion.Y;
		this.hashCode = this.hashCode();
	}

	public int hashCode(){
		this.hashCode = this.X;
		this.hashCode += this.Y;
		return this.hashCode;
	}
	
	public int getPuntoX(){
	
		return this.X;
	}
	
	public int getPuntoY(){
		return this.Y;
	}
	
	/**
	 * Calcula la distancia entre dos puntos y devuelve un int.
	 * @param  
	 * @param  
	 * @return int
	 */
	public double distancia(Punto unPunto){
		
		double distanciaEnX = abs(this.X - unPunto.X);
		double distanciaEnY = abs(this.Y - unPunto.Y);
		
		double unaDistancia = hypot(distanciaEnX,distanciaEnY);
		
		return unaDistancia;
		
	}
	

	public Punto getPosicion() {
		Punto posicion = new Punto(this);
		return posicion;
	}

	public int getX() {
		return this.X;
	}

	public int getY() {
		return this.Y;
	}
	

	
	
}
