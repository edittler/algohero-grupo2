package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class Si extends Nota {

	public Si(){
		super(Constantes.FRECUENCIA_SI);
	}
	
	public Si(Figura unaFigura){
		super(Constantes.FRECUENCIA_SI,unaFigura);
	}
	
}