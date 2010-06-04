package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class Re extends Nota {

	public Re(){
		super(Constantes.FRECUENCIA_RE);
	}
	
	public Re(Figura unaFigura){
		super(Constantes.FRECUENCIA_RE,unaFigura);
	}
	
}
