package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;
import algo3c1g2.modelo.figura.*;

public class LaSostenido extends Nota {

	//Frecuencia caracteristica del tono La Sostenido en la octava 3
	private final static float FRECUENCIA_LA_SOSTENIDO = 466;
	private final static int UbicacionCuerdaLaSostenido=520;

	public LaSostenido(){
		super(FRECUENCIA_LA_SOSTENIDO);
	}
	
	public LaSostenido(Figura unaFigura){
		super(FRECUENCIA_LA_SOSTENIDO,unaFigura);
	}

	@Override
	public int ubicacionCuerda() {
		// TODO Auto-generated method stub
		return UbicacionCuerdaLaSostenido;
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