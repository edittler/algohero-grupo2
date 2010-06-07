package grupo2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import grupo2.modelo.ElementoDeCompas;
import grupo2.modelo.IteradorCliente;
import grupo2.modelo.tecla.CombinacionDeTeclas;
import grupo2.modelo.tecla.MapaDeTeclas;

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
	
	public boolean chequear(MapaDeTeclas mapeo,
			CombinacionDeTeclas teclasPresionadas){
		return false; //TODO hay que implementar este metodo
	}
}
