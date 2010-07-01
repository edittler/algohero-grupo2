package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class FaSostenido extends Nota {

	//Frecuencia caracteristica del tono Fa Sostenido en la octava 3
	private final static float FRECUENCIA_FA_SOSTENIDO = 66;
	private final static int CUERDA = 4;
	public FaSostenido(){
		super(FRECUENCIA_FA_SOSTENIDO);
	}
	
	public FaSostenido(Figura unaFigura){
		super(FRECUENCIA_FA_SOSTENIDO, unaFigura);
	}

	public int getCuerda() {
		return FaSostenido.CUERDA;
	}

}