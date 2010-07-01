package algo3c1g2.modelo.figura;

public abstract class Figura {

	private double duracion;//Medida en negras
	
	public Figura(double duracion){
		setDuracion(duracion);
	}
	
	// devuelve la duracion medida en negras
	public double getDuracion() {
		return duracion;
	}
	
	protected void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public boolean equals(Object o){
		
		//Compruebo si se referencia al mismo objeto 
	    if ( this == o ) return true; 
	    
	    //Compruebo si el objeto es nulo 
	    if ( o == null ) return false; 
	    
	    //Compruebo si son de la misma clase, condicion para que sea True la igualdad
	    if ( this.getClass() == o.getClass() ) return true;
	    else return false;
	    
	}

}
