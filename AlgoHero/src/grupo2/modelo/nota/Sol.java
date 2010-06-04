package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class Sol extends Nota {

	public Sol(){
		super(Constantes.FRECUENCIA_SOL);
	}
	
	public Sol(Figura unaFigura){
		super(Constantes.FRECUENCIA_SOL,unaFigura);
	}
	
}