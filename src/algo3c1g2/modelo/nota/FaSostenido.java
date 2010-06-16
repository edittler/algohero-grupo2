package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class FaSostenido extends Nota {

	public FaSostenido(){
		super(Constantes.FRECUENCIA_FA_SOSTENIDO);
	}
	
	public FaSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_FA_SOSTENIDO,unaFigura);
	}
	
}