package algo3c1g2.vista;

import algo3c1g2.Posicionable;


public class Pentagrama implements Posicionable{

	public Pentagrama(int ancho, int alto){

		this.alto = alto;
		this.ancho = ancho;
	}
	
	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}

	private int alto;
	private int ancho;
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

}