package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class Si extends Nota {

	public Si(){
		super(Constantes.FRECUENCIA_SI);
	}
	
	public Si(Figura unaFigura){
		super(Constantes.FRECUENCIA_SI,unaFigura);
	}
	
}