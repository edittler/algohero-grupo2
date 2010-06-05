package grupo2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import grupo2.modelo.ElementoDeCompas;
import grupo2.modelo.IteradorCliente;

public class Acorde extends ElementoDeCompas {

	private ArrayList<Nota> notas;
	
	public Acorde(){
		this.notas = new ArrayList<Nota>();
	}
		
	@Override //devuelve la duracion de la nota mas larga del acorde
	public double getDuracion() {
		Iterator<Nota> itNotas= this.getIteradorNotas();
		double duracion=0;
		while(itNotas.hasNext()){
			duracion=(itNotas.next().getDuracion()>duracion)? itNotas.next().getDuracion():duracion;
		}
		return duracion;
	}

	public Iterator<Nota> getIteradorNotas(){
		return new IteradorCliente<Nota>(this.notas);
	}
	
}
