package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.*;

public class DoSostenido extends Nota {

	//Frecuencia caracteristica del tono Do Sostenido en la octava 3
	private final static float FRECUENCIA_DO_SOSTENIDO = 277;
	
	public DoSostenido(){
		super(FRECUENCIA_DO_SOSTENIDO);
	}
	
	public DoSostenido(Figura unaFigura){
		super(FRECUENCIA_DO_SOSTENIDO,unaFigura);
	}
	
}
