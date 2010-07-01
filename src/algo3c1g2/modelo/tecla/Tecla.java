package algo3c1g2.modelo.tecla;

import algo3c1g2.modelo.excepciones.TeclaNoAceptadaExcepcion;

public class Tecla {

	private int codigoASCII;

	public Tecla(int codigoASCII){
		this.setCodigoASCII(codigoASCII);
	}
	
	public void setCodigoASCII(int codigoASCII) {
		//Solo se permiten ingresar teclas de la A a la Z o de la 'a' a la 'z'
		if (((codigoASCII<65)||(codigoASCII>90))&&((codigoASCII<97)||(codigoASCII>122))){
			throw new TeclaNoAceptadaExcepcion(); 
		}
		this.codigoASCII = codigoASCII;
	}

	public int getCodigoASCII() {
		return codigoASCII;
	}
	
	public char getTecla(){
		return (char)codigoASCII;
	}
	
	public boolean equals(Object o){
		
		//Compruebo si se referencia al mismo objeto 
	    if ( this == o ) return true; 
	    
	    //Compruebo si el objeto es nulo 
	    if ( o == null ) return false; 
	    
	    //Compruebo si son de distinta clase 
	    if ( this.getClass() != o.getClass() ) return false; 
	    
	    // Si no paso la comprobacion anterior, es porque es de la misma clase
	    // Ahora comparo el codigo ASCII
	    if (this.getCodigoASCII()==this.getClass().cast(o).getCodigoASCII())
	    	return true; 
	    else return false;
	}
	
}
