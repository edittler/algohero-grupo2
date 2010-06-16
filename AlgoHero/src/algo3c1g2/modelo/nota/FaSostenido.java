package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class FaSostenido extends Nota {

	//Frecuencia caracteristica del tono Fa Sostenido en la octava 3
	private final static float FRECUENCIA_FA_SOSTENIDO = 369;
	
	public FaSostenido(){
		super(FRECUENCIA_FA_SOSTENIDO);
	}
	
	public FaSostenido(Figura unaFigura){
		super(FRECUENCIA_FA_SOSTENIDO,unaFigura);
	}
	
}