package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class LaSostenido extends Nota {

	public LaSostenido(){
		super(Constantes.FRECUENCIA_LA_SOSTENIDO);
	}
	
	public LaSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_LA_SOSTENIDO,unaFigura);
	}
	
}