package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class Sol extends Nota {

	//Frecuencia caracteristica del tono Sol en la octava 3
	private final static float FRECUENCIA_SOL = 67;
	private final static int CUERDA = 4;
	
	public Sol(){
		super(FRECUENCIA_SOL);
	}
	
	public Sol(Figura unaFigura){
		super(FRECUENCIA_SOL, unaFigura);
	}

	public int getCuerda() {
		return Sol.CUERDA;
	}
	
}