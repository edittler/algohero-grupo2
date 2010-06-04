package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class Re extends Nota {

	public Re(){
		super(Constantes.FRECUENCIA_RE);
	}
	public Re(Figura unaFigura){
		super(Constantes.FRECUENCIA_RE,unaFigura);
	}
}
