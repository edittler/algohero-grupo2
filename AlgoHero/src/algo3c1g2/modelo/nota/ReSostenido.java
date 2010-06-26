package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class ReSostenido extends Nota {

	//Frecuencia caracteristica del tono Re Sostenido en la octava 3
	private final static float FRECUENCIA_RE_SOSTENIDO = 311;
	private final static int UbicacionCuerdaReSostenido=257;
	private final static int cuerda=2;
	
	public ReSostenido(){
		super(FRECUENCIA_RE_SOSTENIDO);
	}
	
	public ReSostenido(Figura unaFigura){
		super(FRECUENCIA_RE_SOSTENIDO,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaReSostenido;
	}

	public int getCuerda() {
		return ReSostenido.cuerda;
	}
	
}