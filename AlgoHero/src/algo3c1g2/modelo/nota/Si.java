package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class Si extends Nota {

	//Frecuencia caracteristica del tono Si en la octava 3
	private final static float FRECUENCIA_SI = 493;
	private final static int UbicacionCuerdaSi=520;

	public Si(){
		super(FRECUENCIA_SI);
	}
	
	public Si(Figura unaFigura){
		super(FRECUENCIA_SI,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaSi;
	}
	public void ubicarCuerda(ArrayList<ArrayList<Circulito>> cuerdas) {
		Iterator<ArrayList<Circulito>> itCuer=cuerdas.iterator();
		itCuer.next();
		itCuer.next();
		itCuer.next();
		itCuer.next();
		itCuer.next();
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