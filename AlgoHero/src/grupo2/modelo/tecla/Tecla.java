package grupo2.modelo.tecla;

import grupo2.modelo.excepciones.TeclaNoAceptadaExcepcion;

public class Tecla {

	private int codigoASCII;

	public Tecla(int codigoASCII){
		this.setCodigoASCII(codigoASCII);
	}
	
	public void setCodigoASCII(int codigoASCII) {
		if ((codigoASCII<65)||(codigoASCII>90)){
			throw new TeclaNoAceptadaExcepcion(); //Solo se permiten ingresar teclas de la A a la Z (mayúsculas)
		}
		this.codigoASCII = codigoASCII;
	}

	public int getCodigoASCII() {
		return codigoASCII;
	}
	
	public char getTecla(){
		return (char)codigoASCII;
	}
	
}
