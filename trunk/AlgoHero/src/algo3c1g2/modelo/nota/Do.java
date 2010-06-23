package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Do extends Nota {

	//Frecuencia caracteristica del tono Do en la octava 3
	private final static float FRECUENCIA_DO = 261;
	private final static int UbicacionCuerdaDO=155;
	
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

	@Override
	public void ubicarCuerda(ArrayList<ArrayList<Circulito>> cuerdas) {
	Iterator<ArrayList<Circulito>> itCuer=cuerdas.iterator();
	Iterator<Circulito> itCir =itCuer.next().iterator();
	boolean habilito=false;
	while(itCir.hasNext()&&!habilito){
		Circulito unCirculito=itCir.next();
		if(!unCirculito.estaHabilitado()){
			unCirculito.habilitar();
			habilito=true;
		}
	}
	}
	
}
