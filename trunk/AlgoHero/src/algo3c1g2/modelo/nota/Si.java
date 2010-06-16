package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class Si extends Nota {

	//Frecuencia caracteristica del tono Si en la octava 3
	private final static float FRECUENCIA_SI = 493;
	
	public Si(){
		super(FRECUENCIA_SI);
	}
	
	public Si(Figura unaFigura){
		super(FRECUENCIA_SI,unaFigura);
	}
	
}