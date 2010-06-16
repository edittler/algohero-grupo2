package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class Re extends Nota {

	public Re(){
		super(Constantes.FRECUENCIA_RE);
	}
	
	public Re(Figura unaFigura){
		super(Constantes.FRECUENCIA_RE,unaFigura);
	}
	
}
