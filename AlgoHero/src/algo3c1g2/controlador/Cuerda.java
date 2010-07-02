package algo3c1g2.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import algo3c1g2.modelo.IteradorCliente;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.vista.Circulito;
import algo3c1g2.vista.images.ImageCirculito;

public class Cuerda {

	private ArrayList<Circulito> circulitos;
	private ArrayList<ImageCirculito> vistas;

	public Cuerda(int ubicacionDeLaCuerda, int cantidadCirculitos) {
		this.circulitos = new ArrayList<Circulito>();
		this.vistas = new ArrayList<ImageCirculito>();
		Circulito unCirculito = null;
		ImageCirculito vistaCir = null;
		for (int i = 0; i < cantidadCirculitos; i++) {
			unCirculito = new Circulito(ubicacionDeLaCuerda);
			vistaCir = new ImageCirculito();
			vistaCir.setPosicionable(unCirculito);
			unCirculito.setDibujable(vistaCir);
			this.circulitos.add(unCirculito);
			this.vistas.add(vistaCir);
		}
	}

	public Iterator<Circulito> iterator() {
		IteradorCliente<Circulito> unIterator = new IteradorCliente<Circulito>(
				this.circulitos);
		return unIterator;
	}

	public Iterator<ImageCirculito> iteratorVista() {
		IteradorCliente<ImageCirculito> unIterator = new IteradorCliente<ImageCirculito>(this.vistas);
		return unIterator;
	}

	/* Habilita el 1er circulito que encuentra deshabilitado en la cuerda */
	public Circulito habilitarUnCirculito(Nota nota) {
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
				unCirculito.setNota(nota);
			}
		}
		return unCirculito; // Devuelvo el Circulito habilitado
	}

	public ImageCirculito getVista(Circulito unCirculito) {
		Iterator<ImageCirculito> itVista = this.vistas.iterator();
		ImageCirculito resultado = null;
		boolean encontro = false;
		while (itVista.hasNext() && !encontro) {
			resultado = itVista.next();
			encontro = (resultado.getPosicionable() == unCirculito);
		}
		return resultado;
	}

}
