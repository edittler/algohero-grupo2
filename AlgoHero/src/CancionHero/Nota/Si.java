package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class Si extends Nota {

	public Si(){
		super(Constantes.FRECUENCIA_SI);
	}
	public Si(Figura unaFigura){
		super(Constantes.FRECUENCIA_SI,unaFigura);
	}
}