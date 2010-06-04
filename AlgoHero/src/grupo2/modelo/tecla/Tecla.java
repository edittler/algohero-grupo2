package grupo2.modelo.tecla;

public class Tecla {

	private int codigoASCII;

	public Tecla(int codigoASCII){
		this.setCodigoASCII(codigoASCII);
	}
	
	public void setCodigoASCII(int codigoASCII) {
		this.codigoASCII = codigoASCII;
	}

	public int getCodigoASCII() {
		return codigoASCII;
	}
	
	public char getTecla(){
		return (char)codigoASCII;
	}
	
}
