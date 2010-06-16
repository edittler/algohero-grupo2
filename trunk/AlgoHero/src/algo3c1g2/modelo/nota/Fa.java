package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class Fa extends Nota {

	//Frecuencia caracteristica del tono Fa en la octava 3
	private final static float FRECUENCIA_FA = 349;
	
	public Fa(){
		super(FRECUENCIA_FA);
	}
	
	public Fa(Figura unaFigura){
		super(FRECUENCIA_FA,unaFigura);
	}
	
}