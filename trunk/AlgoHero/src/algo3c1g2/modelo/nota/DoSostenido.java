package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.figura.Figura;

public class DoSostenido extends Nota {

	//Frecuencia caracteristica del tono Do Sostenido en la octava 3
	private final static float FRECUENCIA_DO_SOSTENIDO = 277;
	private final static int CUERDA = 1;
	
	public DoSostenido(){
		super(FRECUENCIA_DO_SOSTENIDO);

	}
	
	public DoSostenido(Figura unaFigura){
		super(FRECUENCIA_DO_SOSTENIDO, unaFigura);
	}


	public int getCuerda() {
		return DoSostenido.CUERDA;
	}

}
