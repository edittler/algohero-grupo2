package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class DoSostenido extends Nota {

	public DoSostenido(){
		super(Constantes.FRECUENCIA_DO_SOSTENIDO);
	}
	
	public DoSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_DO_SOSTENIDO,unaFigura);
	}
	
}
