package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Fa extends Nota {

	//Frecuencia caracteristica del tono Fa en la octava 3
	private final static float FRECUENCIA_FA = 349;
	private final static int UbicacionCuerdaFa=345;
	public Fa(){
		super(FRECUENCIA_FA);
	}
	
	public Fa(Figura unaFigura){
		super(FRECUENCIA_FA,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		return UbicacionCuerdaFa;
	}

	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		itCuer.next();
	}

}