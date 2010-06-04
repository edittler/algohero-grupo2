package CancionHero.Tecla;

import java.util.ArrayList;
import java.util.Iterator;

public class CombinacionDeTeclas {
	
private ArrayList<Tecla> teclas;
private Iterator<Tecla> itTeclas;

	public CombinacionDeTeclas(){
	this.teclas=new ArrayList<Tecla>();
	this.itTeclas= this.teclas.iterator();
	}
	
	public void agregarTecla(Tecla unaTecla){
		this.teclas.add(unaTecla);
	}
	public Tecla obtenerTecla(){
		return this.itTeclas.next();
	}
}
