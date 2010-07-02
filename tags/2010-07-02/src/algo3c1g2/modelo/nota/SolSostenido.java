package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class SolSostenido extends Nota {

	//Frecuencia caracteristica del tono Sol Sostenido en la octava 3
	private final static float FRECUENCIA_SOL_SOSTENIDO = 68;
	private final static int CUERDA = 5;
	
	public SolSostenido(){
		super(FRECUENCIA_SOL_SOSTENIDO);
	}
	
	public SolSostenido(Figura unaFigura){
		super(FRECUENCIA_SOL_SOSTENIDO, unaFigura);
	}

	public int getCuerda() {
		return SolSostenido.CUERDA;
	}
}
