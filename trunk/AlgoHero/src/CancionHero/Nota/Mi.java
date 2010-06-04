package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class Mi extends Nota {

	public Mi(){
		super(Constantes.FRECUENCIA_MI);
	}
	public Mi(Figura unaFigura){
		super(Constantes.FRECUENCIA_MI,unaFigura);
	}
}