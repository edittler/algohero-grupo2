package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class La extends Nota {

	//Frecuencia caracteristica del tono La en la octava 3
	private final static float FRECUENCIA_LA = 440;
	private final static int CUERDA = 5;
	
	public La(){
		super(FRECUENCIA_LA);
	}
	
	public La(Figura unaFigura){
		super(FRECUENCIA_LA, unaFigura);
	}

	public int getCuerda() {
		return La.CUERDA;
	}
	
}