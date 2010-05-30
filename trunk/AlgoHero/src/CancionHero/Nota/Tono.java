package CancionHero.Nota;



public class Tono {

	private float frecuencia;

	public Tono(float frecuencia) {
		this.setFrecuencia(frecuencia);
	}

	protected void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}

	public float getFrecuencia() {
		return frecuencia;
	}
	
}
