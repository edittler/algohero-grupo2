package algo3c1g2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Cuerda {

	private ArrayList<Circulito> circulitos;


	public Cuerda() {
		this.circulitos=new ArrayList<Circulito>();

	}

	public Iterator<Circulito> iterator() {
		IteradorCliente<Circulito> unIterator = new IteradorCliente<Circulito>(
				this.circulitos);
		return unIterator;
	}



	/* Habilita el 1er circulito que encuentra deshabilitado en la cuerda */
	public Circulito habilitarUnCirculito(String TeclasEnString) {
		Iterator<Circulito> itCir = this.iterator();

		Circulito unCirculito = null;
		boolean habilito = false;

		// Recorro los circulitos de la cuerda
		while (itCir.hasNext() && (!habilito)) { 
			unCirculito = itCir.next();

			// Si no esta habilitado lo habilito y termino el while
			if (!unCirculito.estaHabilitado()) { 
				unCirculito.habilitar();
				habilito = true;
				unCirculito.setTeclas(TeclasEnString);
			}
		}
		return unCirculito; // Devuelvo el Circulito habilitado
	}


	public void agregarCirculito(Circulito unCirculito) {
		this.circulitos.add(unCirculito);

	}

}
