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
	
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (this.getClass() != obj.getClass()){
			return false;
		}
		Tono unTono = (Tono) obj;
		Float unFloat = this.getFrecuencia();
		Float otroFloat = unTono.getFrecuencia();
		return (0==unFloat.compareTo(otroFloat));
	}
	
}
