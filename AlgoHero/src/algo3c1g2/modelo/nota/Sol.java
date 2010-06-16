package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class Sol extends Nota {

	//Frecuencia caracteristica del tono Sol en la octava 3
	private final static float FRECUENCIA_SOL = 391;
	
	public Sol(){
		super(FRECUENCIA_SOL);
	}
	
	public Sol(Figura unaFigura){
		super(FRECUENCIA_SOL,unaFigura);
	}
	
}