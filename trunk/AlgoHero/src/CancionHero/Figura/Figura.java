package CancionHero.Figura;

public abstract class Figura {

	private float cantidadNegras;

	protected void setCantidadNegras(float cantidadNegras) {
		this.cantidadNegras = cantidadNegras;
	}

	public float getDuracion() {
		return cantidadNegras;
	}
	
}
