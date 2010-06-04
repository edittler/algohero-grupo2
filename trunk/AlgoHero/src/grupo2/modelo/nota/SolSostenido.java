package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class SolSostenido extends Nota {

	public SolSostenido(){
		super(Constantes.FRECUENCIA_SOL_SOSTENIDO);
	}
	
	public SolSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_SOL_SOSTENIDO,unaFigura);
	}
	
}
