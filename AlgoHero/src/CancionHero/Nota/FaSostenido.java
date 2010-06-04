package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class FaSostenido extends Nota {

	public FaSostenido(){
		super(Constantes.FRECUENCIA_FA_SOSTENIDO);
	}
	
	public FaSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_FA_SOSTENIDO,unaFigura);
	}
}