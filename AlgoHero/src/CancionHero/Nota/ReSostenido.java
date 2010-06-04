package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class ReSostenido extends Nota {

	public ReSostenido(){
		super(Constantes.FRECUENCIA_RE_SOSTENIDO);
	}
	public ReSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_RE_SOSTENIDO,unaFigura);
	}
}