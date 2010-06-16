package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class La extends Nota {

	public La(){
		super(Constantes.FRECUENCIA_LA);
	}
	
	public La(Figura unaFigura){
		super(Constantes.FRECUENCIA_LA,unaFigura);
	}
	
}