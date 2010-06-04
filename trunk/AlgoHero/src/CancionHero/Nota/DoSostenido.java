package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class DoSostenido extends Nota {

	public DoSostenido(){
		super(Constantes.FRECUENCIA_DO_SOSTENIDO);
	}
	public DoSostenido(Figura unaFigura){
		super(Constantes.FRECUENCIA_DO_SOSTENIDO,unaFigura);
	}
	
}
