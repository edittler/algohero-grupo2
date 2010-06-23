package programa;

import java.util.ArrayList;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.Do;
import algo3c1g2.modelo.nota.Nota;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Guitarra implements ObjetoVivo {

	private Cancion cancion;
	private double instanteActual;
	private ArrayList<ArrayList<Circulito>> cuerdas;
	
	public Guitarra(Cancion unaCancion,ArrayList<ArrayList<Circulito>> cuerdas){
		this.cancion=unaCancion;
		this.instanteActual=0.00;
		this.cuerdas=cuerdas;
	}
	@Override
	public void vivir() {
		this.addCirculito(cancion.getElemento(this.instanteActual));
		this.instanteActual+=0.015;
	}
	
	private void addCirculito(ElementoDeCompas elemento) {
		if(elemento!=null){
			if(elemento.isNota()){
				((Nota)elemento).ubicarCuerda(this.cuerdas);
			}
		}
	}
}
