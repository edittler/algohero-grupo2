package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Mi extends Nota {

	//Frecuencia caracteristica del tono Mi en la octava 3
	public final static float FRECUENCIA_MI = 329;
	private final static int UbicacionCuerdaLaSostenido=345;

	public Mi(){
		super(FRECUENCIA_MI);
	}
	
	public Mi(Figura unaFigura){
		super(FRECUENCIA_MI,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaLaSostenido;
	}

	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		itCuer.next();
	}
}