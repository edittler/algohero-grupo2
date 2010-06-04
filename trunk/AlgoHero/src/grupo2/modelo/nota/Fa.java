package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class Fa extends Nota {

	public Fa(){
		super(Constantes.FRECUENCIA_FA);
	}
	
	public Fa(Figura unaFigura){
		super(Constantes.FRECUENCIA_FA,unaFigura);
	}
	
}