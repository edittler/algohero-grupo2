package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class La extends Nota {

	//Frecuencia caracteristica del tono La en la octava 3
	private final static float FRECUENCIA_LA = 440;
	
	public La(){
		super(FRECUENCIA_LA);
	}
	
	public La(Figura unaFigura){
		super(FRECUENCIA_LA,unaFigura);
	}
	
}