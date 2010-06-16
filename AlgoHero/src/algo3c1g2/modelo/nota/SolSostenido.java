package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class SolSostenido extends Nota {

	//Frecuencia caracteristica del tono Sol Sostenido en la octava 3
	private final static float FRECUENCIA_SOL_SOSTENIDO = 415;
	
	public SolSostenido(){
		super(FRECUENCIA_SOL_SOSTENIDO);
	}
	
	public SolSostenido(Figura unaFigura){
		super(FRECUENCIA_SOL_SOSTENIDO,unaFigura);
	}
	
}
