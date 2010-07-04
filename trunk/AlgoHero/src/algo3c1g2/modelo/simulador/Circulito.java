package algo3c1g2.modelo.simulador;


import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Circulito implements ObjetoVivo, Posicionable {


	private int x;
	private int y;
	private boolean habilitado;
	private boolean fueReproducido;
	private double instanteASerReproducido;
	private int numeroDeCuerda;
	private String teclas;

	public Circulito(int numeroDeCuerda) {
		this.setNumeroDeCuerda(numeroDeCuerda);
		this.y = 0;
		this.habilitado = false;
		this.fueReproducido = false;
		this.teclas="";
	}
	
	/********************************************
	 * ATRIBUTOS CORRESPONDIENTES A OBJETO VIVO *
	 ********************************************/

	public boolean estaHabilitado() {
		return this.habilitado;
	}

	public void habilitar() {
		this.habilitado = true;
	}

	public void reiniciar() {
		this.y = 0;
		this.habilitado = false;
		this.fueReproducido = false;
		this.teclas="";
	}

	@Override
	public void vivir() {
		this.y+=(this.habilitado)? 1 : 0;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	
	public void establecerQueFueReproducido() {
		this.fueReproducido = true;
	}

	public boolean fueReproducido() {
		return fueReproducido;
	}

	private void setNumeroDeCuerda(int numeroDeCuerda) {
		this.numeroDeCuerda = numeroDeCuerda;
	}

	public int getNumeroDeCuerda() {
		return numeroDeCuerda;
	}

	public void setTeclas(String teclas) {
		this.teclas = teclas;
	}

	public String getTeclas() {
		return teclas;
	}

	public void setInstanteASerReproducido(double instanteASerReproducido) {
		this.instanteASerReproducido = instanteASerReproducido;
	}

	public double getInstanteASerReproducido() {
		return instanteASerReproducido;
	}
	
	/** 
	 * @param instante Instante en el que se quiere validar la condicion de reproduccion.
	 * @param presicion Presicion con la cual se quiere validad la condicion de reproduccion.
	 * @param teclas Teclas con la cual se quiere validar la condicion de reproduccion.
	 * @return Devuelve {@code True} si el {@code Circulito} no fue reproducido,
	 * 		si las teclas coinciden con las del {@code Circulito}, y si el instante
	 * 		de reproduccion del {@code Circulito} esta en el rango de presicion
	 * 		del instante pasado por parametro.
	 */
	public boolean cumpleConLaCondiccionDeReproduccion(double instante, double presicion,String teclas){
		return ((!this.fueReproducido()) //que no fue reproducido anteriormente 
		&&(this.getTeclas().equals(teclas))//que tenga las mismas teclas
		&&((this.getInstanteASerReproducido()+presicion)>=instante)//y que entre en el rango de presicion
		&&(((this.getInstanteASerReproducido()-presicion)<=instante)));
	}



}
