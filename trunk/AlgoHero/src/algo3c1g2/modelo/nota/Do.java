package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class Do extends Nota {

	//Frecuencia caracteristica del tono Do en la octava 3
	private final static int FRECUENCIA_DO = 60;
	private final static int CUERDA = 1;
	
	public Do(){
		super(FRECUENCIA_DO);
	}
	
	public Do(Figura unaFigura){
		super(FRECUENCIA_DO, unaFigura);
	}

	public int getCuerda() {
		return Do.CUERDA;
	}
}
