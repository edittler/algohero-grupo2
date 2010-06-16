package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class Re extends Nota {

	//Frecuencia caracteristica del tono Re en la octava 3
	private final static float FRECUENCIA_RE = 293;
	
	public Re(){
		super(FRECUENCIA_RE);
	}
	
	public Re(Figura unaFigura){
		super(FRECUENCIA_RE,unaFigura);
	}
	
}
