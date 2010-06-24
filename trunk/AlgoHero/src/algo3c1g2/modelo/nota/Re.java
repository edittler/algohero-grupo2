package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Re extends Nota {

	//Frecuencia caracteristica del tono Re en la octava 3
	private final static float FRECUENCIA_RE = 293;
	private final static int UbicacionCuerdaRe=257;

	public Re(){
		super(FRECUENCIA_RE);
	}
	
	public Re(Figura unaFigura){
		super(FRECUENCIA_RE,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaRe;
	}

	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		
	}
}
