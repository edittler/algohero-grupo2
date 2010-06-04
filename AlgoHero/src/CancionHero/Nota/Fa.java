package CancionHero.Nota;

import CancionHero.Figura.Figura;
import Constantes.Constantes;

public class Fa extends Nota {

	public Fa(){
		super(Constantes.FRECUENCIA_FA);
	}
	public Fa(Figura unaFigura){
		super(Constantes.FRECUENCIA_FA,unaFigura);
	}
}