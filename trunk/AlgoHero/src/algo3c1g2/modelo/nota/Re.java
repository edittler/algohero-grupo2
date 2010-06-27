package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class Re extends Nota {

	//Frecuencia caracteristica del tono Re en la octava 3
	private final static float FRECUENCIA_RE = 293;
	private final static int CUERDA = 2;
	
	public Re(){
		super(FRECUENCIA_RE);
	}
	
	public Re(Figura unaFigura){
		super(FRECUENCIA_RE, unaFigura);
	}

	public int getCuerda() {
		return Re.CUERDA;
	}
	
}
