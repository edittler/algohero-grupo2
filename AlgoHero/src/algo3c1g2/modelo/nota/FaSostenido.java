package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class FaSostenido extends Nota {

	//Frecuencia caracteristica del tono Fa Sostenido en la octava 3
	private final static float FRECUENCIA_FA_SOSTENIDO = 369;
	private final static int UbicacionCuerdaFaSostenido=427;

	public FaSostenido(){
		super(FRECUENCIA_FA_SOSTENIDO);
	}
	
	public FaSostenido(Figura unaFigura){
		super(FRECUENCIA_FA_SOSTENIDO,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		
		return UbicacionCuerdaFaSostenido;
	}


	@Override
	protected void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer) {
		itCuer.next();
		itCuer.next();
		itCuer.next();
	}
}