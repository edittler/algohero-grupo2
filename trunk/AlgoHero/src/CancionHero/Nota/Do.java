package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class Do extends Nota {

	public Do(){
		super(Constantes.FRECUENCIA_DO);
	}
	
	public Do(Figura unaFigura){
		super(Constantes.FRECUENCIA_DO,unaFigura);
	}
	
}
