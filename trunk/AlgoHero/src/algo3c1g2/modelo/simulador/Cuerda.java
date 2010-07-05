package algo3c1g2.modelo.simulador;

import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.IteradorCliente;
import algo3c1g2.modelo.nota.Nota;

public class Cuerda {

	private ArrayList<Circulito> circulitos;

	public Cuerda() {
		this.circulitos=new ArrayList<Circulito>();
	}

	public Iterator<Circulito> iteradorCirculitos() {
		IteradorCliente<Circulito> unIterator = new IteradorCliente<Circulito>(
				this.circulitos);
		return unIterator;
	}

	public void agregarCirculito(Circulito unCirculito) {
		this.circulitos.add(unCirculito);
	}
	
	/* Habilita el 1er circulito que encuentra deshabilitado en la cuerda */
	public Circulito habilitarUnCirculito(String TeclasEnString,int frecuencia,int duracion,double instanteASerReproducido) {
		Iterator<Circulito> itCir = this.iteradorCirculitos();

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
				unCirculito.setFrecuencia(frecuencia);
				unCirculito.setDuracion(duracion);
				unCirculito.setInstanteASerReproducido(instanteASerReproducido);
			}
		}
		return unCirculito; // Devuelvo el Circulito habilitado
	}
	
}
