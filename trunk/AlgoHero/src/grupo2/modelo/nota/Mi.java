package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class Mi extends Nota {

	public Mi(){
		super(Constantes.FRECUENCIA_MI);
	}
	
	public Mi(Figura unaFigura){
		super(Constantes.FRECUENCIA_MI,unaFigura);
	}
	
}