package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class ReSostenido extends Nota {

	public ReSostenido(){
		super(Constantes.FRECUENCIA_RE_SOSTENIDO);
	}
	
	public ReSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_RE_SOSTENIDO,unaFigura);
	}
	
}