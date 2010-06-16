package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class Mi extends Nota {

	//Frecuencia caracteristica del tono Mi en la octava 3
	public final static float FRECUENCIA_MI = 329;
	
	public Mi(){
		super(FRECUENCIA_MI);
	}
	
	public Mi(Figura unaFigura){
		super(FRECUENCIA_MI,unaFigura);
	}
	
}