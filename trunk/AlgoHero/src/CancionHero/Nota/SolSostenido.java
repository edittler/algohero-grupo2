package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class SolSostenido extends Nota {

	public SolSostenido(){
		super(Constantes.FRECUENCIA_SOL_SOSTENIDO);
	}
	public SolSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_SOL_SOSTENIDO,unaFigura);
	}
}
