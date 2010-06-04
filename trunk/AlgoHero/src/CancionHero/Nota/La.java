package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class La extends Nota {

	public La(){
		super(Constantes.FRECUENCIA_LA);
	}
	public La(Figura unaFigura){
		super(Constantes.FRECUENCIA_LA,unaFigura);
	}
}