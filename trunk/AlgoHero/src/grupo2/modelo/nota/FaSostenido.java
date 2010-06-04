package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class FaSostenido extends Nota {

	public FaSostenido(){
		super(Constantes.FRECUENCIA_FA_SOSTENIDO);
	}
	
	public FaSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_FA_SOSTENIDO,unaFigura);
	}
	
}