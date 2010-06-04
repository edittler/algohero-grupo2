package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class ReSostenido extends Nota {

	public ReSostenido(){
		super(Constantes.FRECUENCIA_RE_SOSTENIDO);
	}
	
	public ReSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_RE_SOSTENIDO,unaFigura);
	}
	
}