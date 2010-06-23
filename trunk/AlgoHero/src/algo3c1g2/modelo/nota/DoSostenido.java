package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class DoSostenido extends Nota {

	//Frecuencia caracteristica del tono Do Sostenido en la octava 3
	private final static float FRECUENCIA_DO_SOSTENIDO = 277;
	private final static int UbicacionCuerdaDOSostenido=155;
	public DoSostenido(){
		super(FRECUENCIA_DO_SOSTENIDO);
	}
	
	public DoSostenido(Figura unaFigura){
		super(FRECUENCIA_DO_SOSTENIDO,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		return UbicacionCuerdaDOSostenido;
	}
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
