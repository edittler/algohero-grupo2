package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class LaSostenido extends Nota {

	public LaSostenido(){
		super(Constantes.FRECUENCIA_LA_SOSTENIDO);
	}
	
	public LaSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_LA_SOSTENIDO,unaFigura);
	}
	
}