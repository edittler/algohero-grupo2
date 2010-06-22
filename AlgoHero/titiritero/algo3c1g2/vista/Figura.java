package algo3c1g2.vista;

import java.awt.Color;

import algo3c1g2.Dibujable;
import algo3c1g2.MouseClickObservador;
import algo3c1g2.Posicionable;
import algo3c1g2.SuperficieDeDibujo;


public abstract class Figura implements Dibujable, MouseClickObservador {

	private Color color;
	private Posicionable posicionable;
	
	public abstract void dibujar(SuperficieDeDibujo superfice) ;

	public void setColor(Color unColor){
		this.color =unColor; 
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;		
	}

	public void MouseClick(int x, int y){
		System.out.println("Click;" + x + "," + y);
	}
		
}
