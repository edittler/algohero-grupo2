package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class Fa extends Nota {

	public Fa(){
		super(Constantes.FRECUENCIA_FA);
	}
	
	public Fa(Figura unaFigura){
		super(Constantes.FRECUENCIA_FA,unaFigura);
	}
	
}