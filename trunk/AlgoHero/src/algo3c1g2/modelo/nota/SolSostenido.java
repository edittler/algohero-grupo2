package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class SolSostenido extends Nota {

	//Frecuencia caracteristica del tono Sol Sostenido en la octava 3
	private final static float FRECUENCIA_SOL_SOSTENIDO = 415;
	private final static int UbicacionCuerdaSolSostenido=504;
	private final static int cuerda=5;
	
	public SolSostenido(){
		super(FRECUENCIA_SOL_SOSTENIDO);
	}
	
	public SolSostenido(Figura unaFigura){
		super(FRECUENCIA_SOL_SOSTENIDO,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaSolSostenido;
	}

	public int getCuerda() {
		return SolSostenido.cuerda;
	}
}
