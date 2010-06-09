package algo3c1g2.modelo.nota;

import algo3c1g2.modelo.constantes.*;
import algo3c1g2.modelo.figura.*;

public class Do extends Nota {

	public Do(){
		super(Constantes.FRECUENCIA_DO);
	}
	
	public Do(Figura unaFigura){
		super(Constantes.FRECUENCIA_DO,unaFigura);
	}
	
}
