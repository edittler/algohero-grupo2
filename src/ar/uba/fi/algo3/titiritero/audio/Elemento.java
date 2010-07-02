package ar.uba.fi.algo3.titiritero.audio;

public class Elemento {

	private int nota;
	private int duracion;
	public Elemento(int nota, int duracion) {
		this.nota = nota;
		this.duracion = duracion;
	}
	
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
