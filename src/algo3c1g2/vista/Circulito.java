package algo3c1g2.vista;

import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.vista.images.ImageCirculito;
import algo3c1g2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Circulito implements ObjetoVivo, Posicionable {

	private static final int POSICION_INICIAL_Y = -85;

	private int x;
	private int y;
	private ImageCirculito vista;
	private Nota nota;
	private boolean habilitado;
	private boolean fueReproducido;
	public static int pixelesPorCiclo;

	public Circulito(int ubicacionEnX) {
		this.x = ubicacionEnX;
		this.y = POSICION_INICIAL_Y;
		this.habilitado = false;
		this.fueReproducido = false;
	}

	public boolean estaHabilitado() {
		return this.habilitado;
	}

	public void habilitar() {
		this.habilitado = true;
	}

	public void reiniciar() {
		this.y = POSICION_INICIAL_Y;
		this.habilitado = false;
		this.vista.establecerImagenOriginal();
		this.fueReproducido = false;
	}

	@Override
	public void vivir() {
		if (habilitado) {
			this.y = this.y + Circulito.pixelesPorCiclo;
		}
		if (this.y > VentanaPrincipal.TAMAÑO_VERTICAL) {
			this.reiniciar();
		}
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public void setDibujable(ImageCirculito imageCirculito) {
		this.vista = imageCirculito;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Nota getNota() {
		return nota;
	}

	public void establecerQueFueReproducido() {
		this.vista.establecerImagenDeReproducido();
		this.fueReproducido = true;
	}

	public boolean fueReproducido() {
		return fueReproducido;
	}

}
