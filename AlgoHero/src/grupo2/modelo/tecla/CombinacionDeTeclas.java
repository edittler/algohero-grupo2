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
}
