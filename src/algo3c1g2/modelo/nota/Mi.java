package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class Mi extends Nota {

	public Mi(){
		super(Constantes.FRECUENCIA_MI);
	}
	
	public Mi(Figura unaFigura){
		super(Constantes.FRECUENCIA_MI,unaFigura);
	}
	
}