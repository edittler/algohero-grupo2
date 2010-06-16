package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class Do extends Nota {

	//Frecuencia caracteristica del tono Do en la octava 3
	private final static float FRECUENCIA_DO = 261;
	
	public Do(){
		super(FRECUENCIA_DO);
	}
	
	public Do(Figura unaFigura){
		super(FRECUENCIA_DO,unaFigura);
	}
	
}
