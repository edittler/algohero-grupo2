package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class La extends Nota {

	public La(){
		super(Constantes.FRECUENCIA_LA);
	}
	
	public La(Figura unaFigura){
		super(Constantes.FRECUENCIA_LA,unaFigura);
	}
	
}