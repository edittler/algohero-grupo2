package grupo2.modelo.nota;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.figura.*;

public class Do extends Nota {

	public Do(){
		super(Constantes.FRECUENCIA_DO);
	}
	
	public Do(Figura unaFigura){
		super(Constantes.FRECUENCIA_DO,unaFigura);
	}
	
}
