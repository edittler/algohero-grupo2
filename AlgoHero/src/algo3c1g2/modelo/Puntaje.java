package algo3c1g2.modelo;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class Puntaje implements Posicionable {

	private int puntos;
	
	public Puntaje() {
		this.puntos = 0;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void sumarPuntos() {
		this.puntos = this.puntos + 1000;
	}

}
