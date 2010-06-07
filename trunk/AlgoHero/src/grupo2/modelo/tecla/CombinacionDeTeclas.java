package grupo2.modelo.tecla;

import grupo2.modelo.IteradorCliente;

import java.util.ArrayList;
import java.util.Iterator;


public class CombinacionDeTeclas {
	
private ArrayList<Tecla> teclas;

	public CombinacionDeTeclas(){
	this.teclas=new ArrayList<Tecla>();
	}
	
	public void agregarTecla(Tecla unaTecla){
		this.teclas.add(unaTecla);
	}
	
	public Iterator<Tecla> getIteradorTeclas(){
		return new IteradorCliente<Tecla>(this.teclas);
	}

	public boolean contains(Tecla unaTeclaPresionada) {
		Iterator<Tecla> itTecla=this.getIteradorTeclas();
		boolean resultado = false;
		while(itTecla.hasNext()&&!resultado){
			Tecla unaTecla=itTecla.next();
			resultado = (unaTecla.getCodigoASCII()==unaTeclaPresionada.getCodigoASCII());//TODO DEFINIR EQUALS
		}
		return resultado;
	}
}
