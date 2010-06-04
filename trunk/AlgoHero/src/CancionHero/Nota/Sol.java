package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class Sol extends Nota {

	public Sol(){
		super(Constantes.FRECUENCIA_SOL);
	}
	public Sol(Figura unaFigura){
		super(Constantes.FRECUENCIA_SOL,unaFigura);
	}
}