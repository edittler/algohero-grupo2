package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Do extends Nota {

	//Frecuencia caracteristica del tono Do en la octava 3
	private final static float FRECUENCIA_DO = 261;
	private final static int UbicacionCuerdaDO=168;
	private final static int cuerda=1;
	
	public Do(){
		super(FRECUENCIA_DO);
	}
	
	public Do(Figura unaFigura){
		super(FRECUENCIA_DO,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		return UbicacionCuerdaDO;
	}

	public int getCuerda() {
		return Do.cuerda;
	}
}
