package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class Sol extends Nota {

	public Sol(){
		super(Constantes.FRECUENCIA_SOL);
	}
	
	public Sol(Figura unaFigura){
		super(Constantes.FRECUENCIA_SOL,unaFigura);
	}
	
}