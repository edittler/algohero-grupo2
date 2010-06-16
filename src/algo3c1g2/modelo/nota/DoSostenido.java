package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class DoSostenido extends Nota {

	public DoSostenido(){
		super(Constantes.FRECUENCIA_DO_SOSTENIDO);
	}
	
	public DoSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_DO_SOSTENIDO,unaFigura);
	}
	
}
