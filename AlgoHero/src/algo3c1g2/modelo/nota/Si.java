package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class Si extends Nota {

	//Frecuencia caracteristica del tono Si en la octava 3
	private final static float FRECUENCIA_SI = 71;
	private final static int CUERDA = 6;
	
	public Si(){
		super(FRECUENCIA_SI);
	}
	
	public Si(Figura unaFigura){
		super(FRECUENCIA_SI, unaFigura);
	}

	public int getCuerda() {
		return Si.CUERDA;
	}

}