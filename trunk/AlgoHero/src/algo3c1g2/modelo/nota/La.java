package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class La extends Nota {

	//Frecuencia caracteristica del tono La en la octava 3
	private final static float FRECUENCIA_LA = 440;
	private final static int UbicacionCuerdaLa=504;

	public La(){
		super(FRECUENCIA_LA);
	}
	
	public La(Figura unaFigura){
		super(FRECUENCIA_LA,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaLa;
	}

	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		itCuer.next();
		itCuer.next();
		itCuer.next();
	}
}