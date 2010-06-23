package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class FaSostenido extends Nota {

	//Frecuencia caracteristica del tono Fa Sostenido en la octava 3
	private final static float FRECUENCIA_FA_SOSTENIDO = 369;
	private final static int UbicacionCuerdaFaSostenido=386;

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
	public void ubicarCuerda(ArrayList<ArrayList<Circulito>> cuerdas) {
		Iterator<ArrayList<Circulito>> itCuer=cuerdas.iterator();
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