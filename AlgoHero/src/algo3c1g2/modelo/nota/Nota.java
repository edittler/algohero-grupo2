package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.figura.Figura;
import algo3c1g2.modelo.figura.Negra;


public abstract class Nota extends ElementoDeCompas {

	private int frecuencia;
	protected int cuerda;
	
	/*
	 * Poscondicion: Asigna la frecuencia pasada por parametro y la Figura Negra por default
	 */
	public Nota(int frecuencia){
		this.setFrecuencia(frecuencia);
		this.setFigura(new Negra());
	}
	
	
	/*
	 * Poscondicion: Asigna la frecuencia y Figura pasadas por parametro
	 */
	public Nota(int frecuencia, Figura unaFigura){
		this.setFrecuencia(frecuencia);
		this.setFigura(unaFigura);
	}
	
	
	protected void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	
	public float getFrecuencia() {
		return frecuencia;
	}
	
	
	public boolean equals(Object o){
		
		//Compruebo si se referencia al mismo objeto 
	    if ( this == o ) return true; 
	    
	    //Compruebo si el objeto es nulo 
	    if ( o == null ) return false; 
	    
	    //Compruebo si son de distinta clase 
	    if ( this.getClass() != o.getClass() ) return false; 
	    
	    //Si no paso la comprobacion anterior, es porque es de la misma clase
	    //Ahora comparo la frecuencia y la duracion de la figura.
	    // Antes debo castear el objeto recibido
	    if (this.getFrecuencia()==this.getClass().cast(o).getFrecuencia())
	    		 return true; 
	    else return false;
	}
	
	
	// Devuelve la duracion de la negra medida en figuras negras
	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	

	
	
	public boolean isNota(){
		return true;
	}
	
	public abstract int getCuerda();

}
