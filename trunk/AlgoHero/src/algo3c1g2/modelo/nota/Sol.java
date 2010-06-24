package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Sol extends Nota {

	//Frecuencia caracteristica del tono Sol en la octava 3
	private final static float FRECUENCIA_SOL = 391;
	private final static int UbicacionCuerdaSol=427;

	public Sol(){
		super(FRECUENCIA_SOL);
	}
	
	public Sol(Figura unaFigura){
		super(FRECUENCIA_SOL,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaSol;
	}


	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		itCuer.next();
		itCuer.next();
	}
}