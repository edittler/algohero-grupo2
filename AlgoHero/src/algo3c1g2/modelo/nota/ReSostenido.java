package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class ReSostenido extends Nota {

	//Frecuencia caracteristica del tono Re Sostenido en la octava 3
	private final static int FRECUENCIA_RE_SOSTENIDO = 63;
	private final static int CUERDA = 2;
	
	public ReSostenido(){
		super(FRECUENCIA_RE_SOSTENIDO);
	}
	
	public ReSostenido(Figura unaFigura){
		super(FRECUENCIA_RE_SOSTENIDO, unaFigura);
	}

	public int getCuerda() {
		return ReSostenido.CUERDA;
	}
	
}