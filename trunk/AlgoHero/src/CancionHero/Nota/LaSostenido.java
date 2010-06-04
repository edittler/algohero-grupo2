package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class LaSostenido extends Nota {

	public LaSostenido(){
		super(Constantes.FRECUENCIA_LA_SOSTENIDO);
	}
	public LaSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_LA_SOSTENIDO,unaFigura);
	}
}